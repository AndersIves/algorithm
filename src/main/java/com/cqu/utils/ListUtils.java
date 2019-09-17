package com.cqu.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author AndersIves
 * @date 2019/9/17 下午 07:32
 */
public class ListUtils {
    private static Random random = new Random();

    public static List generateRandomIntegers(int size, int startedRange, int endedRange) {
        return Stream.generate(()->startedRange + random.nextInt(endedRange - startedRange + 1))
                .limit(size)
                .collect(Collectors.toList());
    }

    public static List generateRandomDoubles(int size, double startedRange, double endedRange) {
        return Stream.generate(()->startedRange + random.nextDouble() * (endedRange - startedRange))
                .limit(size)
                .collect(Collectors.toList());
    }

    public static void reverse(List list) {
        if (list == null) {
            return;
        }
        else if (list.size() <= 1) {
            return;
        }
        else {
            Object temp;
            int size = list.size();
            int halfSize = size / 2;
            for (int i = 0;i < halfSize;i++) {
                temp = list.get(i);
                list.set(i, list.get(size - i - 1));
                list.set(size - i - 1, temp);
            }
        }
    }
}
