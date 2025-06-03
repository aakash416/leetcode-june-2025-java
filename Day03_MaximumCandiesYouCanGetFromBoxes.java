import java.util.*;
public class Day03_MaximumCandiesYouCanGetFromBoxes {
    private int dfs(int box, int[] status, int[] candies, List<List<Integer>> keys,
                    List<List<Integer>> containedBoxes, Set<Integer> visited, Set<Integer> foundBoxes) {

        if (visited.contains(box)) return 0;
        if (status[box] == 0) {
            foundBoxes.add(box);
            return 0;
        }

        visited.add(box);
        int totalCandies = candies[box];

        for (int innerBox : containedBoxes.get(box)) {
            totalCandies += dfs(innerBox, status, candies, keys, containedBoxes, visited, foundBoxes);
        }

        for (int key : keys.get(box)) {
            status[key] = 1; // Now we have the key
            if (foundBoxes.contains(key)) {
                totalCandies += dfs(key, status, candies, keys, containedBoxes, visited, foundBoxes);
            }
        }

        return totalCandies;
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int total = 0;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> foundBoxes = new HashSet<>();

        List<List<Integer>> keyList = new ArrayList<>();
        List<List<Integer>> containedList = new ArrayList<>();
        for (int i = 0; i < status.length; i++) {
            keyList.add(new ArrayList<>());
            containedList.add(new ArrayList<>());
        }

        for (int i = 0; i < keys.length; i++) {
            for (int key : keys[i]) {
                keyList.get(i).add(key);
            }
        }

        for (int i = 0; i < containedBoxes.length; i++) {
            for (int box : containedBoxes[i]) {
                containedList.get(i).add(box);
            }
        }

        for (int box : initialBoxes) {
            total += dfs(box, status, candies, keyList, containedList, visited, foundBoxes);
        }

        return total;
    }
}
