package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Rejected extends AbstractEvent {

    private Long id;
    private String orderId;
    private String menuId;
    private String status;
    private Integer qty;
    private String address;
    private String customerId;

    public Rejected(Restaurant aggregate){
        super(aggregate);
    }
    public Rejected(){
        super();
    }
}
