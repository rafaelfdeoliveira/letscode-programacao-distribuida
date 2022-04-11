package com.letscode.reflection;

import org.reflections.Reflections;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class MainReflections {

    public static void main(String[] args) {
        Set<Class<?>> classes = new Reflections("com.letscode.reflection.model").getTypesAnnotatedWith(Entity.class);


        String sql = "";
        for (Class c : classes) {
            System.out.println(c.getSimpleName());

            sql += "CREATE TABLE " + c.getSimpleName() + " ( \n";

            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                boolean isPrimaryKey = false;
                boolean isNullable = false;
                boolean hasAnnotation = false;

                for (Annotation annotation : annotations) {
                    if (annotation.annotationType().getSimpleName().equals("Id")) {
                        isPrimaryKey = true;
                        hasAnnotation = true;
                    }
                    if (annotation.annotationType().getSimpleName().equals("Column")) {
                        Column column = field.getAnnotation(Column.class);
                        isNullable = column.nullable();
                        hasAnnotation = true;
                    }
                    System.out.println(annotation.annotationType().getSimpleName());
                }

                if (!hasAnnotation) {
                    break;
                }


                sql += field.getName()  + "  " + field.getType() + " " + (isPrimaryKey ? "PRIMARY KEY " : "") + (!isNullable ? "NOT NULL ": "") + ", \n";
            }

            System.out.println(sql);
        }

    }
}
