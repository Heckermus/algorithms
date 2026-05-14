package com.mats;

public class Timer {

    long start;

    public Timer() {}

    public void start() {
        this.start = System.nanoTime();
    }

    public double stop() {
        long end = System.nanoTime();
        long elapsed = end - this.start;

        double elapsedSeconds = elapsed / 1_000_000_000d;

        return elapsedSeconds;
    }
}
