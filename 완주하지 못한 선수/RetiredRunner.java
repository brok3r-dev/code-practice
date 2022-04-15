import java.util.*;

class RetiredRunner {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> runners = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();

        for (String p : participant) {
            int num = runners.getOrDefault(p, 0);
            runners.put(p, num + 1);
        }

        for (String c : completion) {
            int num = runners.getOrDefault(c, 0);
            runners.put(c, num - 1);
        }

        for (Map.Entry<String, Integer> runner : runners.entrySet()) {
            if (runner.getValue() > 0) {
                return runner.getKey();
            }
        }

        return "NONE";
    }
}