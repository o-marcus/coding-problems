package br.com.coding.P02_Mini_Max_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        List<Integer> sortedList = arr.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        long max =  sortedList.stream()
                .mapToLong(t -> t)
                .skip(1)
                .sum();

        long min =  sortedList.stream()
                .mapToLong(t -> t)
                .limit(arr.size() - 1).sum();

        System.out.println(min + " " + max);

    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
