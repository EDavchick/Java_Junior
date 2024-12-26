package org.dav.L03.lect03;

import java.io.*;
import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Character.getName(i));
        }
        serialObj(list, "main3");
    }

    public static void serialObj(Object o, String file) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }
}
