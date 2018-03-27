package com.leetcode.solutions.sorts;

public class MergeSort implements Sorter {

    private int[] array;
    private int[] temp;

    @Override
    public void sort(int[] array) {
        if (array == null) {
            throw new IllegalStateException("Input data cannot be null");
        }

        if (array.length < 2) {
            return;
        }

        this.array = array;
        this.temp = new int[array.length];

        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int left, int right) {
        // if left index less then the right one - we have sub arrays yet
        if (left < right) {
            int middle = left + (right - left) / 2;

            // handle left sub array
            mergeSort(left, middle);

            // handle right sub array
            mergeSort(middle + 1, right);

            // merge them together
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        // we have to copy the current sub array to temp array
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }

        int i = left;
        int j = middle + 1;
        int index = left;

        // we are checking elements by indexes in two parts and putting the current value into the right position in the result array.
        while (i <= middle && j <= right) {
            if (temp[i] <= temp[j]) {
                array[index] = temp[i];
                i++;
            } else {
                array[index] = temp[j];
                j++;
            }
            index++;
        }

        while (i <= middle) {
            array[index] = temp[i];
            i++;
            index++;
        }
    }
}