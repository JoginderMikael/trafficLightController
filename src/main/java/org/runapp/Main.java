package org.runapp;


public class Main {
    static void main() {

        TrafficController controller = new TrafficController();
        TrafficLight light1 = new TrafficLight("A");
        TrafficLight light2 = new TrafficLight("B");

        controller.addTrafficLight(light1);
        controller.addTrafficLight(light2);

        IO.println("Starting all traffic lights....");
        controller.startAllLights();

        controller.synchronizeLights();
        // Keep the main thread alive to let timers run

                try {
                    while(true) {
                        Thread.sleep(10000);
                    }
                } catch (InterruptedException e) {
                    IO.println("Simulation interrupted." + e.getMessage());
                }
            }




    }

