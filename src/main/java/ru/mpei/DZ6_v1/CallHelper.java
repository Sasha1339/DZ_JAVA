package ru.mpei.DZ6_v1;

import java.util.Map;

public class CallHelper {

    private Map<Call, String> classWithMethods;

    {
        try{
            this.classWithMethods = new AutoCallableUnderHood().findLine();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void printLine(){
        for (Map.Entry<Call, String> entry: classWithMethods.entrySet()){
            Call call = entry.getKey();
            String line = entry.getValue();
            call.call(line, "2");
        }
    }



}
