package org.dav.L03.lect03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> list = null;
        list = (ArrayList<String>) deSerialObj("main3");
        System.out.println(list);
    }

    public static Object deSerialObj(String file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return objectInputStream.readObject();
    }
}
