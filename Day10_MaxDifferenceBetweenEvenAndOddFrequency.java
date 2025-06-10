class Day10_MaxDifferenceBetweenEvenAndOddFrequency {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (int x : s.toCharArray()) {
            freq[x - 'a']++;
        }
        int maxOdd = 1;
        int minEven = s.length();
        for (int x : freq) {
            if (x == 0)
                continue;
            else if (x % 2 == 1)
                maxOdd = Math.max(maxOdd, x);
            else
                minEven = Math.min(minEven, x);
        }
        return maxOdd - minEven;
    }
}
