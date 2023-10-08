package br.com.coding.T02_Fiipping_The_Matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Result {
    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
    public static int flippingMatrix(List<List<Integer>> m) {
        // Write your code here
        int sum = 0;
        int size = m.get(0).size();
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size / 2; j++) {
                sum += Arrays.asList(
                                m.get(i).get(j),
                                m.get(i).get(size - 1 - j),
                                m.get(size - 1 - i).get(j),
                                m.get(size - 1 - i).get(size - 1 - j)
                        )
                        .stream().max(Comparator.naturalOrder()).get();
            }
        }

        return sum;
    }

}