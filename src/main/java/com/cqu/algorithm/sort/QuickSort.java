package com.cqu.algorithm.sort;

import com.cqu.utils.ListUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author AndersIves
 * @date 2019/9/17 下午 07:31
 */
public class QuickSort {
    public static void main(String[] args) {
        List list;

        list = ListUtils.generateRandomIntegers(54,0,100);
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
            quickSort(list, 0, list.size() - 1);
        }
    }
    private static void quickSort(List<Integer> list, int indexL, int indexR) {
        if (indexL >= indexR) {
            return;
        }
        int leftBorder = indexL;
        int rightBorder = indexR;
        int pivot = list.get(indexL);
        while (indexL < indexR) {
            while (indexL < indexR && pivot <= list.get(indexR)) {
                indexR--;
            }
            if (indexL < indexR) {
                list.set(indexL, list.get(indexR));
                indexL++;
            }
            while (indexL < indexR && pivot > list.get(indexL)) {
                indexL++;
            }
            if (indexL < indexR) {
                list.set(indexR, list.get(indexL));
                indexR--;
            }
        }
        list.set(indexL, pivot);
        quickSort(list, leftBorder, indexL - 1);
        quickSort(list, indexL + 1, rightBorder);
    }
}
