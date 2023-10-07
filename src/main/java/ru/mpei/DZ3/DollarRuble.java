package ru.mpei.DZ3;

public class DollarRuble implements Converter{

    public final Type type = Type.Dollar;

    @Override
    public double convertToRu(double ue) {
        return ue * 97.9;
    }

    @Override
    public double convertToCurrency(double rub) {
        return rub / 97.9;
    }

    public Type getType() {
        return type;
    }
}
