package functionalprogramming.model;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.function.Function;

@RequiredArgsConstructor
public class TaxPriceProcessor implements Function<Order, Order> {

    private final BigDecimal taxRate;

    @Override
    public Order apply(Order order) {
        order.setAmount(order.getAmount().multiply(taxRate.divide(new BigDecimal(100)).add(BigDecimal.ONE)));
        return order;
    }
}
