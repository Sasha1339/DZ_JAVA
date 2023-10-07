package ru.mpei.DZ6_v1;

public class CallOut implements Call {
    @Override
    @AutoCallable
    public void call(String line, String rr) {
        System.out.println(line);
    }
}
