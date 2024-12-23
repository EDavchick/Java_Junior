package org.dav.lect01;

public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return STR."User{name='\{name}\{'\''}, age=\{age}\{'}'}";
    }
}
