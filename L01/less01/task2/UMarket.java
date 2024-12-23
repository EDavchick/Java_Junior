package org.dav.less01.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class UMarket {

    // region Methods

    public <T extends Thing> T getThingByIndex(Class<T> clazz, int index) {
//        int counter = 1;
//        for (var thing : things) {
//            if (clazz.isAssignableFrom(thing.getClass())){
//                if (index == counter++)
//                    return (T) thing;
//            }
//        }
//        return null;
        // =================== STREAM API ==============================

        AtomicInteger counter = new AtomicInteger(1);
        return things.stream()
                .filter(clazz::isInstance)
                .filter(thing -> index == counter.getAndIncrement())
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }

    public <T extends Thing> Collection<T> getThings(Class<T> clazz) {
//        Collection<T> list = new ArrayList<>();
//        for (var thing : things) {
//            if (clazz.isAssignableFrom(thing.getClass())){
//                list.add((T) thing);
//            }
//        }
//        return list;

        // =================== STREAM API ==============================

        return things.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    /**
     * Print all products or products certain type
     * If there are food - print name of product and
     * information about Proteins, Fats and Carbohydrates in food
     * Otherwise print only name of product
     * @param <T>
     */
    public <T extends Thing> void printThings(Class<T> clazz){
//        int index = 1;
//        for (var thing : things) {
//            if (clazz.isInstance(thing)){
//                if (Food.class.isAssignableFrom(thing.getClass())) {
//                    System.out.printf("[%d] %s (Proteins: %s Fats: %s Carbohydrates: %s)\n",
//                            index++, thing.getName(),
//                            ((Food)thing).getProneins() ? "Yes" : "No",
//                            ((Food)thing).getFats() ? "Yes" : "No",
//                            ((Food)thing).getCarbohydrates() ? "Yes" : "No");
//                }
//                else {
//                    System.out.printf("[%d] %s\n",index++, thing.getName());
//                }
//            }
//        }

        // =================== STREAM API ==============================

        int[] counter = {1};

        things.stream()
                .filter(clazz::isInstance)
                .forEach(thing -> {
                    if (Food.class.isAssignableFrom(thing.getClass())) {
                        Food foodThing = (Food) thing;
                        System.out.printf("[%d] %s (Proteins: %s Fats: %s Carbohydrates: %s)\n",
                                counter[0]++, thing.getName(),
                                foodThing.getProneins() ? "Yes" : "No",
                                foodThing.getFats() ? "Yes" : "No",
                                foodThing.getCarbohydrates() ? "Yes" : "No");
                    } else {
                    System.out.printf("[%d] %s\n",counter[0]++, thing.getName());
                    }
                });
    }
    private void initializeThings(){
        things.add(new Pen());
        things.add(new Notebook());

        things.add(new Chicken());
        things.add(new Fruit());
        things.add(new OliveOil());

        things.add(new BalykCheese());
        things.add(new Crisps());
        things.add(new ChocolateBar());

        things.add(new DumplingsBerries());
        things.add(new DumplingsMeat());
        things.add(new Cheburek());
    }
    // endregion

    // region Constructor
    public UMarket() {
        things = new ArrayList<>();
        initializeThings();
    }
    // endregion

    // region Var
    /**
     * Goods in the market
     */
    private final Collection<Thing> things;
    // endregion
}
