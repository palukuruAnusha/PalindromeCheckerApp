public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   Welcome to PalindromeChecker App      ");
        System.out.println("   Version: 1.0                          ");
        System.out.println("=========================================");
        System.out.println("\nApplication is ready to process Data...");
        
        // UC2: Print a Hardcoded Palindrome Result
        String word = "madam";
        boolean isPalindrome = true;
        
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome) {
            System.out.println("The word '" + word + "' is a palindrome.");
        } else {
            System.out.println("The word '" + word + "' is NOT a palindrome.");
        }
    }
}
