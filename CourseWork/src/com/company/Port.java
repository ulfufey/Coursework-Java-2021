package com.company;

import java.util.ArrayList;

public class Port {
    private ArrayList<Ship> ships;

    public Port() {
        this.ships = new ArrayList<Ship>();
    }

    public synchronized boolean add(Ship ship) throws InterruptedException {
        if (this.ships.size() < 100) {
            notifyAll();
            ships.add(ship);
            return true;
        }
        else {
            System.out.println("Port is full");
            wait();
            return false;
        }
    }

    public synchronized boolean checkCargo(int typeOfCargo) {
        if (ships.size() == 0) {
            return false;
        }
        return ships.get(0).getTypeOfCargo() == typeOfCargo;
    }

    public synchronized Ship get(int typeOfCargo) throws InterruptedException {
        if (checkCargo(typeOfCargo)) {
            notifyAll();
            Ship ship = ships.get(0);
            ships.remove(0);
            return ship;
        } else if (ShipGenerator.generating || !ships.isEmpty()) {
            try {
                System.out.println("Crane wait ship with this type of cargo : " + typeOfCargo);
                wait();
            }
            catch (Exception err){
                err.printStackTrace();
            }
        }
        return null;
    }

    public synchronized boolean isEmpty()  {
        return ships.isEmpty();
    }

    public synchronized boolean full() {
        return ships.size() >= 100;
    }
}
