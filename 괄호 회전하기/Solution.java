import java.util.Stack;

class Solution {
    private Stack<Character> stack = new Stack<>();

    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            String copy = s;

            while(copy.length() > 0) {
                check(copy.charAt(0));
                copy = copy.substring(1);
            }

            if (stack.isEmpty()) {
                answer++;
            }

            stack.clear();
            s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }

    public void check(char c) {
        if (stack.isEmpty()) {
            stack.push(c);
            return;
        }

        switch(c) {
            case '}': {
                if (stack.peek() == '{') { stack.pop(); }
                break;
            }
            case ']': {
                if (stack.peek() == '[') { stack.pop(); }
                break;
            }
            case ')': {
                if (stack.peek() == '(') { stack.pop(); }
                break;
            }
            default:
                stack.push(c);
        }
    }
}