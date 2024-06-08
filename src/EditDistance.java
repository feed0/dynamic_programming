public class EditDistance {

    public static int editDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
    
        // Create a table to store results of subproblems
        int[][] dp = new int[word1Length + 1][word2Length + 1];
    
        // Fill dp[][] in bottom-up manner
        for (int row = 0; row <= word1Length; row++) {
    
            for (int col = 0; col <= word2Length; col++) {
    
                // If first string is empty, only option is to
                // insert all characters of second string
                if (row == 0)
                    dp[row][col] = col;
    
                // If second string is empty, only option is to
                // remove all characters of second string
                else if (col == 0)
                    dp[row][col] = row;
    
                // If last characters are same, ignore last char
                // and recur for remaining string
                else if (word1.charAt(row - 1) == word2.charAt(col - 1))
                    dp[row][col] = dp[row - 1][col - 1];
                
                // If last characters are different, consider all
                // possibilities and find minimum
                else
                    dp[row][col] = 1 + Math.min(
                        Math.min(
                            dp[row][col - 1],       // Insert
                            dp[row - 1][col]        // Remove
                        ),
                        dp[row - 1][col - 1]    // Replace
                    ); 
    
            }
    
        }
    
        return dp[word1Length][word2Length];
    }
    
    public static void main(String[] args) {
        String word1 = "sunday";
        String word2 = "saturday";
        
        int distance = editDistance(word1, word2);
    
        System.out.println("Edit distance between " + word1 + " and " + word2 + " is: " + distance);
    }
}
