package food.delivery.infra;
import food.delivery.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class RestaurantHateoasProcessor implements RepresentationModelProcessor<EntityModel<Restaurant>>  {

    @Override
    public EntityModel<Restaurant> process(EntityModel<Restaurant> model) {

        
        return model;
    }
    
}
