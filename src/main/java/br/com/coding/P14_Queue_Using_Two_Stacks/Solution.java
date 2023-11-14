package br.com.coding.P14_Queue_Using_Two_Stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Solution {

    static Queue<Integer> queue = new LinkedList<>();
    private static final int ENQUEUE = 1;
    private static final int DEQUEUE = 2;
    private static final int PRINT = 3;

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int queries = Integer.parseInt(bufferedReader.readLine());
        IntStream.range(0, queries).forEach(value -> {
            try {
                String[] line = bufferedReader.readLine().split(" ");
                int action = Integer.parseInt(line[0]);
                switch (action) {
                    case ENQUEUE:
                        int input = Integer.parseInt(line[1]);
                        enqueue(input);
                        break;
                    case DEQUEUE:
                        dequeue();
                        break;
                    case PRINT:
                        print();
                        break;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });

    }

    static void enqueue(int value) {
        queue.add(value);
    }

    static void dequeue() {
        queue.remove();
    }

    static void print() {
        System.out.println(queue.peek());
    }

}