import java.util.Stack;
import java.util.LinkedList;
import java.util.ListIterator;

class Solution {
    LinkedList<Node> table = new LinkedList<>();
    Stack<Node> deleted_recent = new Stack<>();

    public String solution(int n, int k, String[] cmd) {
        //Initialize
        for (int i = 0; i < n; i++) { table.add(new Node(i)); }
        ListIterator<Node> iterator = table.listIterator();
        for (int i = 0; i < k; i++) { iterator.next(); }

        //execute command
        for (String c : cmd) { action(iterator, c); }

        //Create answer string
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

    public void action(ListIterator<Node> iterator, String cmd) {
        int move = 0;
        Node n = null;

        switch (cmd.charAt(0)) {
            case 'U':
                move = Integer.parseInt(cmd.substring(2));

                while (move > 0) {
                    n = iterator.previous();
                    if (!n.getIsDeleted()) move--;
                }

                break;
            case 'D':
                move = Integer.parseInt(cmd.substring(2));

                while (move > 0) {
                    n = iterator.next();
                    if (!n.getIsDeleted()) move--;
                }

                break;
            case 'C':
                n = iterator.next();
                n.setIsDeleted(true);
                iterator.set(n);
                deleted_recent.push(n);

                if (iterator.hasNext()) {
                    Boolean flag = false;

                    while(true) {
                        if (!iterator.next().getIsDeleted()) {
                            iterator.previous();
                            break;
                        }

                        if (!iterator.hasNext()) {
                            flag = true;
                            break;
                        }
                    }

                    if (flag) {
                        while(iterator.hasPrevious()) {
                            if (!iterator.previous().getIsDeleted()) { break; }
                        }
                    }
                } else {
                    while(iterator.hasPrevious()) {
                        if (!iterator.previous().getIsDeleted()) { break; }
                    }
                }

                break;
            case 'Z':
                n = deleted_recent.pop();
                n.setIsDeleted(false);
                table.set(n.getValue(), n);
                break;
        }
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

        public void setIsDeleted(boolean b) {
            this.isDeleted = b;
        }

        public String toString() {
            return this.value + " " + this.isDeleted;
        }
    }
}