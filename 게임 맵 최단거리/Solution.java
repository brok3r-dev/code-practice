import java.util.*;

class Solution {
    private Queue<Pair> next = new LinkedList<>();

    public int solution(int[][] maps) {
        int answer = -1;

        maps[0][0] = 0;
        next.add(new Pair(0, 0, 1));
        answer = findShortCuts(maps, maps.length - 1, maps[0].length - 1);

        return answer;
    }

    public int findShortCuts(int[][] maps, int x, int y) {
        while(!next.isEmpty()) {
            Pair p = next.poll();
            if (p.compare(x, y)) { return p.getLevel(); }

            if (checkUp(maps, p)) {
                maps[p.getX()][p.getY()-1] = 0;
                next.add(new Pair(p.getX(), p.getY()-1, p.getLevel()+1));
            }
            if (checkDown(maps, p, y)) {
                maps[p.getX()][p.getY()+1] = 0;
                next.add(new Pair(p.getX(), p.getY()+1, p.getLevel()+1));
            }
            if (checkLeft(maps, p)) {
                maps[p.getX()-1][p.getY()] = 0;
                next.add(new Pair(p.getX()-1, p.getY(), p.getLevel()+1));
            }
            if (checkRight(maps, p, x)) {
                maps[p.getX()+1][p.getY()] = 0;
                next.add(new Pair(p.getX()+1, p.getY(), p.getLevel()+1));
            }
        }

        return -1;
    }

    public boolean checkUp(int[][] maps, Pair position) {
        if (position.getY() - 1 < 0) { return false; }
        if (maps[position.getX()][position.getY() - 1] == 1) { return true; }
        return false;
    }

    public boolean checkDown(int[][] maps, Pair position, int height) {
        if (position.getY() + 1 > height) { return false; }
        if (maps[position.getX()][position.getY() + 1] == 1) { return true; }
        return false;
    }

    public boolean checkLeft(int[][] maps, Pair position) {
        if (position.getX() - 1 < 0) { return false; }
        if (maps[position.getX() - 1][position.getY()] == 1) { return true; }
        return false;
    }

    public boolean checkRight(int[][] maps, Pair position, int width) {
        if (position.getX() + 1 > width) { return false; }
        if (maps[position.getX() + 1][position.getY()] == 1) { return true; }
        return false;
    }

    class Pair {
        private int x;
        private int y;
        private int level;

        public Pair (int a, int b, int l) {
            this.x = a;
            this.y = b;
            this.level = l;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getLevel() {
            return this.level;
        }

        public boolean compare(int a, int b) {
            if (this.x == a && this.y == b) {
                return true;
            }
            return false;
        }
    }
}