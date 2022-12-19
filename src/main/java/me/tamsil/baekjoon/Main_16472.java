package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16472 {
    static int N, kind, ans;
    static String S;
    static int[] cnt;

    static void add(char c) {
        cnt[c - 'a']++;
        if (cnt[c - 'a'] == 1) {
            kind++;
        }
    }

    static void erase(char c) {
        cnt[c - 'a']--;
        if (cnt[c - 'a'] == 0) {
            kind--;
        }
    }

    static void solution() {
        int len = S.length(), ans = 0;
        for (int R = 0, L = 0; R < S.length(); R++) {
            add(S.charAt(R));

            while (kind > N) {
                erase(S.charAt(L++));
            }

            ans = Math.max(ans, R - L + 1);
        }
        System.out.println(ans);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = br.readLine();
        cnt = new int[26];
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
