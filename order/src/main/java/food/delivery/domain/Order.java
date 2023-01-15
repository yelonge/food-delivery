package food.delivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="Order_table")
@Data
public class Order {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String orderId;
        private String status;
        private String customerId;
        private String menuId;
        private Integer qty;
        private String address;


}
