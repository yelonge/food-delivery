package food.delivery.common;

import food.delivery.RestaurantApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RestaurantApplication.class })
public class CucumberSpingConfiguration {}
