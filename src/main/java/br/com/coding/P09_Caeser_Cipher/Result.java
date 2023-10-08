package br.com.coding.P09_Caeser_Cipher;

import java.io.*;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z')  {
                sb.append(getCharRotation(c, 'A', 'Z', k));
                System.out.println("");
            }
            else if (c >= 'a' && c <= 'z') {
                sb.append(getCharRotation(c, 'a', 'z', k));
            }
            else sb.append(c);
        }

        return sb.toString();
    }

    private static char getCharRotation(Character c, char start, char limit, int k) {
        int newChar = c + k;
        while (newChar > limit) {
            newChar = newChar % limit + start - 1;
        }
        return (char ) newChar;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
