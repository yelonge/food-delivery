package food.delivery.infra;

import food.delivery.config.kafka.KafkaProcessor;
import food.delivery.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderViewHandler {

    @Autowired
    private OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Order order = new Order();
            // view 객체에 이벤트의 Value 를 set 함
            order.setOrderId(String.valueOf(orderPlaced.getId()));
            order.setMenuId(orderPlaced.getMenuId());
            order.setCustomerId(orderPlaced.getCustomerId());
            order.setQty(orderPlaced.getQty());
            order.setAddress(orderPlaced.getAddress());
            order.setStatus("주문됨");
            // view 레파지 토리에 save
            orderRepository.save(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_1(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
            // view 객체 조회

            List<Order> orderList = orderRepository.findByOrderId(
                accepted.getOrderId()
            );
            for (Order order : orderList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                order.setStatus("주문허락됨");
                // view 레파지 토리에 save
                orderRepository.save(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_UPDATE_2(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
            // view 객체 조회

            List<Order> orderList = orderRepository.findByOrderId(
                rejected.getOrderId()
            );
            for (Order order : orderList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                order.setStatus("주문취소");
                // view 레파지 토리에 save
                orderRepository.save(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_3(
        @Payload CookStarted cookStarted
    ) {
        try {
            if (!cookStarted.validate()) return;
            // view 객체 조회

            List<Order> orderList = orderRepository.findByOrderId(
                cookStarted.getOrderId()
            );
            for (Order order : orderList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                order.setStatus("조리시작됨");
                // view 레파지 토리에 save
                orderRepository.save(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
