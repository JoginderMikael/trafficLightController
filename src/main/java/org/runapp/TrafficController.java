package org.runapp;

import java.util.ArrayList;
import java.util.List;

public class TrafficController {

    private List<TrafficLight> lights;

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

            if(light1.getCurrentState().equals("GREEN")){
                light2.changeState(); // Change to RED
            } else if (light1.getCurrentState().equals("RED")){
                light2.changeState(); // Change to GREEN
            }
        }
      //  IO.println("Synchronizing all traffic lights.");
    }

}
