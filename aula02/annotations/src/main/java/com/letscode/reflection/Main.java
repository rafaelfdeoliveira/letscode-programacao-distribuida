package com.letscode.reflection;

import org.yaml.snakeyaml.constructor.Construct;

import javax.persistence.Entity;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Pessoa teste = new Pessoa();

        System.out.println(teste.getClass().getSimpleName());
        System.out.println(teste.getClass().getName());

        System.out.println("Interfaces -----");
        Class[] interfaces = teste.getClass().getInterfaces();
        getInterfaces(interfaces);

        System.out.println("Methods -----");
        Method[] methods = teste.getClass().getMethods();
        getMethods(methods);

        Field[] fields = teste.getClass().getFields();
        getFields(fields);

        Constructor[] constructors = teste.getClass().getConstructors();
        getConstructors(constructors);

        getConstructorSemParametro(teste.getClass());

        Annotation[] annotations = teste.getClass().getDeclaredAnnotations();
        getAnnotations(annotations);

        getAnnotation(teste.getClass().getAnnotation(Entity.class));

        Package aPackage = teste.getClass().getPackage();
        System.out.println(aPackage.getName());

    }

    private static void getAnnotation(Entity annotation) {

        System.out.println(annotation.name());
    }

    private static void getAnnotations(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getSimpleName());
        }
    }

    private static void getConstructorSemParametro(Class aClass) throws Exception{
        Constructor constructor = aClass.getConstructor(String.class);
        Pessoa pessoa = (Pessoa) constructor.newInstance("teste");
        System.out.println(pessoa);
    }

    private static void getConstructors(Constructor[] constructors) {

        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + " " + constructor.getParameterCount());
        }
    }

    private static void getFields(Field[] fields) {

        for (Field field : fields) {
            System.out.println("f: " + field.getName() + " " + field.getType());

            field.setAccessible(true);


            System.out.println(Modifier.isPublic(field.getModifiers()));
            System.out.println(Modifier.isPrivate(field.getModifiers()));
            System.out.println(Modifier.isFinal(field.getModifiers()));
        }
    }

    private static void getInterfaces(Class[] interfaces) {
        for (Class clazz : interfaces) {
            System.out.println("i: " + clazz.getSimpleName());
            Method[] methods = clazz.getMethods();
            getMethods(methods);
        }
    }

    private static void getMethods(Method[] methods) {
        for (Method method : methods) {
            System.out.println("m: " +
                    method.getName() + " " + method.getReturnType() + " " +
                    method.getParameterCount());

            Parameter[] parameters = method.getParameters();
            getParameters(parameters);

        }
    }

    private static void getParameters(Parameter[] parameters) {
        for (Parameter parameter : parameters) {
            System.out.println("p: " + parameter.getName() + " " + parameter.getType().getSimpleName());
        }
    }

}
