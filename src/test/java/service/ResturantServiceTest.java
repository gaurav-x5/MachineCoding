package service;

import models.Menu;
import models.Restaurant;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ResturantServiceTest {

    private ResturantService resturantService;

    @Before
    public void init(){
        resturantService = new ResturantService();
    }

    @Test
    public void addResturantTest() {
        Menu menu = new Menu();
        HashMap<String, Double> priceList = new HashMap<String, Double>();
        priceList.put("bhindi", 100.0);
        menu.setPriceList(priceList);

        resturantService.addRestaurant(1,"shivoy",menu,5);
        Restaurant restaurant = resturantService.getRestaurant(1);

        Assertions.assertEquals("shivoy", restaurant.getName());

    }

    @Test
    public void updateMenu() {
        Menu menu = new Menu();
        HashMap<String, Double> priceList = new HashMap<String, Double>();
        priceList.put("bhindi", 100.0);
        menu.setPriceList(priceList);

        resturantService.addRestaurant(1,"shivoy",menu,5);
        Restaurant restaurant = resturantService.getRestaurant(1);


        Assertions.assertEquals(100.0, restaurant.getMenu().getPriceList().get("bhindi"));

        Menu updatedMenu = new Menu();
        HashMap<String, Double> priceList_updated = new HashMap<String, Double>();
        priceList_updated.put("bhindi", 110.0);
        updatedMenu.setPriceList(priceList_updated);

        resturantService.updateMenu(updatedMenu,1);
        Assertions.assertEquals(110.0, restaurant.getMenu().getPriceList().get("bhindi"));
    }

    @Test
    public void getAllResturant() {

    }


}