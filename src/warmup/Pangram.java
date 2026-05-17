package warmup;

/*

Problem:
https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/

Pattern:
HashSet

Time Complexity:
O(N)

Space Complexity:
O(1)

 */
import java.util.HashSet;
import java.util.Set;

class Pangram {
    // Function to check if given sentence is pangram
    public boolean checkIfPangram(String sentence) {
        // Create a set to store unique characters
        Set<Character> seen = new HashSet<>();

        // Iterate over each character using a normal for loop
        for (int i = 0; i < sentence.length(); i++) {
            // Convert the current character to lowercase
            char currChar = Character.toLowerCase(sentence.charAt(i));

            if (Character.isLetter(currChar)) {
                // Add the character to the set
                seen.add(currChar);
            }
        }

        // Return true if set size is 26 (total number of alphabets)
        return seen.size() == 26;
    }

    public static void main(String[] args) {
        Pangram sol = new Pangram();

        // Test case 1: "TheQuickBrownFoxJumpsOverTheLazyDog"
        // Expected output: true
        System.out.println(sol.checkIfPangram("TheQuickBrownFoxJumpsOverTheLazyDog"));

        // Test case 2: "This is not a pangram"
        // Expected output: false
        System.out.println(sol.checkIfPangram("This is not a pangram"));

        // Test case 3: "abcdef ghijkl mnopqr stuvwxyz"
        // Expected output: true
        System.out.println(sol.checkIfPangram("abcdef ghijkl mnopqr stuvwxyz"));

        // Test case 4: ""
        // Expected output: false
        System.out.println(sol.checkIfPangram(""));

        // Test case 5: "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        // Expected output: true
        System.out.println(sol.checkIfPangram("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}

