package org.runapp;

import java.util.Timer;
import java.util.TimerTask;

public class TrafficLight {

   private TrafficLightState currentState;
   private final String name;
   //private final Timer timer;
   //private TimerTask task;

    public TrafficLight(String name) {
        this.name = name;
        this.currentState = TrafficLightState.RED;
       // this.timer = new Timer();
    }

    public void start(){
        IO.println("Traffic Light " + this.name + " starting at " + currentState);
        scheduleNextState();
    }

    private void scheduleNextState() {
        /*
        int duration = currentState.getDuration();
        IO.println(this.name + " is now " + currentState + " for " + duration + " ms ");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                changeState()
            }
        }, duration);

         */

        //By creating a new thread instead

        new Thread(() -> {
            try {
                int duration = currentState.getDuration();
                IO.println(this.name + " is now " + currentState + " for " + duration + " ms ");
                Thread.sleep(duration);
                changeState();
            } catch (InterruptedException e) {
                IO.println("Timer interrupted: " + e.getMessage());
            }
        }).start();
    }

    public void changeState() {
        switch (currentState) {
            case RED -> currentState = TrafficLightState.GREEN;
            case GREEN -> currentState = TrafficLightState.YELLOW;
            case YELLOW -> currentState = TrafficLightState.RED;
        }
        scheduleNextState();
    }

    public void displayState() {
        IO.println("Traffic Light " + this.name + " is currently " + currentState);
    }

    public String getCurrentState() {
        return currentState.name();
    }

    public void setCurrentState(TrafficLightState trafficLightState) {
        this.currentState = trafficLightState;
    }

    public String getName() {
        return this.name;
    }
}
