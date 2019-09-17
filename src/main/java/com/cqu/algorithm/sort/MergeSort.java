package com.cqu.algorithm.sort;

import com.cqu.utils.ListUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author AndersIves
 * @date 2019/9/17 下午 10:17
 */
public class MergeSort {
    public static void main(String[] args) {
        List list;

        list = ListUtils.generateRandomIntegers(55,0,100);
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
            List<List<Integer>> lists = new LinkedList();
            for (int i : list) {
                List<Integer> subList = new LinkedList<>();
                subList.add(i);
                lists.add(subList);
            }
            while (lists.size() != 1) {
                merge(lists);
            }
            list.clear();
            list.addAll(lists.get(0));
        }
    }
    private static void merge(List<List<Integer>> lists) {
        if (lists == null) {
            return;
        }
        else if (lists.size() <= 1) {
            return;
        }
        else {
            int size = lists.size();
            int halfSize = size / 2;
            for (int i = 0;i < halfSize;i++) {
                List<Integer> tempList = new LinkedList(lists.get(i));
                lists.get(i).clear();
                while (tempList.size() > 0 || lists.get(size - i - 1).size() > 0) {
                    if (tempList.size() == 0 ) {
                        lists.get(i).addAll(lists.get(size - i - 1));
                        lists.get(size - i - 1).clear();
                    }
                    else if (lists.get(size - i - 1).size() == 0) {
                        lists.get(i).addAll(tempList);
                        tempList.clear();
                    }
                    else if (tempList.get(0) <= lists.get(size - i - 1).get(0)) {
                        lists.get(i).add(tempList.get(0));
                        tempList.remove(0);
                    }
                    else {
                        lists.get(i).add(lists.get(size - i - 1).get(0));
                        lists.get(size - i - 1).remove(0);
                    }
                }
            }
            while (lists.get(lists.size() - 1).size() == 0) {
                lists.remove(lists.size() - 1);
            }
        }
    }
}
