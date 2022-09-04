package me.tamsil.programmers;

import java.util.HashMap;
import java.util.Map;

public class NumberString {
    Map<String, Integer> numberMap = new HashMap<>();

    public static void main(String[] args) {
        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        int answer1 = new NumberString().solution(s1);
        int answer2 = new NumberString().solution(s2);
        int answer3 = new NumberString().solution(s3);
        int answer4 = new NumberString().solution(s4);
        System.out.println("answer = " + answer1);
        System.out.println("answer = " + answer2);
        System.out.println("answer = " + answer3);
        System.out.println("answer = " + answer4);
    }

    public int solution(String s) {
        numberMap.put("zero", 0);
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);

        StringBuilder answerBuilder = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                String targetStr = sb.toString();
                if (targetStr != null && !targetStr.equals("")) {
                    answerBuilder.append(numberMap.get(targetStr));
                }
                sb = new StringBuilder();
                char aChar = chars[i];
                answerBuilder.append(aChar);
            } else if (isMatchNumber(sb.toString())) {
                answerBuilder.append(numberMap.get(sb.toString()));
                sb = new StringBuilder().append(chars[i]);
            } else {
                sb.append(chars[i]);
            }
        }

        if (sb.toString() != null && !sb.toString().equals("")) {
            answerBuilder.append(numberMap.get(sb.toString()));
        }

        return Integer.parseInt(String.valueOf(answerBuilder));
    }

    private boolean isMatchNumber(String str) {
        return numberMap.keySet()
                .stream()
                .anyMatch(key -> key.equals(str));
    }
}
