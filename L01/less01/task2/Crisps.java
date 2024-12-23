package org.dav.less01.task2;

public class Crisps implements Snack{
    @Override
    public boolean getProneins() {
        return false;
    }

    @Override
    public boolean getFats() {
        return true;
    }

    @Override
    public boolean getCarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Crisps";
    }
}
