package org.dav.L03.lect03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("ser.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        String str = (String) objectInputStream.readObject();
        System.out.println(str);
    }
}
