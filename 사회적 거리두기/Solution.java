class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int numOfRoom = 5;

        for (int i = 0; i < numOfRoom; i++) {
            answer[i] = roomCheck(places[i]);
        }

        return answer;
    }

    public int roomCheck(String[] place) {
        int size = 5;

        for (int row = 0; row < size; row++) {
            String s = place[row];

            for (int col = 0; col < size; col++) {
                if (s.charAt(col) == 'P') {
                    if (!check(place, row, col)) {
                        return 0;
                    }
                }
            }
        }

        return 1;
    }

    public boolean check(String[] place, int row, int col) {
        char topLeft = 'X';
        char topRight = 'X';
        char downLeft = 'X';
        char downRight = 'X';

        try {
            topLeft = place[row-1].charAt(col-1);
        } catch (Exception ignored) {}

        try {
            topRight = place[row-1].charAt(col+1);
        } catch (Exception ignored) {}

        try {
            downLeft = place[row+1].charAt(col-1);
        } catch (Exception ignored) {}

        try {
            downRight = place[row+1].charAt(col+1);
        } catch (Exception ignored) {}

        try {
            switch (place[row].charAt(col - 1)) {
                case 'P':
                    return false;
                case 'O':
                    if (topLeft == 'P') return false;
                    if (downLeft == 'P') return false;
                    if (place[row].charAt(col - 2) == 'P') return false;
            }
        } catch (Exception ignored) {}

        try {
            switch (place[row].charAt(col + 1)) {
                case 'P':
                    return false;
                case 'O':
                    if (topRight == 'P') return false;
                    if (downRight == 'P') return false;
                    if (place[row].charAt(col + 2) == 'P') return false;
            }
        } catch (Exception ignored) {}

        try {
            switch (place[row - 1].charAt(col)) {
                case 'P':
                    return false;
                case 'O':
                    if (topLeft == 'P') return false;
                    if (topRight == 'P') return false;
                    if (place[row - 2].charAt(col) == 'P') return false;
            }
        } catch (Exception ignored) {}

        try {
            switch (place[row + 1].charAt(col)) {
                case 'P':
                    return false;
                case 'O':
                    if (downLeft == 'P') return false;
                    if (downRight == 'P') return false;
                    if (place[row + 2].charAt(col) == 'P') return false;
            }
        } catch (Exception ignored) {}

        return true;
    }
}