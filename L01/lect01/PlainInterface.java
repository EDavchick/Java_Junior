package org.dav.lect01;
// интерфейс с один методом называется функциональный
// интерфейс вообще без методов называется маркерный
// интерфейс с двумя и более методами называется обычный
@FunctionalInterface // маркер для функционального интерфейса
public interface PlainInterface {
//    String action(int x, int y);
    int action(int x, int y);
}
