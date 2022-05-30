import java.util.Arrays;

class Solution {
    public int solution(int left, int right) {
        int[] divisors = new int[right + 1];

        for (int i = 1; i <= right; i++) {
            for (int j = Math.max(left, i); j <= right; j++) {
                if (j % i == 0) {
                    divisors[j]++;
                }
            }
        }

        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (divisors[i] % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }
}