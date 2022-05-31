import java.util.List;
import java.util.ArrayList;

class Solution {
    List<String> combinations = new ArrayList<>();
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        int size = dungeons.length;
        
        String numbers = "";
        for (int i = 0; i < size; i++) {
            numbers = numbers + i;
        }
        permute("", numbers, size);
        
        for (String c : combinations) {
            answer = Math.max(answer, search(c, k, dungeons));
        }
        
        return answer;
    }

    //Calculate entered dungeons for the order
    public int search(String comb, int k, int[][] dungeons) {
        int entered = 0;
        
        for (int i = 0; i < comb.length(); i++) {
            int n = Integer.parseInt(comb.substring(i,i+1));
            if (k >= dungeons[n][0]) {
                k -= dungeons[n][1];
                entered++;
            }
        }
        
        return entered;
    }

    //Find all possible combinations
    public void permute(String comb, String left, int len) {
        if (comb.length() == len) {
            combinations.add(comb);
            return;
        }
        
        for (int i = 0; i < left.length(); i++) {
            permute(comb + left.charAt(i), left.substring(0,i) + left.substring(i+1), len);
        }
    }
}