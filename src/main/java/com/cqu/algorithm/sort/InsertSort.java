package com.cqu.algorithm.sort;

import com.cqu.utils.ListUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author AndersIves
 * @date 2019/9/17 下午 07:31
 */
public class InsertSort {
    public static void main(String[] args) {
        List list;

        list = ListUtils.generateRandomIntegers(53,0,100);
        System.out.println(list);
        sort(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
    public static void  insert_sort(int array[],int lenth){

        int temp;

        for(int i=0;i<lenth-1;i++){
            for(int j=i+1;j>0;j--){
                if(array[j] < array[j-1]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }else{         //不需要交换
                    break;
                }
            }
        }
    }
    public static void sort(List<Integer> list) {
        if (list == null) {
            return;
        }
        else if (list.size() <= 1) {
            return;
        }
        else {
            int startPoint = 0;
            int temp;
            boolean isInsert;
            for (int i = 0;i < list.size() - 1;i++) {
                if (list.get(i) > list.get(i + 1)) {
                    startPoint = i + 1;
                    break;
                }
            }
            for (int i = startPoint;i < list.size();i++) {
                for (int j = 0;j < i;j++) {
                    if (list.get(i) < list.get(j)) {
                        temp = list.get(i);
                        list.remove(i);
                        list.add(j, temp);
                    }
                }
            }

        }
    }
}
