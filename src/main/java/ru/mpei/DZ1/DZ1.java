package ru.mpei.DZ1;

public class DZ1 {
    public static void main(String[] args) {
        /**
         * Задано число int. Вывести в консоль "четное!", если число четное. Вывести в консоль "нечетное..", если число нечетное .
         * В конце записи вывести само число
         */
        int value = 3;
        if (value % 2 == 0){
            System.out.println("четное!");
        }else{
            System.out.println("нечетное!");
        }
        System.out.println("Вводимое число: "+value);
        /**
         * Задано слово String. Вывести каждую букву этого слова с новой строки. Если в слове есть буква "а" - прекратить вывод букв,
         * "а" не должно быть выведено.
         */
        String valueString = "billibum";





        if (valueString.matches("[a-zA-Z]+")) {
            for (int i = 0; i < valueString.length(); i++) {
                if (valueString.charAt(i) == 'a') {
                    break;
                } else {
                    System.out.println(valueString.charAt(i));
                }
            }

        }
    }

}
