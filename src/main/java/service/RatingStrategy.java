package service;

import models.Restaurant;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RatingStrategy implements Strategies {
    @Override
    public Restaurant getResturant(String foodName) {
        List<Restaurant> restaurantList = ResturantService.getAllRestaurant(foodName);
        Collections.sort(restaurantList, Comparator.comparing(r -> r.getRating()));
        return restaurantList.get(0);
    }
}
