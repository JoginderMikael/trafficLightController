package org.runapp;

public enum TrafficLightState {
    RED(5000), YELLOW(4000), GREEN(2000);

    private final int duration;

    TrafficLightState(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}

