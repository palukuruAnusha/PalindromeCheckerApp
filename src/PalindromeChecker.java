public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Welcome to PalindromeChecker App      ");
        System.out.println("   Version: 1.0                          ");
        System.out.println("=========================================");
        System.out.println("\nApplication is ready to process Data...");
        
// UC2: Print a Hardcoded Palindrome Result
        String word = "madam";
        checkUC2Hardcoded(word);
        
        // UC3: Palindrome Check Using String Reverse
        checkUC3StringReverse("racecar");
    }
    
    // UC2 Logic
    private static void checkUC2Hardcoded(String word) {
        boolean isPalindrome = true;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("[UC2] The word '" + word + "' is a palindrome.");
        } else {
            System.out.println("[UC2] The word '" + word + "' is NOT a palindrome.");
        }
    }
    
    // UC3 Logic
    private static void checkUC3StringReverse(String word) {
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i); // String Concatenation (+)
        }
        
        if (word.equals(reversed)) {
            System.out.println("[UC3] The word '" + word + "' is a palindrome (reversed: " + reversed + ").");
        } else {
            System.out.println("[UC3] The word '" + word + "' is NOT a palindrome (reversed: " + reversed + ").");
        }
    }
}
