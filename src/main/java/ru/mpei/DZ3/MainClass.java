package ru.mpei.DZ3;

public class MainClass {

    public static void main(String[] args) {

        CurrencyExchange currencyExchange = new CurrencyExchange();

        double result = currencyExchange.convert(50, Type.Dollar, Type.Yen);
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Результат перевода валют = "+result);
        System.out.println("///////////////////////////////////////////////////////////////////////////////////");
    }

}
