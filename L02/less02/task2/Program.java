package org.dav.less02.task2;

import java.lang.reflect.Field;

public class Program {

    /**
     * Реализуйте обобщенный метод, который принимает и выводит в консоль
     * значения всех его полей.
     * Создайте класс "Car" с различными полями (например, модель, цвет,
     * год выпуска)
     * Примените Refcection API для вывода значений полей созданного объекта
     * класса "Car" с использованием ранее созданного метода
     */
    public static void main(String[] args) throws IllegalAccessException {
        Car car1 = new Car("Toyota", "Blue", 2023);
        printInConsol(car1);
    }

    private static <T> void printInConsol(T obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();

        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Разрешаем доступ к закрытому полю
            System.out.printf("%s: %s\n", field.getName(),field.get(obj));
        }
    }
}
