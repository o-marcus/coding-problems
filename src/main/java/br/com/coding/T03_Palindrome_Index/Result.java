package br.com.coding.T03_Palindrome_Index;

class Result {
    /*
    * Complete the 'palindromeIndex' function below.
    *
    * The function is expected to return an INTEGER.
   1
   2
   3
   4
   5
   6
   7
   3/3
    * The function accepts STRING s as parameter.
    */
    public static int palindromeIndex(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if (start >= end) return -1; // already a palindrome
        // We need to delete here
        if (isPalindrome(s, start + 1, end)) return start;
        if (isPalindrome(s, start, end - 1)) return end;
        return -1;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}