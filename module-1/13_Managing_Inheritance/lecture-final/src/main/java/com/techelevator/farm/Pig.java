package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable {
    private BigDecimal price;

    public Pig() {
        super("Pig", "oink!");
        price = new BigDecimal("300.00");
    }

    public BigDecimal getPrice() {
        return price;
    }
    // 10. there is now an eat() method that must be implemented in its child objects
    @Override
    public String eat(){
        return "eating pig food";
    }
}
