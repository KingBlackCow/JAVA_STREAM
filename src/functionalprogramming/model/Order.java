package functionalprogramming.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private long id;
    private LocalDateTime createdAt;
    private long createdByUserId;
    private OrderStatus status;
    private BigDecimal amount;
    private List<OrderLine> orderLines;

    public enum OrderStatus{
        CREATED,
        IN_PROGRESS,
        ERROR,
        PROCESSED
    }

    @Builder
    public Order(long id, OrderStatus orderStatus) {
        this.id = id;
        this.status = orderStatus;
    }
}
