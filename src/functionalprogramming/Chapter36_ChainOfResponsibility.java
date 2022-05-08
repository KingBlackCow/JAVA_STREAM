package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;
import functionalprogramming.model.OrderLine;
import functionalprogramming.service.InternalMemberService;
import functionalprogramming.service.MemberService;
import functionalprogramming.service.MemberServiceInFunctionalWay;
import functionalprogramming.service.OrderProcessStep;

import java.math.BigDecimal;
import java.util.Arrays;

public class Chapter36_ChainOfResponsibility {
    public static void main(String[] args) {
        OrderProcessStep initializeStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.CREATED) {
                System.out.println("Start processing order " + order.getId());
                order.setStatus(Order.OrderStatus.IN_PROGRESS);
            }
        });

        OrderProcessStep setOrderAmountStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("Setting amount of order " + order.getId());
                order.setAmount(order.getOrderLines().stream()
                        .map(OrderLine::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        });

        OrderProcessStep verifyOrderStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("Verify order " + order.getId());
                if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                    order.setStatus(Order.OrderStatus.ERROR);
                }
            }
        });

        OrderProcessStep processPaymentStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("Processing payment of order " + order.getId());
                order.setStatus(Order.OrderStatus.PROCESSED);
            }
        });

        OrderProcessStep handleErrorStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.ERROR) {
                System.out.println("Sending out 'Failed to process order' alert for order " + order.getId());
            }
        });

        OrderProcessStep completeProcessingOrderStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.PROCESSED) {
                System.out.println("Finish process Order" + order.getId());
            }
        });

        OrderProcessStep chainedOrderProcessSteps = initializeStep
                .setNext(setOrderAmountStep)
                .setNext(verifyOrderStep)
                .setNext(processPaymentStep)
                .setNext(handleErrorStep)
                .setNext(completeProcessingOrderStep);

        Order order = Order.builder()
                .id(1001L)
                .orderStatus(Order.OrderStatus.CREATED)
                .orderLines(Arrays.asList(new OrderLine(1L, BigDecimal.valueOf(1000)), new OrderLine(2L, BigDecimal.valueOf(2000))))
                .build();

        Order failedOrder = Order.builder()
                .id(1001L)
                .orderStatus(Order.OrderStatus.CREATED)
                .orderLines(Arrays.asList(new OrderLine(1L, BigDecimal.valueOf(1000)), new OrderLine(2L, BigDecimal.valueOf(-2000))))
                .build();

        chainedOrderProcessSteps.process(order);
        chainedOrderProcessSteps.process(failedOrder);

    }
}
