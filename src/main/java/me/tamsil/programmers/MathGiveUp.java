package me.tamsil.programmers;

import java.util.*;

public class MathGiveUp {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
//        int[] answers = {1, 3, 2, 4, 2};

        int[] answer = new MathGiveUp().solution(answers);
        for (int i : answer) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public int[] solution(int[] answers) {
        Map<Integer, List<Integer>> numberMap = new HashMap<>();
        numberMap.put(1, Arrays.asList(1, 2, 3, 4, 5));
        numberMap.put(2, Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        numberMap.put(3, Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        List<Integer> answerList = new ArrayList<>();
        Map<Integer, Integer> answerMap = new HashMap<>();

        Set<Integer> integers = numberMap.keySet();
        for (Integer integer : integers) {
            int answerCount = 0;
            List<Integer> numberList1 = numberMap.get(integer);
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == numberList1.get(i % numberList1.size())) {
                    answerCount++;
                }
            }
            answerMap.put(integer, answerCount);
        }

        for (Integer integer : answerMap.keySet()) {
            if (answerMap.get(integer) == answerMap.values().stream().reduce(0, Integer::max)) {
                answerList.add(integer);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
