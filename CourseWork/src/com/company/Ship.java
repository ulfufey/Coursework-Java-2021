package com.company;

import java.util.ArrayList;

public class Ship {
    private int numberOfShip;
    private int typeOfCargo;
    private double weight;

    public Ship(int numberOfShip, int typeOfCargo, double weight) {
        this.numberOfShip = numberOfShip;
        this.typeOfCargo = typeOfCargo;
        this.weight = weight;
    }

    public boolean get(double weight)
    {
        if (this.weight <= 0.0)  {
            return false;
        }
        this.weight -= weight;
        return true;
    }

    public int getTypeOfCargo() {
        return typeOfCargo;
    }

    @Override
    public String toString() {
        return "Ship" + " Number :" + numberOfShip + "{" +
                "W = " + weight + "}";
    }
}