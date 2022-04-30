package functionalprogramming.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    public Order(long id, OrderStatus orderStatus, long createdByUserId) {
        this.id = id;
        this.status = orderStatus;
        this.createdByUserId= createdByUserId;
    }
}
