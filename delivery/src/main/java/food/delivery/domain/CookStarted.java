package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String menuId;
    private String status;
    private Integer qty;
    private String address;
    private String customerId;
}


