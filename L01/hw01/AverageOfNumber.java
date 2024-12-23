package org.dav.hw01;

import java.util.List;

/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class AverageOfNumber {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 4, 13, 38, 45, 2, 5, 76);
        double averageSum = integerList.stream().mapToDouble(Integer::doubleValue)
                .filter(num -> num % 2 == 0).average().orElse(0.0);
        System.out.println(STR."Среднее значение всех четных чисел в списке: \{averageSum}");
    }
}
