package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        Port port = new Port();

        ShipGenerator shipGenerator = new ShipGenerator(port, 500);

        Crane crane1 = new Crane(port, 1, 50);
        Crane crane2 = new Crane(port, 2, 75);
        Crane crane3 = new Crane(port, 3, 100);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(shipGenerator);
        service.execute(crane1);
        service.execute(crane2);
        service.execute(crane3);
        service.shutdown();
    }
}
