package me.tamsil.programmers;

import java.util.ArrayList;
import java.util.List;

public class PersonalityType {

    private static List<Point> pointList = new ArrayList<>();

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

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

        for (int i = 1; i < 4; i++) {
            int maxValue = 0;
            String maxStr = "";
            for (int j = 0; j < pointList.size(); j++) {
                if (pointList.get(j).type == i) {
                    if (pointList.get(j).score > maxValue) {
                        maxStr = pointList.get(j).str;
                    } else if (pointList.get(j).score == maxValue) {
                        String str = pointList.get(j).str;
                        maxStr = (str.compareTo(maxStr) > 0) ? str : maxStr;
                    }
                }
                if (pointList.get(j).type == i && pointList.get(j).score > maxValue) {
                    maxStr = pointList.get(j).str;
                } else if (pointList.get(j).type == i && pointList.get(j).score == maxValue) {

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
