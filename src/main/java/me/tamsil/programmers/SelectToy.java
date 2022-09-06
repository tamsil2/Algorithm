package me.tamsil.programmers;

import java.util.Stack;

public class SelectToy {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int answer = new SelectToy().solution(board, moves);
        System.out.println("answer = " + answer);
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] gameStack = new Stack[board[0].length];
        Stack<Integer> basket = new Stack<>();
        for (int i = 0; i < board[0].length; i++) {
            gameStack[i] = new Stack();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    gameStack[j].push(board[i][j]);
                }
            }
        }

        for (int i = 0; i < moves.length; i++) {
            if (gameStack[moves[i] - 1].isEmpty()) {
                continue;
            }

            int number = gameStack[moves[i] -1].pop();
            if (basket.size() == 0) {
                basket.push(number);
            } else {
                if (number == basket.peek()) {
                    answer += 2;
                    basket.pop();
                } else {
                    basket.push(number);
                }
            }
        }
        return answer;
    }
}
