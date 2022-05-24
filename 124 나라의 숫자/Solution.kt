class Solution {
    String[] nums = {"4", "1", "2"};

    public String solution(int n) {
        String answer = "";

        while (n > 0) {
            answer = nums[n % 3] + answer;
            if (n % 3 == 0) { n--; }
            n /= 3;
        }

        return answer;
    }
}