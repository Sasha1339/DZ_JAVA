package ru.mpei.DZ6;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.reflections.scanners.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.*;

public class AutoCallableUnderHood {
    @SneakyThrows
    public Map<Call, String> findLine() {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/config.txt"));
        String line = reader.readLine();
        Map<Call, String> result = new HashMap<>();
        Reflections r = new Reflections(Call.class, Scanners.MethodsAnnotated);
//        Reflections r1 = new Reflections(Call.class, Scanners.MethodsParameter);
//
//        Set<Method> methods1 = r.getMethodsWithParameter(AutoCallable.class);
        // сюда передаем название аннотации
        Set<Method> methods = r.getMethodsAnnotatedWith(AutoCallable.class);
        for (Method method: methods){
            if (!Call.class.isAssignableFrom(method.getDeclaringClass())){
                continue;
            }
            Call call = (Call)method.getDeclaringClass().getDeclaredConstructor().newInstance();
            result.put(call, line);
        }
        return result;
    }
}

