package me.tamsil.programmers;

import java.util.Arrays;

public class JadenCase {
    public static void main(String[] args) {
//        String s = "3people unFollowed me";
//        String s = "for the last week";
        String s = " A  Sdf Fft ";
        String answer = new JadenCase().solution(s);
        System.out.println(answer);
    }

    public String solution(String s) {
        String answer = "";
        String[] splitString = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitString.length; i++) {
            String str = splitString[i];
            boolean isNumberStart = true;
            try {
                Integer.parseInt(Arrays.stream(str.split(""))
                        .findFirst()
                        .get());
            } catch (NumberFormatException e) {
                isNumberStart = false;
            }

            if (!isNumberStart) {
                StringBuilder subSb = new StringBuilder();
                for (int j = 0; j < str.length(); j++) {
                    String newStr = null;
                    if (j == 0) {
                        newStr = str.split("")[j].toUpperCase();
                    } else {
                        newStr = (!str.split("")[j].isEmpty()) ? str.split("")[j].toLowerCase() : str.split("")[j];
                    }
                    subSb.append(newStr);
                }
                sb.append(subSb);
            } else {
                if (!str.isEmpty()) {
                    sb.append(str.toLowerCase());
                } else {
                    sb.append(str);
                }
            }

            if (i != splitString.length - 1) {
                sb.append(" ");
            }
        }

        if (s.charAt(s.length() - 1) == ' ') {
            sb.append(" ");
        }
        answer = sb.toString();
        return answer;
    }
}
