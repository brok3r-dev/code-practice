class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeros = 0;
        int matched = 0;

        for (int l : lottos) {
            if (l == 0) {
                zeros++;
            }
        }

        for (int w : win_nums) {
            for (int l : lottos) {
                if (l == w) {
                    matched++;
                    break;
                }
            }
        }

        answer[0] = Math.min(7 - matched - zeros, 6);
        answer[1] = Math.min(7 - matched, 6);

        return answer;
    }
}