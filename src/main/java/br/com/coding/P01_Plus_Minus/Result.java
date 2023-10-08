package br.com.coding.P01_Plus_Minus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (Integer number : arr) {
            if (number < 0) {
                negative++;
            }
            else if (number > 0) {
                positive++;
            }
            else {
                zero++;
            }
        }


        float size = arr.size();
        float posRatio =  positive / size;
        float negRatio = negative / size;
        float zeroRatio = zero / size;

        System.out.printf("%f\n%f\n%f", posRatio, negRatio, zeroRatio);
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);
        bufferedReader.close();
    }
}
