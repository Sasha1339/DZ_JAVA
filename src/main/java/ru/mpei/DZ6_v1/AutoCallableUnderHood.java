package ru.mpei.DZ6_v1;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.reflections.scanners.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class AutoCallableUnderHood {
    @SneakyThrows
    public Map<Call, String> findLine() {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/config.txt"));
        String line = reader.readLine();
        Map<Call, String> result = new HashMap<>();
        Reflections reflections = new Reflections(Call.class, Scanners.MethodsAnnotated);

        // сюда передаем название аннотации
        Set<Method> methods = reflections.getMethodsAnnotatedWith(AutoCallable.class);
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

