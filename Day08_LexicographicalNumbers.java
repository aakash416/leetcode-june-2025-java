import java.util.ArrayList;
import java.util.List;

class Day08_LexicographicalNumbers {
    private void dfs(int curr, int n, List<Integer>ans){
        if(curr > n)
            return;
        ans.add(curr);
        for(int i = 0; i <= 9; i++){
            dfs(curr * 10 + i, n, ans);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            dfs(i, n, ans);
        }
        return ans;
    }
}