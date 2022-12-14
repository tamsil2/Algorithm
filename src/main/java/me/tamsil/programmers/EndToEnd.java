package me.tamsil.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EndToEnd {
    public static void main(String[] args) {
        int n1 = 3;
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n2 = 5;
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int n3 = 2;
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        int[] answer1 = new EndToEnd().solution(n1, words1);
        System.out.println(answer1[0] + "," + answer1[1]);
        int[] answer2 = new EndToEnd().solution(n2, words2);
        System.out.println(answer2[0] + "," + answer1[1]);
        int[] answer3 = new EndToEnd().solution(n3, words3);
        System.out.println(answer3[0] + "," + answer1[1]);
    }

    public int[] solution(int n, String[] words) {
        int[] answer = {};
        List<HashMap<String, Integer>> hashMapList = new ArrayList<>();
        HashMap<String, Integer> n1 = new HashMap<>();
        return answer;
    }
}
