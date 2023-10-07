package ru.mpei.DZ6_v1;

public class CallErr implements Call{
    @Override
    @AutoCallable
    public void call(String line, String rr) {
        System.err.println(line);
    }
}

