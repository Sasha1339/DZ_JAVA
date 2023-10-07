package ru.mpei.DZ3;

public class YuanRuble implements Converter{

    public final Type type = Type.Yuan;

    @Override
    public double convertToRu(double ue) {
        return ue * 13.31;
    }

    @Override
    public double convertToCurrency(double rub) {
        return rub / 13.31;
    }

    public Type getType() {
        return type;
    }

}
