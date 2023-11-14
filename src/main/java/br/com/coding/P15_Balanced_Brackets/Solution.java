package br.com.coding.P15_Balanced_Brackets;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    static Map<Character, Character> match = new HashMap<>();

    static {
        match.put('{', '}');
        match.put('(', ')');
        match.put('[', ']');
    }

    public static String isBalanced(String s) {
        // Write your code here
        char[] c = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < c.length; i++) {
            if (match.containsKey(c[i])) {
                stack.push(c[i]);
            }
            else if (stack.isEmpty() || match.get(stack.pop()) != c[i]) {
                return "NO";
            }
        }

        return stack.isEmpty() ? "YES" : "NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
