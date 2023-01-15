package food.delivery.domain;

import food.delivery.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private String menuId;
    private String status;
    private Integer qty;
    private String address;
}
