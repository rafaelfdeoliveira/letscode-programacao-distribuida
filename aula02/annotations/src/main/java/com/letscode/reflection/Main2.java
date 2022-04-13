package com.letscode.reflection;

import org.reflections.Reflections;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        Set<Class<?>> classes = new Reflections("com.letscode.reflection.model")
                .getTypesAnnotatedWith(Entity.class);

        // create table pessoa (

        String sql = "";

        String sqlManyToMany = "";

        for (Class c : classes) {
            Entity entity = (Entity) c.getAnnotation(Entity.class);
            sql += "create table " + entity.name() + " (";

            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i <  fields.length; i++) {
                Field field = fields[i];
                boolean isFirst = false;
                if (i == 0) {
                    isFirst = true;
                }

                Transient aTransient = (Transient) field.getAnnotation(Transient.class);
                if (aTransient != null) {
                    continue;
                }

                Id id = (Id) field.getAnnotation(Id.class);
                boolean isId = false;
                if (id != null) {
                    isId = true;
                }

                GeneratedValue generatedValue = (GeneratedValue) field.getAnnotation(GeneratedValue.class);
                boolean isSerial = false;
                if (generatedValue != null) {
                    if (generatedValue.strategy() == GenerationType.IDENTITY) {
                        isSerial = true;
                    }
                }

                Column column = (Column) field.getAnnotation(Column.class);
                if (column != null) {
                    boolean isNullable = !column.nullable();
                    boolean isUnique = column.unique();


                    sql += (isFirst ? "\n":",\n") + "    "
                            + column.name() + " "
                            + (isSerial ? " serial " : convertType(field.getType().getSimpleName()))
                            + (isId ? " PRIMARY KEY" : "")
                            + (isNullable ? " NOT NULL" : "")
                            + (isUnique ? " UNIQUE" : "");
                }

                JoinColumn joinColumn = (JoinColumn) field.getAnnotation(JoinColumn.class);
                if (joinColumn != null) {
                    sql += (isFirst ? "\n":",\n") + "    "
                            + joinColumn.name() + " "
                            + "integer "
                            + "references " + field.getName() + "(" + joinColumn.referencedColumnName() + ")";
                }

                JoinTable joinTable = (JoinTable) field.getAnnotation(JoinTable.class);
                if (joinTable != null) {

                    sqlManyToMany += "create table " + joinTable.name() + "( \n";

                    for (JoinColumn join : joinTable.joinColumns()) {
                        sqlManyToMany += "    " + join.name() + " integer references " + entity.name() + "(" + join.referencedColumnName() + ") PRIMARY KEY\n";
                    }

                    for (JoinColumn join : joinTable.inverseJoinColumns()) {
                        sqlManyToMany += "    " + join.name() + " integer references pessoa(" + join.referencedColumnName() + ") PRIMARY KEY";
                    }

                    sqlManyToMany += "\n);\n\n";

                }
             }

            sql += "\n); \n\n";

        }


        System.out.println(sql);

        System.out.println(sqlManyToMany);

    }

    private static String convertType(String simpleName) {
        if (simpleName.equals("String")) {
            return "varchar";
        } else if (simpleName.equals("Integer")) {
            return "integer";
        }
        return "";
    }
}
