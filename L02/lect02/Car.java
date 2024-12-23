package org.dav.lect02;

public class Car {
    public String name;
    private String price;
    private String engType;
    private String engPower;
    private int maxSpeed;

    public Car(String name) {
        this.name = name;
        this.price = "100000000";
        this.engType = "V8";
        this.engPower = "123";
        this.maxSpeed = 200;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
