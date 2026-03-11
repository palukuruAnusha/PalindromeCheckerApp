import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

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
        // UC4: Character Array Based Palindrome Check
        checkUC4CharArray("deified");
        
        // UC5: Stack-Based Palindrome Checker
        checkUC5Stack("radar");
        
        // UC6: Queue + Stack Based Palindrome Check
        checkUC6QueueAndStack("level");
        
        // UC7: Deque-Based Optimized Palindrome Checker
        checkUC7Deque("racecar");
        
        // UC8: Linked List Based Palindrome Checker
        checkUC8LinkedList("kayak");
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
    
    // UC4 Logic
    private static void checkUC4CharArray(String word) {
        char[] chars = word.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;
        
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        
        if (isPalindrome) {
            System.out.println("[UC4] The word '" + word + "' is a palindrome.");
        } else {
            System.out.println("[UC4] The word '" + word + "' is NOT a palindrome.");
        }
    }
    
    // UC5 Logic
    private static void checkUC5Stack(String word) {
        Stack<Character> stack = new Stack<>();
        
        // Push all characters to the stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        
        boolean isPalindrome = true;
        // Pop and compare with original string
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome) {
            System.out.println("[UC5] The word '" + word + "' is a palindrome.");
        } else {
            System.out.println("[UC5] The word '" + word + "' is NOT a palindrome.");
        }
    }
    
    // UC6 Logic
    private static void checkUC6QueueAndStack(String word) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        
        // Push and Enqueue all characters
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            stack.push(c);
            queue.offer(c); // offer or add
        }
        
        boolean isPalindrome = true;
        // Compare dequeue vs pop
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome) {
            System.out.println("[UC6] The word '" + word + "' is a palindrome.");
        } else {
            System.out.println("[UC6] The word '" + word + "' is NOT a palindrome.");
        }
    }
    
    // UC7 Logic
    private static void checkUC7Deque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        
        // Insert characters into deque
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        
        boolean isPalindrome = true;
        
        // Remove first & last and Compare until empty or size 1
        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();
            if (first != last) {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome) {
            System.out.println("[UC7] The word '" + word + "' is a palindrome.");
        } else {
            System.out.println("[UC7] The word '" + word + "' is NOT a palindrome.");
        }
    }
    
    // UC8 Logic
    private static class Node {
        char data;
        Node next;
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private static void checkUC8LinkedList(String word) {
        if (word == null || word.length() == 0) return;
        
        // Convert string to linked list
        Node head = new Node(word.charAt(0));
        Node current = head;
        for (int i = 1; i < word.length(); i++) {
            current.next = new Node(word.charAt(i));
            current = current.next;
        }
        
        // Find middle using Fast and Slow Pointer Technique
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // Compare halves
        Node firstHalf = head;
        Node secondHalf = prev;
        boolean isPalindrome = true;
        
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        if (isPalindrome) {
            System.out.println("[UC8] The word '" + word + "' is a palindrome.");
        } else {
            System.out.println("[UC8] The word '" + word + "' is NOT a palindrome.");
        }
    }
}
