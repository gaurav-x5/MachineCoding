package service;

import com.sun.tools.corba.se.idl.constExpr.Or;
import models.Menu;
import models.Order;
import models.OrderStatus;
import models.Restaurant;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    OrderService orderService;
    ResturantService resturantService;

    @Before
    public void init() {
        orderService = new OrderService();
        resturantService = new ResturantService();
    }

    @Test
    public void placeOrder(){
        addRestaurant();
        Order order = OrderService.placeOrder("aalo","PRICING");
        Assertions.assertEquals("new_dhaba",order.getRestaurant().getName());

    }

    @Test
    public void acceptOrder() {
        addRestaurant();
        Order order = OrderService.placeOrder("aalo","PRICING");
        OrderService.acceptOrder(order);
        Assertions.assertEquals(OrderStatus.ACCEPTED,order.getOrderStatus());
    }

    @Test
    public void declineOrder() {
        addRestaurant();
        Order order = OrderService.placeOrder("aalo","PRICING");
        OrderService.declineOrder(order);
        Assertions.assertEquals(OrderStatus.CANCEL,order.getOrderStatus());
    }

    private void addRestaurant() {
        Map<String, Double> priceList = new HashMap<>();
        priceList.put("aalo",50.0);
        priceList.put("rice",30.0);
        Menu menu = Menu.builder().priceList(priceList).build();
        ResturantService.addRestaurant(1,"dhaba",menu,5);

        Map<String, Double> priceList_v1 = new HashMap<>();
        priceList_v1.put("aalo",40.0);
        priceList_v1.put("rice",30.0);
        Menu menu_v1 = Menu.builder().priceList(priceList).build();
        ResturantService.addRestaurant(1,"new_dhaba",menu_v1,5);
    }

}