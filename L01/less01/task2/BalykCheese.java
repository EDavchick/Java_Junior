package org.dav.less01.task2;

public class BalykCheese implements Snack{
    @Override
    public boolean getProneins() {
        return true;
    }

    @Override
    public boolean getFats() {
        return false;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Balyk";
    }
}
