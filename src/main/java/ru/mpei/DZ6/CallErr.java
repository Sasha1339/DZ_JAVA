package ru.mpei.DZ6;

public class CallErr implements Call{
    @Override
    @AutoCallable
    public void call(String line) {
        System.err.println(line);
    }
}

