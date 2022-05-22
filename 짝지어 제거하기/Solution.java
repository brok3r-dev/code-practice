import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.size() == 0) {
                stack.push(c);
                continue;
            }

            if (c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.size() == 0) { answer = 1; }
        return answer;
    }
}