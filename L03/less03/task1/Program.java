package org.dav.less03.task1;

import java.io.*;

public class Program {
    /**
     * Создайте класс UserData с полями String name, int age, transient String password
     * Поле password должно быть отмечено ключевым словом transient
     * Реализуйте интерфейс Serializable в вашем классе
     * В методе main создайте экземпляр класса UserData и инициализируйте его данными
     * Сериализуйте этот объект в файл, используя ObjectOutputStream в сочетании с FileOutputStream
     * Десериализуйте объект из ранее созданного файла в объект Java,
     * используя ObjectInputStream в сочетании с FileInputStream
     * Выведите данные до сериализации и после десериализациии, особенно обратите
     * внимание на поле помеченное как transient
     * Подумайте почему это поле не было сохранено после десериализациии
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserData user =  new UserData("Nikolay", 39, "pass111");

        try(FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
                objectOutputStream.writeObject(user);
                System.out.println("Object UserData has been serialized successfully");
            }

        try(FileInputStream fileInputStream = new FileInputStream("userdata.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            user = (UserData) objectInputStream.readObject();
            System.out.println("Object UserData has been deserialized successfully");
        }
        System.out.println();
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Password (must be null because transient): " + user.getPassword());
    }
}
