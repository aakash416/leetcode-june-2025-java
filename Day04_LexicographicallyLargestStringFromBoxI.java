public class Day04_LexicographicallyLargestStringFromBoxI {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        int n = word.length();
        int maxLen = n - (numFriends - 1);
        String ans = "";

        for (int i = 0; i < n; i++) {
            int len = Math.min(maxLen, n - i);
            String sub = word.substring(i, i + len);
            if (sub.compareTo(ans) > 0) {
                ans = sub;
            }
        }

        return ans;
    }
}

    

