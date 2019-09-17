package com.cqu.algorithm.sort;

import com.cqu.utils.ListUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author AndersIves
 * @date 2019/9/17 下午 07:31
 */
public class SelectSort {
    public static void main(String[] args) {
        List list;

        list = ListUtils.generateRandomIntegers(51,0,100);
        System.out.println(list);
        sort(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
    public static void sort(List<Integer> list) {
        if (list == null) {
            return;
        }
        else if (list.size() <= 1) {
            return;
        }
        else {
            int minIndex;
            int min;
            for (int i = 0;i < list.size() - 1;i++) {
                minIndex = i + 1;
                min = list.get(minIndex);
                for (int j = i + 1;j < list.size();j++) {
                    if (min > list.get(j)) {
                        minIndex = j;
                        min = list.get(minIndex);
                    }
                }
                list.set(minIndex, list.get(i));
                list.set(i, min);
            }
        }
    }
}
