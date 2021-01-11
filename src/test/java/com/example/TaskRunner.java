package com.example;

public class TaskRunner {

    private static volatile int c_number;
    private static volatile boolean c_ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!c_ready) {
                Thread.yield();
            }

            System.out.println(c_number);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        c_number = 42;
        c_ready = true;
    }
}
