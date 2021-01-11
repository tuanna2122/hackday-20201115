package com.example;

public class BaeldungSynchronizedMethods {

    public int getSum() {
        return _sum;
    }

    public void setSum(int sum) {
        _sum = sum;
    }

    private int _sum = 0;

    public void calculate() {
        synchronized (this) {
            setSum(getSum() + 1);
        }
    }
}
