package me.tamsil.programmers;

import java.io.IOException;
import java.util.Arrays;

// TODO. 체육복 있는 사람 Y, 체육복 잃어버린 사람 N, 여분 있는 사람 R
public class GymSuit {
    public static void main(String[] args) throws IOException {
        int n = 5;
        int[] lost = {2, 4};
        int[] reverse = {3};

        int answer = new GymSuit().solution(n, lost, reverse);
        System.out.println(answer);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        char[] suitArr = new char[n];
        Arrays.fill(suitArr, 'Y');

        for (int i = 0; i < lost.length; i++) {
            suitArr[lost[i] - 1] = 'N';
        }

        for (int i = 0; i < reserve.length; i++) {
            if (suitArr[reserve[i] - 1] == 'N') {
                suitArr[reserve[i] - 1] = 'Y';
            } else {
                suitArr[reserve[i] - 1] = 'R';
            }
        }

        for (int i = 0; i < suitArr.length; i++) {
            if (suitArr[i] == 'N') {
                if (i > 0 && suitArr[i - 1] == 'R') {
                    answer++;
                } else if (i < n - 1 && suitArr[i + 1] == 'R') {
                    answer++;
                    suitArr[i + 1] = 'A';
                }
            } else {
                answer++;
            }
        }

        return answer;
    }
}
