package com.leetcode.solutions.easy;

/*
 * Implementation of the Fizz Buzz game.
 *
 * Players generally sit in a circle. The player designated to go first says the number "1", and each player counts
 * one number in turn. However, any number divisible by three is replaced by the word fizz and any divisible by
 * five by the word buzz. Numbers divisible by both become fizz buzz.
 */
public class FizzBuzz {

    public void printFizzBuzz(int number) {
        for (int i = 1; i <= number; i++) {
            final StringBuilder step = new StringBuilder();
            if (i % 3 == 0) {
                step.append("Fizz");
            }
            if (i % 5 == 0) {
                step.append("Buzz");
            }
            if (step.length() == 0) {
                step.append(i);
            }
            System.out.println(i + " - " + step);
        }
    }
}
