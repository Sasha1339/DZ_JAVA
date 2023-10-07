package ru.mpei.DZ3;

public class YenRuble implements Converter{
    public final Type type = Type.Yen;
    @Override
    public double convertToRu(double ue) {
      return ue * 0.66;
    }
    @Override
    public double convertToCurrency(double rub) {
        return rub / 0.66;
    }
    public Type getType() {
        return type;
    }
}
