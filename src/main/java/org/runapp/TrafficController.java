package org.runapp;

import java.util.ArrayList;
import java.util.List;

public class TrafficController {

    private final List<TrafficLight> lights;

    public TrafficController() {
        this.lights = new ArrayList<>();
    }

    public void addTrafficLight(TrafficLight light) {
        lights.add(light);
    }

    public void startAllLights(){
        for (TrafficLight light : lights) {
            light.start();
        }
    }

    public void synchronizeLights(){
        if (this.lights.size() == 2){
            TrafficLight light1 = lights.get(0);
            TrafficLight light2 = lights.get(1);

            TrafficLightState state1 = TrafficLightState.valueOf(light1.getCurrentState());

            switch (state1) {
                case RED -> light2.setCurrentState(TrafficLightState.GREEN);
                case GREEN -> light2.setCurrentState(TrafficLightState.YELLOW);
                case YELLOW -> light2.setCurrentState(TrafficLightState.RED);
            }
            System.out.println("Lights synchronized: " + light1.getName() + " = " +
                    state1 + ", " + light2.getName() + " = " + light2.getCurrentState());
        }

    }

}
