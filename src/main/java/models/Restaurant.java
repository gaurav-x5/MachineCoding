package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private Integer id;
    private String name;
    private Double rating = 0.0;
    private Integer maxCapacity;
    private Integer currentCapacity = 0;
    private Menu menu;

}
