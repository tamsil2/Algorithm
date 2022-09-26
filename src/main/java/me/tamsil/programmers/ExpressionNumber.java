package me.tamsil.programmers;

public class ExpressionNumber {
    public static void main(String[] args) {
        int n = 15;
        int answer = new ExpressionNumber().solution(n);
        System.out.println(answer);
    }

    public int solution(int n) {
        int answer = 1;

        for (int i = 1; i < n; i++) {
            int count = i;
            int sum = count;
            boolean equals = false;
            while (sum <= n) {
                sum += ++count;
                if (sum == n) {
                    equals = true;
                }
            }
            if (equals) {
                answer++;
            }
        }

        return answer;
    }
}
