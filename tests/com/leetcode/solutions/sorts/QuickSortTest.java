package com.leetcode.solutions.sorts;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class QuickSortTest {

    @Test
    public void testEmptyArray() {
        int[] array = new int[]{};
        new QuickSort().sort(array);
        Assert.assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void testArrayWithOneElement() {
        int[] array = new int[]{1};
        new QuickSort().sort(array);
        Assert.assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void testArrayTheSameValues() {
        int[] array = new int[]{1,1,1,1,1,1,1};
        new QuickSort().sort(array);
        Assert.assertArrayEquals(new int[]{1,1,1,1,1,1,1}, array);
    }

    @Test
    public void testArrayPositiveValues() {
        int[] array = new int[]{1,2,1,6,3,9,7};
        new QuickSort().sort(array);
        Assert.assertArrayEquals(new int[]{1,1,2,3,6,7,9}, array);
    }

    @Test
    public void testArrayNegativeValues() {
        int[] array = new int[]{-1,-5,-74,-3,-8,-2,-4};
        new QuickSort().sort(array);
        Assert.assertArrayEquals(new int[]{-74,-8,-5,-4,-3,-2,-1}, array);
    }

    @Test
    public void testArrayPositiveNegativeValues() {
        int[] array = new int[]{1,-5,74,-3,-8,-2,-4};
        new QuickSort().sort(array);
        Assert.assertArrayEquals(new int[]{-8,-5,-4,-3,-2,1,74}, array);
    }

    @Test
    public void testHugeArray() {
        Random random = new Random();
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = random.nextInt();
        }
        int[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);

        new QuickSort().sort(array);

        Assert.assertArrayEquals(expected, array);
    }
}
