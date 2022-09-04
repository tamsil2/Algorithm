package me.tamsil.programmers;

import java.util.ArrayList;
import java.util.List;

public class PersonalityType {

    private List<Point> pointList = new ArrayList<>();

    public static void main(String[] args) {
//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        String[] survey = {"TR", "RT", "TR"};
//        int[] choices = {5, 3, 2, 7, 5};
        int[] choices = {7, 1, 3};

        String answer = new PersonalityType().solution(survey, choices);
        System.out.println("answer = " + answer);
    }

    public String solution(String[] survey, int[] choices) {
        StringBuilder answerBuilder = new StringBuilder();
        initPointList();
        for (int i = 0; i < survey.length; i++) {
            String[] split = survey[i].split("");
            Point leftPoint = findPoint(split[0]);
            Point rightPoint = findPoint(split[1]);
            switch (choices[i]) {
                case 1:
                    leftPoint.score += 3;
                    break;
                case 2:
                    leftPoint.score += 2;
                    break;
                case 3:
                    leftPoint.score += 1;
                    break;
                case 4:
                    break;
                case 5:
                    rightPoint.score += 1;
                    break;
                case 6:
                    rightPoint.score += 2;
                    break;
                case 7:
                    rightPoint.score += 3;
                    break;
            }
        }

        for (int i = 1; i < 5; i++) {
            int maxValue = -1;
            String maxStr = "";

            for (int j = 0; j < pointList.size(); j++) {
                Point thisPoint = pointList.get(j);
                if (thisPoint.type == i) {
                    if (thisPoint.score > maxValue) {
                        maxValue = thisPoint.score;
                        maxStr = thisPoint.str;
                    } else if (thisPoint.score == maxValue) {
                        maxStr = (thisPoint.str.compareTo(maxStr) < 0) ? thisPoint.str : maxStr;
                    }
                }
            }
            answerBuilder.append(maxStr);
        }
        return answerBuilder.toString();
    }

    private Point findPoint(String str) {
        Point point = pointList.stream()
                .filter(p -> p.str.equals(str))
                .findAny()
                .get();
        return point;
    }

    public void initPointList() {
        pointList.add(new Point(1, "R", 0));
        pointList.add(new Point(1, "T", 0));
        pointList.add(new Point(2, "C", 0));
        pointList.add(new Point(2, "F", 0));
        pointList.add(new Point(3, "J", 0));
        pointList.add(new Point(3, "M", 0));
        pointList.add(new Point(4, "A", 0));
        pointList.add(new Point(4, "N", 0));
    }
}

class Point {
    public Point(int type, String str, int score) {
        this.type = type;
        this.str = str;
        this.score = score;
    }

    int type;
    String str;
    int score;
}
