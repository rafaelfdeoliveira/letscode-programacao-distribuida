package com.letscode.annotation;

import com.letscode.annotation.annotation.JsonElement;
import com.letscode.annotation.annotation.JsonEntity;
import com.letscode.annotation.annotation.JsonInit;
import com.letscode.annotation.annotation.JsonList;
import com.letscode.annotation.model.Carro;
import com.letscode.annotation.model.Pessoa;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {



        Pessoa pessoa = new Pessoa("Eduardo", "Teste", "Rua abc", 35, Arrays.asList("1234", "1234", "534534"));

        Carro carro = new Carro("Onyx", "123456", 2020);

        Main main = new Main();
        System.out.println(main.convertToJson(pessoa));

    }

    public String convertToJson(Object object) throws IllegalAccessException, InvocationTargetException {
            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);

    }

    private void checkIfSerializable(Object object) {

        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(JsonEntity.class)) {
            System.out.println("The class "
                    + clazz.getSimpleName()
                    + " is not annotated with JsonSerializable");
        }
    }

    private void initializeObject(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(JsonInit.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getJsonString(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Map<String, Object> jsonElementsMap = new HashMap<>();
        Map<String, String> jsonListMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(getKey(field), field.get(object));
            }
            if (field.isAnnotationPresent(JsonList.class)) {
                List<String> lista = (List<String>) field.get(object);
                String citiesCommaSeparated = String.join("\",\"", lista);
                jsonListMap.put(getKeyList(field), "\"" + citiesCommaSeparated + "\"");
            }
        }

        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));

        jsonString += jsonListMap.entrySet()
                .stream()
                .map(entry -> ",\"" + entry.getKey() + "\":["
                        + entry.getValue() + "]")
                .collect(Collectors.joining(","));


        return "{" + jsonString + "}";
    }

    private String getKey(Field field) {
        JsonElement element = field.getAnnotation(JsonElement.class);
        if (element.name() != null && !element.name().equals("")) {
            return element.name();
        }
        return field.getName();
    }

    private String getKeyList(Field field) {
        JsonList element = field.getAnnotation(JsonList.class);
        if (element.name() != null && !element.name().equals("")) {
            return element.name();
        }
        return field.getName();
    }

}
