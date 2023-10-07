package ru.mpei.DZ4;

public class MainClass {

    public static void main(String[] args) {
        StringDataValidator stringDataValidator = new StringDataValidator();

        try{
            System.out.println("Результат сравнения строк: " +
                    stringDataValidator.validate("stringNumber55", "stringNumber55"));
        }catch (DataException dataException){
            dataException.printStackTrace();
        }

        System.out.println("////////////////////////////////////////////////////////////////");

        try{
            System.out.println("Результат сравнения строк: " +
                    stringDataValidator.validate("stringNumber55", "string55"));
        }catch (DataException dataException){
            dataException.printStackTrace();
        }
        System.out.println("////////////////////////////////////////////////////////////////");

        try{
            System.out.println("Результат сравнения строк: " +
                    stringDataValidator.validate("русский язык", "русский язык"));
        }catch (DataException dataException){
            dataException.printStackTrace();
        }

        try{
            System.out.println("Результат сравнения строк: " +
                    stringDataValidator.validate("", "stringNumber55"));
        }catch (DataException dataException){
            dataException.printStackTrace();
        }


    }

}
