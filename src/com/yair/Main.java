package com.yair;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();

// PART 1
        int[] nums1 = new int[15];
        int[] nums2 = new int[15];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = rnd.nextInt(10);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = rnd.nextInt(10);
        }

// PART 2
        System.out.println("array num 1: ");
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ", ");
        }
        System.out.println("\narray num 2: ");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + ", ");
        }

// PART 3
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length - 2; i++) {
            if (nums1[i] >= max1) {
                max1 = nums1[i];
                max2 = nums1[i + 1];
                max3 = nums1[i + 2];
            }
        }
        System.out.println("\n" + max1 + max2 + max3);

// PART 4
        int[] distinct = new int[10];
        for (int i = 0; i < distinct.length; i++) {
            distinct[i] = -1;
        }
        boolean find = false;
        int counter = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                for (int j = 0; j < distinct.length; j++) {
                    if (distinct[j] == nums1[i]) {
                        find = true;
                    }
                }
            }
            if (!find) {
                distinct[counter] = nums1[i];
                counter++;
            } else {
                find = false;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums2[i] == nums1[j]) {
                    find = true;
                }
            }
            if (!find) {
                for (int j = 0; j < distinct.length; j++) {
                    if (distinct[j] == nums2[i]) {
                        find = true;
                    }
                }
            }
            if (!find) {
                distinct[counter] = nums2[i];
                counter++;
            } else {
                find = false;
            }
        }
// PART 5
        for (int i = 0; i < distinct.length; i++) {
            System.out.print(distinct[i] + ", ");
        }
// PART 6
        long sum = 0;
        double x = 100000000;
        for (int i = 0; i < counter; i++) {
            if (distinct[i] != -1) {
                sum += (distinct[i] * x);
                x = x * 0.1;
            }
        }
        System.out.println("\n" + sum);
    }
}