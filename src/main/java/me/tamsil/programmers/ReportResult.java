package me.tamsil.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportResult {
    public static void main(String[] args) {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        ReportResult reportResult = new ReportResult();
        int[] answer = reportResult.solution(id_list, report, k);
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> resultMap = new HashMap<>();
        Map<String, List<String>> reporterMap = new HashMap<>();
        Map<String, Integer> reportingMap = new HashMap<>();
        for (String id : id_list) {
            resultMap.put(id, 0);
            reporterMap.put(id, new ArrayList<>());
            reportingMap.put(id, 0);
        }

        for (int i = 0; i < report.length; i++) {
            String[] reportSplit = report[i].split(" ");
            String user = reportSplit[0];
            String target = reportSplit[1];

            List<String> reporterList = reporterMap.get(user);
            boolean matchBoolean = reporterList.stream()
                    .anyMatch(str -> str.equals(target));

            if (!matchBoolean) {
                reporterList.add(target);
                reporterMap.put(user, reporterList);
                reportingMap.put(target, reportingMap.get(target) + 1);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            List<String> userList = reporterMap.get(user);
            for (String s : userList) {
                Integer integer = reportingMap.get(s);
                if (integer >= k) {
                    resultMap.put(user, resultMap.get(user) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = resultMap.get(id_list[i]);
        }
        return answer;
    }
}
