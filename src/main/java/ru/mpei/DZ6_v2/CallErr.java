package ru.mpei.DZ6_v2;

public class CallErr implements Call {
    @Override
    public void call(@AutoCallable String line, String rr) {
        System.err.println(line);
    }
}

