package org.dav.less02.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Program {

    /**
     * Получите информацию о классе "Person" с использованием Reflection API:
     * выведите на экран все поля и методы класса.
     * Создайте экземпляр класса "Person" с использованием Reflection API,
     * установите значения полей и вызовите методы.
     * Реализуйте обработку исключений для обеспечения корректировки
     * взаимодействия с Reflection API.
     */
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> personalClass = Class.forName("org.dav.less02.task1.Person");

        // Получить список всех полей
        Field[] fields = personalClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
        }

        // Получить список всех конструкторов
        Constructor[] constructors = personalClass.getConstructors();

        // Создание экземпляра класса
        Object personalInstanse = constructors[0].newInstance(null);
        // Меняем поля
        Field nameField = personalClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(personalInstanse, "Alice");

        Field ageField = personalClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(personalInstanse, 48);

        // Выводим поля с помощью метода displayInfo из класса Person
        Method method = personalClass.getDeclaredMethod("displayInfo");
        method.invoke(personalInstanse); // Name: Alice; Age: 48





    }
}
