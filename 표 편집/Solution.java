import java.util.Stack;
import java.util.LinkedList;

class Solution {
    LinkedList<Node> table = new LinkedList<>();
    Stack<Node> deleted_recent = new Stack<>();

    public String solution(int n, int k, String[] cmd) {
        //Initialize
        for (int i = 0; i < n; i++) {
            table.add(new Node(i));
        }

        for (String c : cmd) {
            k = action(k, c);
        }

        String answer = "";

        for (int i = 0; i < table.size(); i++) {
            if (!table.get(i).getIsDeleted()) {
                answer = answer + "O";
            } else {
                answer = answer + "X";
            }
        }

        return answer;
    }

    public int action(int k, String cmd) {
        switch (cmd.charAt(0)) {
            case 'U':
                k -= Integer.parseInt(cmd.substring(2));
                break;
            case 'D':
                k += Integer.parseInt(cmd.substring(2));
                break;
            // case 'C':
            //     int num = table.get(k);
            //     deleted_recent.push(num);
            //     table.remove(k);
            //     int size = table.size();
            //     k = (k >= size) ? size-1 : k;
            //     break;
            // case 'Z':
            //     int curr = table.get(k);
            //     int recover = deleted_recent.pop();
            //     int index = search(table.getFirst(), table.getLast(), curr);
            //     table.add(index, recover);
            //     k = (curr >= recover) ? k+1 : k;
            //     break;
        }

        return k;
    }

    static class Node {
        private int value;
        private boolean isDeleted;

        public Node (int v) {
            this.value = v;
            isDeleted = false;
        }

        public int getValue() {
            return this.value;
        }

        public boolean getIsDeleted() {
            return this.isDeleted;
        }
    }
}