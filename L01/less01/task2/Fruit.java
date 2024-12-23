package org.dav.less01.task2;

public class Fruit implements HealtyFood{
    @Override
    public boolean getProneins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Fruit";
    }
}
