package br.com.coding.T05_Pairs;

import java.util.Collections;
import java.util.List;

class Result {
    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER k
     * 2. INTEGER_ARRAY arr
     */
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int pairs = 0;
        for (int i = 0; i < arr.size(); i++) {
            Integer current = arr.get(i);
            for (int j = i + 1; j < arr.size(); j++) {
                Integer next = arr.get(j);
                int difference = Math.abs(current - next);
                if (difference > k) break;
                if (difference == k) pairs++;
            }
        }
        return pairs;
    }
}
