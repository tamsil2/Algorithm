package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13144 {
    public static int N, answer;
    public static int[] arr, cnt;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        cnt = new int[100000 + 1];
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
