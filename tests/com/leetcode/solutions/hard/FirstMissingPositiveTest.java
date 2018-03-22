package com.leetcode.solutions.hard;

import org.junit.Assert;
import org.junit.Test;

public class FirstMissingPositiveTest {

    @Test(expected = IllegalStateException.class)
    public void testNullException() {
        new FirstMissingPositive().getFirstMissingPositive(null);
    }

    @Test
    public void testHasNoPositives() {
        Assert.assertEquals(1, new FirstMissingPositive().getFirstMissingPositive(new int[]{-1,-2,-3,-4,-5}));
    }

    @Test
    public void testHasNoNegativesResultAtStart() {
        Assert.assertEquals(1, new FirstMissingPositive().getFirstMissingPositive(new int[]{0,2,3,4,5}));
    }

    @Test
    public void testHasNoNegativesResultInMiddle() {
        Assert.assertEquals(3, new FirstMissingPositive().getFirstMissingPositive(new int[]{5,2,0,1,5}));
    }

    @Test
    public void testHasNoNegativesResultAtEnd() {
        Assert.assertEquals(6, new FirstMissingPositive().getFirstMissingPositive(new int[]{4,2,3,1,5}));
    }

    @Test
    public void testHasPositivesAndNegatives() {
        Assert.assertEquals(4, new FirstMissingPositive().getFirstMissingPositive(new int[]{0,-2,1,3,-4,5,2}));
    }
}
