package ru.mpei.DZ4;

public class UnknownCharacterException extends DataException{
    public UnknownCharacterException(String message) {
        super(message);
        System.out.println("Содержатся символы кроме английского алфавита и цифр!!!");
    }
}
