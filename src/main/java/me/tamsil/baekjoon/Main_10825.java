package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_10825 {
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static ArrayList<Student> students;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Student(name, korean, english, math));
        }
    }

    public static void solution() {
        Collections.sort(students);
        for (int i = 0; i < students.size(); i++) {
            sb.append(students.get(i).name).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    static class Student implements Comparable<Student> {

        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student other) {
            if (this.korean != other.korean) {
                return other.korean - this.korean;
            }
            if (this.english != other.english) {
                return this.english - other.english;
            }
            if (this.math != other.math) {
                return other.math - this.math;
            }
            return this.name.compareTo(other.name);
        }
    }

}
