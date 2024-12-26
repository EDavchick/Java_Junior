package org.dav.hw03.task1;

import org.dav.less03.task1.UserData;

import java.io.*;

public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void serializeObj(Object o, String file) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(o);
            System.out.println("Object Person has been serialized successfully");
        }
    }

    public Object deSerializeObj(String file) throws IOException, ClassNotFoundException {
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            System.out.println("Object Person has been deserialized successfully");
            return (Person) objectInputStream.readObject();
        }
    }

    @Override
    public String toString() {
        return "Person: " +
                "name: " + name +
                ", age: " + age;
    }
}
