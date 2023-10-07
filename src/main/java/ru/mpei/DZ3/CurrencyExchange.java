package ru.mpei.DZ3;

import javax.security.auth.Destroyable;
public class CurrencyExchange {

    private DollarRuble dollarRuble = new DollarRuble();
    private YenRuble yenRuble = new YenRuble();
    private YuanRuble yuanRuble = new YuanRuble();
    private Converter[] arrayConverter = {dollarRuble, yenRuble, yuanRuble};
    public double convert(double value, Type input, Type output){
        Converter inputConverter = null;
        Converter outputConverter = null;
        for (Converter converter: arrayConverter){
            if (converter.getType() == input){
                inputConverter = converter;
            }
            if (converter.getType() == output){
                outputConverter = converter;
            }
        }
        if (inputConverter != null && outputConverter != null){

            return outputConverter.convertToCurrency(inputConverter.convertToRu(value));

        }else if(inputConverter == null && outputConverter != null){

            return outputConverter.convertToCurrency(value);

        }else if(outputConverter == null && inputConverter != null){

            return inputConverter.convertToRu(value);

        }else{
            return value;
        }

    }

}
