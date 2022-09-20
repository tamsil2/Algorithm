package me.tamsil.programmers;

import java.io.IOException;
import java.util.Arrays;

public class KNumber {
    public static void main(String[] args) throws IOException {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = new KNumber().solution(array, command);
        Arrays.stream(answer)
                .forEach(i -> {
                    System.out.print(i + " ");
                });
        System.out.println();
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int start, end, point;
        for (int i = 0; i < commands.length; i++) {
            start = commands[i][0] - 1;
            end = commands[i][1] - 1;
            point = commands[i][2] - 1;
            int[] newArray = new int[end - start + 1];
            int count = 0;
            for (int j = start; j <= end; j++) {
                newArray[count] = array[j];
                count++;
            }
            Arrays.sort(newArray);
            answer[i] = newArray[point];
        }
        return answer;
    }
}
