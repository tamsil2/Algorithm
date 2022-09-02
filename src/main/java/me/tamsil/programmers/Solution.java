package me.tamsil.programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        Solution solution = new Solution();
        int[] answer = solution.solution(arr);
    }

    public int[] solution(int[] arr) {
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                answerList.add(arr[i]);
            } else if (arr[i - 1] != arr[i]) {
                answerList.add(arr[i]);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
