package ru.mpei.DZ6_v2;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AutoCallableUnderHood {
    @SneakyThrows
    public Map<Call, String> findLine() {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/config.txt"));
        String line = reader.readLine();
        Map<Call, String> result = new HashMap<>();
        Reflections reflections = new Reflections(Call.class, Scanners.MethodsParameter);

        Set<Method> methods = reflections.getMethodsWithParameter(AutoCallable.class);
        for (Method method: methods){
            Parameter[] parameters = method.getParameters();
            boolean flag = false;
            for (Parameter parameter: parameters){
                if (parameter.getAnnotation(AutoCallable.class) != null
                        && parameter.getAnnotation(AutoCallable.class).annotationType().equals(AutoCallable.class)){
                    flag = true;
                }
            }
            if (flag){
                Call call = (Call)method.getDeclaringClass().getDeclaredConstructor().newInstance();
                result.put(call, line);
            }
        }

        return result;
    }
}

