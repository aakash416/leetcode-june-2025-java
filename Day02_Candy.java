public class Day02_Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int i = 1;
        int candy = n;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int pick = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                i++;
                pick++;
                candy += pick;
            }

            int dip = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                i++;
                dip++;
                candy += dip;
            }

            candy -= Math.min(dip, pick); // subtract overlapping peak
        }

        return candy;
    }
}
