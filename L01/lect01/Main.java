package org.dav.lect01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // standard way
//        PlainInterface plainInterface = new PlainInterface() {
//            @java.lang.Override
//            public String action(int x, int y) {
//                return String.valueOf(x + y);
//            }
//        };

        // LAMBDA way
        // method with String
//        PlainInterface plainInterface = (x, y) -> String.valueOf(x + y);
//        PlainInterface plainInterface1 = (x, y) -> String.valueOf(Integer.compare(x, y));
//        System.out.println(plainInterface.action(5, 3)); // 8
//        System.out.println(plainInterface1.action(1, 5)); // -1

        // method whit int
//        PlainInterface plainInterface = Integer::sum;
//        PlainInterface plainInterface1 = Integer::compare;
//        System.out.println(plainInterface.action(5, 3)); // 8
//        System.out.println(plainInterface1.action(1, 5)); // -1

        List<String> list = Arrays.asList("Hello", "world", "!", "I", "was", "born", "!");

        // STREAM API
//        list = list.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
//        for (String l : list) {
//            System.out.println(l);
//        }
        // easy
        list.stream().filter(str -> str.length() > 4).
                forEach(System.out::println);

        list.stream().filter(str -> str.length() > 4).
                filter(str -> str.contains("r")).
                forEach(System.out::println);

        Arrays.asList(1, 2, 3, 4, 5, 6).stream().
                map(num -> STR."number: \{num}, squard: \{num * num}").
                forEach(System.out::println);

        Stream.of(10, 2, 30, 4, 15, 6, 15).sorted().distinct().
                forEach(System.out::println);



        List<User> users =  Arrays.asList(
          new User("Pavel", 30),
          new User("Valera", 45),
          new User("Anton", 49)
        );

        users.stream().map(user -> new User(user.name, user.age - 5)).filter(user -> user.age <= 40).forEach(System.out::println);
//        User{name='Pavel', age=25}
//        User{name='Valera', age=40}



    }
}