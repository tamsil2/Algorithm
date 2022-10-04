package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260 {
    private static int T, N, M, V;
    private static int[][] vertex;
    private static boolean[] checked;
    private static StringTokenizer st;

//    public static void dfs(int start) {
//        Stack<Integer> stack = new Stack();
//
//        stack.push(start);
//        while (!stack.isEmpty()) {
//            int number = stack.pop();
//            if (checked[number]) {
//                continue;
//            }
//
//            checked[number] = true;
//            System.out.print(number + " ");
//
//            for (int i = 1; i < vertex.length; i++) {
//                if (vertex[number][i] == 1 && !checked[i]) {
//                    stack.push(i);
//                }
//            }
//        }
//    }

    public static void dfs(int start) {
        checked[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i < vertex.length; i++) {
            if (vertex[start][i] == 1 && checked[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        checked[start] = true;
        System.out.print(start + " ");

        while (!queue.isEmpty()) {
            int number = queue.poll();
            for (int i = 1; i < vertex.length; i++) {
                if (vertex[number][i] == 1 && !checked[i]) {
                    queue.add(i);
                    checked[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            vertex = new int[N + 1][N + 1];
            checked = new boolean[N + 1];
            int from, to;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                vertex[from][to] = 1;
                vertex[to][from] = 1;
            }

            dfs(V);
            System.out.println();
            Arrays.fill(checked, false);
            bfs(V);
            System.out.println();
        }
    }
}
