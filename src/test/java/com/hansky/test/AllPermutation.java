package com.hansky.test;

import java.util.*;

/**
 * Created by shanghui on 2018/1/27.
 */
public class AllPermutation {

    static void allSort(List<Integer> array, int begin, int end,Set<Integer> all){

        if(begin==end){
            System.out.println(array);
            List<Integer> su = new ArrayList<Integer>();
            su.addAll(array);
            allocation(su);
            all.add(su.get(0));
            return;
        }
        for(int i=begin;i<=end;i++){
            swap(array,begin,i );
            allSort(array, begin+1, end,all);
            swap(array,begin,i );
        }
    }

    static void swap(List<Integer> array,int a,int b){
        int tem=array.get(a);
        array.set(a,array.get(b));
        array.set(b,tem);
    }


    //胜出值
    public static void allocation(List<Integer> listAll) {

        if (listAll.size()>=3){
            List<Integer> list = listAll.subList(0, 3);
            int compare = compare(list);
            listAll.removeAll(list);
            listAll.add(compare);
            allocation(listAll);
        }
        return;
    }

    //比较值
    public static int compare(List<Integer> list) {
        Collections.sort(list);
        return list.get(1);
    }
}
