package com.hansky.test;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by shanghui on 2018/1/27.
 */
public class Liuhuan {
    public static void main(String[] args) {
        List<Integer> listAll = new ArrayList<Integer>();   //所有数值
        production(listAll,3);
        Set<Integer> all = new HashSet<Integer>(); //所有组合
        AllPermutation.allSort(listAll,0,listAll.size()-1,all);
        System.out.println(all.size());
        System.out.println(all);
    }

    //生产值
    public static void production(List<Integer> listAll, int i) {
        int max = (int) Math.pow(3, i);
        for (int x = 1; x <= max; x++) {
            listAll.add(x);
        }
    }






}
