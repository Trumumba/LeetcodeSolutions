package com.leetcode.solutions.sorts;

public class QuickSort extends BaseSort {

    private int[] array;

    @Override
    public void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        this.array = array;

        sort(0, array.length - 1);
    }

    private void sort(int left, int right) {
        int i = left;
        int j = right;

        int pivot = array[left + (right - left) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (left < j) {
            sort(left, j);
        }
        if (right > i) {
            sort(i, right);
        }
    }
}
