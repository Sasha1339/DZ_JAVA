package ru.mpei.DZ6_v2;

public class CallOut implements Call {
    @Override
    public void call(@AutoCallable String line) {
        System.out.println(line);
    }
}
