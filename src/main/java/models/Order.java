package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private Integer id;
    private OrderStatus orderStatus;
    private double price;
    private Item item;
    private Restaurant restaurant;
}
