package org.runapp;

import java.util.Timer;
import java.util.TimerTask;

public class TrafficLight {

   private TrafficLightState currentState;
   private final String name;
   private final Timer timer;
   //private TimerTask task;

    public TrafficLight(String name) {
        this.name = name;
        this.currentState = TrafficLightState.RED;
        this.timer = new Timer();
    }

    public void start(){
        IO.println("Traffic Light " + this.name + " starting at " + currentState);
        scheduleNextState();
    }

    private void scheduleNextState() {
        int duration = currentState.getDuration();
        IO.println(this.name + "is now " + currentState + "for" + duration + "ms");
        timer.schedule(changeState(), duration);
    }

    public TimerTask changeState() {
        switch (currentState) {
            case RED -> {
                currentState = TrafficLightState.GREEN;
                break;
            }

            case GREEN -> {
                currentState = TrafficLightState.YELLOW;
                break;
            }

            case YELLOW -> {
                currentState = TrafficLightState.RED;
                break;
            }

        }
        scheduleNextState();
        return null;
    }

    public void displayState() {
        IO.println("Traffic Light " + this.name + " is currently " + currentState);
    }

    public String getCurrentState() {
        return currentState.name();
    }

}
