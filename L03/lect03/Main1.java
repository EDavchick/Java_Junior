package org.dav.L03.lect03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main1 {
    public static void main(String[] args) throws Exception {
        String str = "Всем привет!";
        FileOutputStream fileOutputStream = new FileOutputStream("ser.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(str);
        objectOutputStream.close();
    }
}
