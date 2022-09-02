package me.tamsil.programmers;

import java.util.Arrays;

public class MinRectangle {
    public static void main(String[] args) {
        int[][] sizes = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        MinRectangle minRectangle = new MinRectangle();
        minRectangle.solution(sizes);
    }

    public int solution(int[][] sizes) {
        int answer = 0;

        Integer maxX = Arrays.stream(sizes)
                .map(arr -> {
                    if (arr[1] > arr[0]) {
                        return new int[]{arr[1], arr[0]};
                    }
                    return arr;
                }).map(arr -> arr[0])
                .max(Integer::compareTo)
                .get();

        Integer maxY = Arrays.stream(sizes)
                .map(arr -> {
                    if (arr[1] > arr[0]) {
                        return new int[]{arr[1], arr[0]};
                    }
                    return arr;
                }).map(arr -> arr[1])
                .max(Integer::compareTo)
                .get();

        answer = maxX * maxY;
        return answer;
    }
}
