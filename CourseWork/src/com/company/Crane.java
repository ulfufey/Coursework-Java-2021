package com.company;

public class Crane implements Runnable {
    private Port port;
    private int typeOfCargo;
    private int countOfShips;
    private double kpd;

    public Crane(Port port, int typeOfCargo, double kpd) {
        this.port = port;
        this.typeOfCargo = typeOfCargo;
        this.kpd = kpd;
    }

    @Override
    public void run() {

        try {
            while (!port.isEmpty() || ShipGenerator.generating) {
                Thread.currentThread().setName("Crane with this type of cargo "+ this.typeOfCargo);
                Ship ship = port.get(this.typeOfCargo);
                if (ship != null){
                    countOfShips++;
                    while (ship.get(kpd)){
                        System.out.println(ship.toString() + " Ship with cargo " + ship.getTypeOfCargo()+ " " + Thread.currentThread().getName());
                    }
                }
            }
            System.out.println(toString());
        }
        catch (Exception err)
        {
            err.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return " Crane = " + typeOfCargo + " " +
                " countOfShips=" + countOfShips +
                ' ';
    }
}
