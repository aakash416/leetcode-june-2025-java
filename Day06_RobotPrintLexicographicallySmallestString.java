import java.util.*;
class Day06_RobotPrintLexicographicallySmallestString {
    private char smallestChar(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                return (char) ('a' + i);
            }
        }
        return 'a'; // fallback (should not happen)
    }

    public String robotWithString(String s) {
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        for (char x : s.toCharArray()) {
            freq[x - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (char x : s.toCharArray()) {
            stack.push(x);
            freq[x - 'a']--;

            while (!stack.isEmpty() && stack.peek() <= smallestChar(freq)) {
                result.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
