package br.com.coding.P12_New_Year_Chaos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */
    public static void minimumBribes(List<Integer> q) {
        int swap = 0;
        int pos = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(pos) - (pos + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            int j = 0;
            if (q.get(i) - 2 >= 1) {
                j = q.get(i) - 2;
            }
            while (j <= i) {
                if (q.get(j) > q.get(i)) {
                    swap++;
                }
                j++;
            }
            pos++;
        }
        System.out.println(swap);
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
