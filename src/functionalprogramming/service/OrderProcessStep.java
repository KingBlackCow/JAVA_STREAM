package functionalprogramming.service;

import functionalprogramming.model.Order;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class OrderProcessStep {
    private final Consumer<Order> processOrder;
    private OrderProcessStep next;

    public OrderProcessStep setNext(OrderProcessStep next) {
        if (this.next == null) {
            this.next = next;
        } else {
            this.next.setNext(next);
        }
        return this;
    }

    public void process(Order order) {
        processOrder.accept(order);
        Optional.ofNullable(next)
                .ifPresent(nextStep -> nextStep.process(order));
    }
}
