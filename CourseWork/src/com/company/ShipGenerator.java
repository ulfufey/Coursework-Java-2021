package com.company;

import java.util.Random;

public class ShipGenerator implements Runnable {
    private Port port;
    private Ship ship;
    private int maxCountOfShips;
    private int count;
    static boolean generating = true;

    public ShipGenerator(Port port, int countOfShips) {
        this.port = port;
        this.maxCountOfShips = countOfShips;
        this.count = 0;
        this.ship = null;
    }


    @Override
    public void run() {
        try {
            count = 0;
            while (count < maxCountOfShips) {
                Thread.currentThread().setName("Generate ship tread");
                if (ship == null){
                    ship = createShip();
                }
                if (port.add(ship)){
                    ship = null;
                    count++;
                }
            }
            generating = false;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized Ship createShip() {
        int type = 0;
        int number = count;
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                type = 1;
                break;
            case 1:
                type = 2;
                break;
            case 2:
                type = 3;
                break;
            default:
                break;
        }
        double min = 100;
        double max = 500;
        double randomValue = min + (max - min) * rand.nextDouble();
        return new Ship(number, type, randomValue);
    }
}
