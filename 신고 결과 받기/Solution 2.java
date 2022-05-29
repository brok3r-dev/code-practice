import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        report = Arrays.stream(report).distinct().toArray(String[]::new);
        HashMap<String, ArrayList<String>> record = new HashMap<>();
        HashMap<String, Integer> ids = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            ids.put(id_list[i], i);
        }

        for (String r : report) {
            String[] r_split = r.split(" ");
            ArrayList<String> temp = record.getOrDefault(r_split[1], new ArrayList<String>());
            temp.add(r_split[0]);
            record.put(r_split[1], temp);
        }

        for (Map.Entry<String, ArrayList<String>> r : record.entrySet()) {
            if (r.getValue().size() >= k) {
                for (String p : r.getValue()) {
                    answer[ids.get(p)]++;
                }
            }
        }

        return answer;
    }
}