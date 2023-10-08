package br.com.coding.T01_Find_The_Median;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int findMedian(List<Integer> arr) {
        // Write your code here
        return arr.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList())
                .get(arr.size() / 2);
    }

}