package ru.mpei.DZ6_v1;

public class CallErr implements Call{
    @Override
    @AutoCallable
    public void call(String line) {
        System.err.println(line);
    }
}

