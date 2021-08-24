package service;

import models.Menu;
import models.Restaurant;

import java.util.*;
import java.util.stream.Collectors;

public class ResturantService {
    private static Map<Integer, Restaurant> restaurants = new HashMap<Integer, Restaurant>();

    public static boolean addRestaurant(Integer id, String name, Menu menu, Integer maxCapacity) {
        Restaurant restaurant = Restaurant.builder().id(id).name(name).menu(menu).maxCapacity(maxCapacity).currentCapacity(0).build();
        restaurants.put(id,restaurant);
        return true;
    }

    public static List<Restaurant> getAllRestaurant(String food){
        return restaurants.values().stream().filter(r -> r.getMenu().getPriceList().get(food) != null).collect(Collectors.toList());
    }

    public static Restaurant getRestaurant(Integer id) {
        return restaurants.get(id);
    }

    public static boolean updateMenu(Menu menu, Integer restaurant) {
        restaurants.get(restaurant).setMenu(menu);
        return true;
    }
}
