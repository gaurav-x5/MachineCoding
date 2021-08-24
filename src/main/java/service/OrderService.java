package service;

import models.Item;
import models.Order;
import models.OrderStatus;
import models.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private static Map<Integer, Order> orderMap = new HashMap<Integer, Order>();
    private static Strategies strategyService;
    private final static String RATING = "RATING";

    public static Order placeOrder(String food, String strategy) {
        setStrategyService(strategy);
        Restaurant restaurant = strategyService.getResturant(food);
        if (isMaxCapacityReached(restaurant)) {
            Item item = Item.builder().dishName(food).quantity(1).build();
            Order order = Order.builder().id((int) Math.random()).orderStatus(OrderStatus.WAITING).item(item).restaurant(restaurant)
                    .price(restaurant.getMenu().getPriceList().get(food) * item.getQuantity()).build();
            orderMap.put(order.getId(), order);
            return order;
        } else {
            return Order.builder().orderStatus(OrderStatus.CANCEL).build();
        }
    }

    public static boolean acceptOrder(Order order) {
        order.setOrderStatus(OrderStatus.ACCEPTED);
        Restaurant restaurant = order.getRestaurant();
        restaurant.setCurrentCapacity(restaurant.getCurrentCapacity() + 1);
        return true;
    }

    public static boolean declineOrder(Order order) {
        order.setOrderStatus(OrderStatus.CANCEL);
        return true;
    }

    private static boolean isMaxCapacityReached(Restaurant restaurant) {
        return restaurant.getCurrentCapacity() < restaurant.getMaxCapacity();
    }


    private static void setStrategyService(String strategy) {
        if (strategy.equals(RATING)) {
            strategyService = new RatingStrategy();
        } else {
            strategyService = new PricingStrategy();
        }
    }
}