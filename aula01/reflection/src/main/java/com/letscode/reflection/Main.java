package com.letscode.reflection;

import javax.persistence.Entity;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws Exception {
        verificaClasse();
    }

    public static void verificaClasse() throws Exception {
        Pessoa person = new Pessoa();

        //Class classe = Class.forName("com.baeldung.reflection.Bird");

        System.out.println(person.getClass().getName());
        System.out.println(person.getClass().getSimpleName());

        System.out.println("Interfaces -----");
        Class[] interfaces = person.getClass().getInterfaces();
        getInterfaces(interfaces);

        Field[] fields = person.getClass().getDeclaredFields();
        System.out.println("Atributos ----- ");
        getFieldNames(fields);

        Method[] methods = person.getClass().getMethods();
        System.out.println("Metodos ----- ");
        getMethods(methods);


        Constructor[] constructors = person.getClass().getConstructors();
        System.out.println("Metodos ----- ");
        getConstructors(constructors);

        getConstructorType(person.getClass());
        getConstructorTypeWithParameter(person.getClass());

        Package aPackage = person.getClass().getPackage();
        System.out.println(aPackage.getName());

        Annotation[] annotations = person.getClass().getDeclaredAnnotations();
        getAnnnotations(annotations);

        getAnnotation(person.getClass().getAnnotation(Entity.class));


    }

    private static void getAnnotation(Entity annotation) {

        System.out.println(annotation.name());

    }

    private static void getAnnnotations(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getSimpleName());
        }
    }

    private static void getConstructorType(Class aClass) throws Exception {
        Constructor constructor = aClass.getConstructor();
        Pessoa teste = (Pessoa) constructor.newInstance();
        System.out.println(teste);

    }

    private static void getConstructorTypeWithParameter(Class aClass) throws Exception {
        Constructor constructor = aClass.getConstructor(String.class);
        Pessoa teste = (Pessoa) constructor.newInstance("teste");
        System.out.println(teste);

    }

    private static void getConstructors(Constructor[] constructors) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(constructors.length);
        for (Constructor cons : constructors) {
            System.out.println(cons.getName());
            System.out.println(cons.getParameterCount());
        }
    }

    private static void getInterfaces(Class[] interfaces) {
        for (Class inter : interfaces) {
            System.out.println(inter.getSimpleName());
        }
    }

    private static void getFieldNames(Field[] fields) {
        for (Field field : fields) {
            System.out.println(field.getName() + " " + field.getType().getName());
        }
    }

    private static void getMethods(Method[] methods) {
        for (Method method: methods) {
            System.out.println(method.getReturnType().getTypeName() + ": " + method.getName());
            verifyModifiers(method);


            for (Parameter param : method.getParameters()) {
                System.out.println(param.getName() + ":" + param.getType().getName());
            }
        }
    }

    private static void verifyModifiers(Method method) {
        int mods = method.getModifiers();

        System.out.println(Modifier.isPublic(mods));
        System.out.println(Modifier.isAbstract(mods));
        System.out.println(Modifier.isPublic(mods));
    }
}
