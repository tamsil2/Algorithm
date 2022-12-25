package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2251 {
    static int[] A;
    static boolean[] available;
    static boolean[][][] visited;
    static StringBuilder sb = new StringBuilder();

    static void bfs(int x1, int x2, int x3) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(new int[]{x1, x2, x3}));
        visited[x1][x2][x3] = true;

        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.X[0] == 0) {
                available[state.X[2]] = true;
            }

            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if(from == to) continue;
                    State moveState = state.move(from, to, A);
                    if (!visited[moveState.X[0]][moveState.X[1]][moveState.X[2]]) {
                        visited[moveState.X[0]][moveState.X[1]][moveState.X[2]] = true;
                        queue.add(moveState);
                    }
                }
            }
        }
    }

    static void solution() {
        bfs(0, 0, A[2]);
        for (int i = 0; i < 205; i++) {
            if (available[i]) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[3];
        A[0] = Integer.parseInt(st.nextToken());
        A[1] = Integer.parseInt(st.nextToken());
        A[2] = Integer.parseInt(st.nextToken());
        available = new boolean[205];
        visited = new boolean[205][205][205];
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }


}

class State {
    int[] X;

    State(int[] _X) {
        X = new int[3];
        for (int i = 0; i < 3; i++) {
            this.X[i] = _X[i];
        }
    }

    State move(int from, int to, int[] limit) {
        int[] nx = new int[]{X[0], X[1], X[2]};
        if (X[from] + X[to] <= limit[to]) {
            nx[to] = nx[from] + nx[to];
            nx[from] = 0;
        } else {
            nx[from] -= limit[to] - nx[to];
            nx[to] = limit[to];
        }
        return new State(nx);
    }
}
