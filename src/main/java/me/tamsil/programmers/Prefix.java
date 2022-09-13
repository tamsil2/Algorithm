package me.tamsil.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prefix {
    public static void main(String[] args) {
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};

        boolean answer = new Prefix().solution(phone_book3);
        System.out.println("answer = " + answer);
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        HashMap<String, Integer> phoneBookMap = new HashMap<>();
        IntStream.range(0, phone_book.length)
                .forEach(i -> phoneBookMap.put(phone_book[i], i));
        List<String> phoneBookList = Arrays.stream(phone_book)
                .collect(Collectors.toList());

        for (int i = 0; i < phoneBookList.size(); i++) {
            String source = phoneBookList.get(i);
            for (int j = i + 1; j < phoneBookList.size(); j++) {

            }
        }

        return answer;
    }
}
