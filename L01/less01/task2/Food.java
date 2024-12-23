package org.dav.less01.task2;

public interface Food extends Thing{
    /**
     * Get proteins in food
     * @return proteins
     */
    boolean getProneins();

    /**
     * Get fats in food
     * @return fats
     */
    boolean getFats();

    /**
     * Get carbohydrates in food
     * @return carbohydrates
     */
    boolean getCarbohydrates();

}
