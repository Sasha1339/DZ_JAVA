package ru.mpei.DZ6_v1;

public class CallOut implements Call {
    @Override
    @AutoCallable
    public void call(String line) {
        System.out.println(line);
    }
}
