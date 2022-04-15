import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> count = new HashMap<>();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(id_list));

        report = new HashSet<String>(Arrays.asList(report)).toArray(String[]::new);

        for (String r : report) {
            String reported = r.split(" ")[1];
            count.put(reported, count.getOrDefault(reported, 0) + 1);
        }

        for (String r : report) {
            String[] reported = r.split(" ");
            if (count.getOrDefault(reported[1], 0) >= k) {
                int index = list.indexOf(reported[0]);
                answer[index]++;
            }
        }

        return answer;
    }
}