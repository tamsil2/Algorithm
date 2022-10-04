package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {
    private static int T, N, M;
    private static int[][] arr, dist;
    private static boolean[][] checked;
    private static int[] nextX = {-1, 0, 1, 0};
    private static int[] nextY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N + 1][M + 1];
            dist = new int[N + 1][M + 1];
            checked = new boolean[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                String[] split = br.readLine().split("");
                for (int j = 1; j <= M; j++) {
                    arr[i][j] = Integer.parseInt(split[j - 1]);
                }
            }

            dfs(1, 1);
            System.out.println(dist[N][M]+1);
        }
    }

    public static void dfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        checked[x][y] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = pair.x + nextX[i];
                int newY = pair.y + nextY[i];

                if (checkRange(newX, newY) && !checked[newX][newY] && arr[newX][newY] == 1) {
                    queue.add(new Pair(newX, newY));
                    dist[newX][newY] = dist[pair.x][pair.y] + 1;
                    checked[newX][newY] = true;
                    if (dist[N][M] > 0) {
                        break;
                    }
                }
            }
        }
    }

    public static boolean checkRange(int x, int y) {
        if (x > 0 && x <= N && y > 0 && y <= M) {
            return true;
        }
        return false;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
