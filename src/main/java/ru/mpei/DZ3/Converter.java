package ru.mpei.DZ3;

public interface Converter {

    double convertToRu(double ue);
    double convertToCurrency(double rub);
    Type getType();
}
