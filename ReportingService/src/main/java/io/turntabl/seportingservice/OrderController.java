package io.turntabl.seportingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class OrderController {
    @GetMapping("/ordersList")
    public ArrayList<Orders> getAllOrders() {
        ArrayList<Orders> OrdersList = new ArrayList<>();
        OrdersList.add(new Orders(1, "IMB", 23, 23.5, 3, LocalDate.now(), Orders.orderStatus.CANCELLED));
        OrdersList.add(new Orders(2, "Google", 23, 21.5, 3, LocalDate.now(), Orders.orderStatus.EXECUTED));
        return OrdersList;
    }
}




