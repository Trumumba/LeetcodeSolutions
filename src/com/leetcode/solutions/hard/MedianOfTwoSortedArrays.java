package com.leetcode.solutions.hard;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {

    public float solution(int[] array1, int[] array2) {
        int m = array1.length;
        int n = array2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = array1;
            array1 = array2;
            array2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && array2[j - 1] > array1[i]) {
                iMin++; // i is too small
            } else if (i > iMin && array1[i - 1] > array2[j]) {
                iMax--; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = array2[j - 1];
                } else if (j == 0) {
                    maxLeft = array1[i - 1];
                } else {
                    maxLeft = Math.max(array1[i - 1], array2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = array2[j];
                } else if (j == n) {
                    minRight = array1[i];
                } else {
                    minRight = Math.min(array2[j], array1[i]);
                }

                return (maxLeft + minRight) / 2.0f;
            }
        }
        return 0.0f;
    }
}