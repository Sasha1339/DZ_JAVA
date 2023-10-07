package ru.mpei.DZ4;

public class EmptyDataException extends DataException{
    public EmptyDataException(String message) {
        super(message);
        System.err.println("Переданная строка Null или Пустая!!!");
    }
}
