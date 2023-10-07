package ru.mpei.DZ4;

public class StringDataValidator {

    public boolean validate(String first, String second) throws DataException {

        if (first != null && second != null && !first.isEmpty() && !second.isEmpty()) {
            if (first.replaceAll("[\\dA-Za-z]+", "") == "" &&
                    second.replaceAll("[\\dA-Za-z]+", "") == "") {
                    if (first.equals(second)){
                        return true;
                    }else{
                        return false;
                    }
            }else{
                throw new UnknownCharacterException("В ТВАИ БУКАВЫ ЕСТЬ РУССКИЙ");
            }


        }else{
            throw new EmptyDataException("В ТВАИ БУКАВЫ НЭТУ");
        }

    }
}
