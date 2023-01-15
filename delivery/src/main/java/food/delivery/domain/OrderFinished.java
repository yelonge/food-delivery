package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderFinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String menuId;
    private String customerId;
    private String address;
    private Integer qty;
    private String status;

    public OrderFinished(Delivery aggregate){
        super(aggregate);
    }
    public OrderFinished(){
        super();
    }
}
