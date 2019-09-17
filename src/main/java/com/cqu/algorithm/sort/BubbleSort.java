package com.cqu.algorithm.sort;

import com.cqu.utils.ListUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author AndersIves
 * @date 2019/9/17 下午 07:31
 */
public class BubbleSort {
    public static void main(String[] args) {
        List list;

        list = ListUtils.generateRandomIntegers(52,0,100);
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
            int temp;
            boolean isExchange;
            for (int i = 0;i < list.size() - 1;i++) {
                isExchange = false;
                for (int j = list.size() - 1;j > i ;j--) {
                    if (list.get(j) < list.get(j - 1)) {
                        temp  = list.get(j);
                        list.set(j, list.get(j - 1));
                        list.set(j - 1, temp);
                        isExchange = true;
                    }
                }
                if (!isExchange) {
                    break;
                }
            }
        }
    }
}
