package functionalprogramming;

import functionalprogramming.model.Order;
import functionalprogramming.model.OrderLine;
import functionalprogramming.model.OrderLineAggregationPriceProcessor;
import functionalprogramming.model.TaxPriceProcessor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Chapter32_FuctionComposiotion {
    public static void main(String[] args) {
        Function<Integer, Integer> multipluByTwo = x -> 2 * x;
        Function<Integer, Integer> addTEn = x -> x + 10;

        Function<Integer, Integer> composedFunction = multipluByTwo.andThen(addTEn);
        System.out.println(composedFunction.apply(3));

        Order unProcessedOrder = Order.builder()
                .id(1001L)
                .orderLines(Arrays.asList(
                        new OrderLine(1,BigDecimal.valueOf(1000)),
                        new OrderLine(2,BigDecimal.valueOf(2000))
                ))
                .build();
        List<Function<Order, Order>> priceProcessors = getPriceProcessors(unProcessedOrder);

        Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
                .reduce(Function.identity(), Function::andThen);

        Order processedOrder = mergedPriceProcessors.apply(unProcessedOrder);
        System.out.println(processedOrder);
    }

    public static List<Function<Order, Order>> getPriceProcessors(Order order){
        return Arrays.asList(new OrderLineAggregationPriceProcessor(),
                new TaxPriceProcessor(new BigDecimal("9.375")));
    }
}
