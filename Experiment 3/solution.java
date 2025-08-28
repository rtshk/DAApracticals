import java.util.*;

class Solution {
    public List<List<Integer>> countFreq(int[] arr) {
        Map<Integer, Integer> freq = new TreeMap<>();
        
        // Count frequencies
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Build result list
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            result.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }

        return result;
    }
}
