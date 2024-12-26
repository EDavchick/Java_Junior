package org.dav.hw03.task1;

import java.io.IOException;

public class task1 {
    /** Задание 1:
     * Создайте класс Person с полями name и age.
     * Реализуйте сериализацию и десериализацию этого класса в файл.
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Elena", 45);
        person.serializeObj(person, "task1.txt");
        person.deSerializeObj("task1.txt");
        System.out.println(person);
    }
}
