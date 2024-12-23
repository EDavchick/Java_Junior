package org.dav.less01.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart <T extends Food>{
    // region Methods

    /**
     * Print list of products in the cart
     */
    public void printFoodStaffs(){
        AtomicInteger index = new AtomicInteger(1);
        foodStuffs.forEach(food -> {
            System.out.printf("[%d] %s (Proteins: %s Fats: %s Carbohydrates: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProneins() ? "Yes" : "No",
                    food.getFats() ? "Yes" : "No",
                    food.getCarbohydrates() ? "Yes" : "No");
        });
    }
    public Collection<T> getFoodStuffs() {
        return foodStuffs;
    }

    /**
     * Balancing of cart
     */
    public void cartBalancing(){
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        for (var food : foodStuffs) {
            if (!proteins && food.getProneins())
                proteins = true;
            else
            if (!fats && food.getFats())
                fats = true;
            else
            if (!carbohydrates && food.getCarbohydrates())
                carbohydrates = true;
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates) {
            System.out.println("The cart has already balanced for PFC");
        }

        for (var thing : market.getThings(Food.class)) {
            if (!proteins && thing.getProneins()){
                proteins = true;
                foodStuffs.add((T) thing);
            } else if (!fats && thing.getFats()) {
                fats = true;
                foodStuffs.add((T) thing);
            } else if (!carbohydrates && thing.getCarbohydrates()) {
                carbohydrates = true;
                foodStuffs.add((T) thing);
            }
            if (proteins && fats && carbohydrates)
                break;
        }

        if (proteins && fats && carbohydrates)
            System.out.println("The cart is balanced for PFC");
        else
            System.out.println("Impossible to balance the cart");
    }

    // endregion

    // region
    /**
     * Goods in the market
     */
    private final ArrayList<T> foodStuffs;
    private final UMarket market;
    private final Class<T> clazz;
    // endregion

    // region Constructor

    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodStuffs = new ArrayList<>();
    }
    // endregion
}

