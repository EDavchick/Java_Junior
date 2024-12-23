package org.dav.hw02;

import java.lang.reflect.Method;

/*
Используя Reflection API, напишите программу, которая выводит на
экран все методы класса String.
 */
public class AllMethodsString {
    public static void main(String[] args) {

        Class<String> stringClass = String.class;

        Method[] methods = stringClass.getMethods();

        for (Method method : methods) {
            System.out.printf("Method: %s\n", method);
        }
    }
}
