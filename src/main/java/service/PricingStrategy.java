package service;

import models.Restaurant;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PricingStrategy implements Strategies {
    @Override
    public Restaurant getResturant(String foodName) {
        List<Restaurant> restaurants = ResturantService.getAllRestaurant(foodName);
        Collections.sort(restaurants, Comparator.comparing(r -> r.getMenu().getPriceList().get(foodName)));
        return restaurants.get(0);
    }
}
