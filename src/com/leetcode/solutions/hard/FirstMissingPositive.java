package com.leetcode.solutions.hard;

/*
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example:
 * - given [1,2,0] return 3;
 * - given [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {

    public int getFirstMissingPositive(int[] array) {

        if (array == null) {
            throw new IllegalStateException("Input array cannot be null.");
        }
        /*
         * 1. Move all negative elements to right side and all positive elements - to left
         * Complexity - O(N)
         */
        int positiveIndex = 0;
        int negativeIndex = array.length - 1;

        while (positiveIndex < negativeIndex + 1) {
            while (negativeIndex >= 0 && array[negativeIndex] <= 0) {
                negativeIndex--;
            }
            while (positiveIndex < array.length && array[positiveIndex] > 0) {
                positiveIndex++;
            }

            if (positiveIndex < negativeIndex) {
                int temp = array[positiveIndex];
                array[positiveIndex] = array[negativeIndex];
                array[negativeIndex] = temp;
            }
        }

        /*
         * 2. We have the end index for all positive elements and all positive elements in the left part of the array.
         * So we can check: if we have some positive element and this positive element is in range of indexes of our
         * positive sub array - mark this value as negative one.
         */
        for (int i = 0; i < positiveIndex; i++) {
            if (Math.abs(array[i]) - 1 < positiveIndex && array[Math.abs(array[i]) - 1] > 0) {
                array[Math.abs(array[i]) - 1] = -array[Math.abs(array[i]) - 1];
            }
        }

        /*
         * 3. Now we can check, which value by index is more than 0.
         * If we have one then our result is (index + 1) - because we started from 0 index.
         */
        for (int i = 0; i < positiveIndex; i++) {
            if (array[i] > 0) {
                return i + 1;
            }
        }

        return positiveIndex + 1;
    }
}
