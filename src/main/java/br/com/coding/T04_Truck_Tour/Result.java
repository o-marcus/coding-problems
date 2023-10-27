package br.com.coding.T04_Truck_Tour;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
        int size = petrolpumps.size();
        for (int i = 0; i < size; i++) {
            int amount = petrolpumps.get(i).get(0) - petrolpumps.get(i).get(1);
            if (amount < 0) continue;
            int tanks = 1;
            for (int j = 1; j <= size - 1; j++) {
                int cIndex = (i + j) % size;
                amount += petrolpumps.get(cIndex).get(0) - petrolpumps.get(cIndex).get(1);
                if (amount < 0) break;
                tanks++;
            }
            if (tanks == size) return i;
        }
        return -1;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
