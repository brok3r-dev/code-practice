import java.util.Stack;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    LinkedList<Integer> table = new LinkedList<>();
    Stack<Integer> deleted_recent = new Stack<>();

    public String solution(int n, int k, String[] cmd) {
        //Initialize
        for (int i = 0; i < n; i++) { table.add(i); }

        //execute command
        for (String c : cmd) { k = action(k, c); }

        //Create answer string
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) { answer[i] = "X"; }
        for (int i = 0; i < table.size(); i++) { answer[table.get(i)] = "O"; }
        return Arrays.stream(answer).collect(Collectors.joining());
    }

    public int action(int k, String cmd) {
        switch (cmd.charAt(0)) {
            case 'U': {
                k -= Integer.parseInt(cmd.substring(2));
                break;
            }
            case 'D': {
                k += Integer.parseInt(cmd.substring(2));
                break;
            }
            case 'C': {
                int n = table.get(k);
                table.remove(k);
                deleted_recent.push(n);
                if (k >= table.size()) { k--; }
                break;
            }
            case 'Z': {
                int n = deleted_recent.pop();
                if (n >= table.size()) {
                    table.add(n);
                } else {
                    if (n < k) { k++; }
                    table.add(n, n);
                }
                break;
            }
        }

        return k;
    }
}