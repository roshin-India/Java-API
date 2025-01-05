package org.ecommerce.productservice2024.models;

import lombok.Getter;
import lombok.Setter;

//model means the entity class
@Getter
@Setter
public class Product extends Base {

    private String title;
    private double price;
    private Category category;


}
