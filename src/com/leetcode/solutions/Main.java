package com.leetcode.solutions;

import com.leetcode.solutions.sorts.QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // TODO: see the solutions in packages

        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(10);
        }
        int[] expected = Arrays.copyOf(array, array.length);
        System.out.println("##### 1: " + Arrays.toString(expected));
        Arrays.sort(expected);

        new QuickSort().sort(array);
        System.out.println("##### 1: " + Arrays.toString(array));
    }
}
