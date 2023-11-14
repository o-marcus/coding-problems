package br.com.coding.P16_Simple_Text_Editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {

    static StringBuilder sb = new StringBuilder();
    static Stack<String> stack = new Stack<String>();

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int queries = Integer.parseInt(reader.readLine());
        IntStream.range(0, queries).forEach(query -> {
            try {
                String[] lines = reader.readLine().split(" ");
                switch (Integer.parseInt(lines[0])) {
                    case 1:
                        stack.push(sb.toString());
                        sb.append(lines[1]);
                        break;
                    case 2:
                        stack.push(sb.toString());
                        int remove = Integer.parseInt(lines[1]);
                        sb.delete(sb.length() - remove, sb.length());
                        break;
                    case 3:
                        int position = Integer.parseInt(lines[1]) - 1;
                        System.out.println(sb.charAt(position ));
                        break;
                    case 4:
                        sb = new StringBuilder(stack.pop());
                        break;
                }
            }
            catch(IOException exception) {
                throw new RuntimeException(exception);
            }

        });
    }

}
