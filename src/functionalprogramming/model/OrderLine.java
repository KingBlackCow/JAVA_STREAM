package functionalprogramming.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class OrderLine {
    private long id;
    private OrderLineType type;
    private long productId;
    private int quantity;
    private BigDecimal amount;

    public enum OrderLineType{
        PURCHASE,
        DISCOUNT
    }

    public OrderLine(long id, OrderLineType type, BigDecimal amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }
}
