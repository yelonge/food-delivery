package food.delivery.domain;

import food.delivery.domain.Accepted;
import food.delivery.domain.Rejected;
import food.delivery.domain.CookStarted;
import food.delivery.domain.CookFinished;
import food.delivery.RestaurantApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Restaurant_table")
@Data

public class Restaurant  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String menuId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String customerId;

    @PostPersist
    public void onPostPersist(){


        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();



        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();

    }

    public static RestaurantRepository repository(){
        RestaurantRepository restaurantRepository = RestaurantApplication.applicationContext.getBean(RestaurantRepository.class);
        return restaurantRepository;
    }




    public static void cancelOrder(Rejected rejected){

        /** Example 1:  new item 
        Restaurant restaurant = new Restaurant();
        repository().save(restaurant);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(restaurant->{
            
            restaurant // do something
            repository().save(restaurant);


         });
        */

        
    }
    public static void cancelOrder(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Restaurant restaurant = new Restaurant();
        repository().save(restaurant);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(restaurant->{
            
            restaurant // do something
            repository().save(restaurant);


         });
        */

        
    }


}
