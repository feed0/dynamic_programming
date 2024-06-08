/**
 * FibonacciMemoization
 * 
 * This class finds the longest common subsequence of two strings using a dynamic programming table.
 * 
 * Felipe Campelo
 * https://www.felipecampelo.com.br
*/

public class LongestCommonSubsequence {

    // Function to find the LCS of two strings
    public static String findLongestCommonSubsequence(String firstString, String secondString) {
        int firstLength = firstString.length();
        int secondLength = secondString.length();
        
        // Create a 2D array to store the lengths of LCS
        int[][] lcsLengths = new int[firstLength + 1][secondLength + 1];

        // Fill the lcsLengths array
        for (int row = 1; row <= firstLength; row++) {
            
            for (int column = 1; column <= secondLength; column++) {
            
                if (firstString.charAt(row - 1) == secondString.charAt(column - 1))
                    lcsLengths[row][column] = lcsLengths[row - 1][column - 1] + 1;
                else
                    lcsLengths[row][column] = Math.max(lcsLengths[row - 1][column], lcsLengths[row][column - 1]);
        
            }
            
        }
        
        // Reconstruct the LCS from the lcsLengths array
        StringBuilder lcs = new StringBuilder();
        int row = firstLength, column = secondLength;
        while (row > 0 && column > 0) {

            if (firstString.charAt(row - 1) == secondString.charAt(column - 1)) {
                lcs.append(firstString.charAt(row - 1));
                row--;
                column--;
            }
            else if (lcsLengths[row - 1][column] > lcsLengths[row][column - 1])
                row--;
            else
                column--;
            
        }
        
        // The LCS is constructed backwards, so reverse it
        lcs.reverse();
        
        return lcs.toString();
    }

    public static void main(String[] args) {
        String firstString = "ABCBDAB";
        String secondString = "BDCAB";
        
        String lcs = findLongestCommonSubsequence(firstString, secondString); // BDAB
        System.out.println("The Longest Common Subsequence is: " + lcs + ". With length: " + lcs.length());
    }
}
