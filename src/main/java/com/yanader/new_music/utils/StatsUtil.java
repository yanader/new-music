package com.yanader.new_music.utils;

import java.util.*;

public final class StatsUtil {

    private StatsUtil(){}

    public static double mean(List<Integer> nums){
        if (nums.isEmpty()) return 0.0;
        int sum = 0;
        for (Integer num: nums) {
            sum += num;
        }
        return sum * 1.0 / nums.size();
    }

    public static double median(List<Integer> nums){
        List<Integer> sorted = nums.stream().sorted().toList();
        int size = nums.size();
        if (size == 0) return 0.0;
        if (size % 2 == 1) {
            return sorted.get(size/2) * 1.0;
        } else {
            return (sorted.get(size / 2 - 1) + sorted.get(size / 2)) / 2.0;
        }
    }


    public static Integer mode(List<Integer> nums){
        if (nums.isEmpty()) return null;
        Map<Integer, Integer> scores = new HashMap<>();

        for (Integer num: nums) {
            scores.put(num, scores.getOrDefault(num, 0) + 1);
        }

        int mode = -1;
        int count = -1;

        for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }

    public static Double stdDev(List<Integer> nums){

        if (nums.size() < 2) return null;

        double mean = mean(nums);

        double variance = 0.0;
        for (int num : nums) {
            variance += Math.pow(num - mean, 2);
        }
        variance /= (nums.size() - 1);

        return Math.sqrt(variance);
    }
}
