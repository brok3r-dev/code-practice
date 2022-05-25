import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] roadMap = new int[size][size];
        
        roadMap[0][0] = triangle[0][0];
        
        for(int i = 1; i < size; i++) {
            for (int j = 1; j < i+1; j++) {
                roadMap[i][j-1] = Math.max(roadMap[i][j-1], roadMap[i-1][j-1] + triangle[i][j-1]);
                roadMap[i][j] = roadMap[i-1][j-1] + triangle[i][j];
            }
        }
        
        return Arrays.stream(roadMap[size-1]).max().getAsInt();
    }
}