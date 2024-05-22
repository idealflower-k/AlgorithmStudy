import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String, Long> totalMap = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> playMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String gen = genres[i];
            if (totalMap.containsKey(gen)) {
                long value = totalMap.get(gen);
                totalMap.replace(gen, value + plays[i]);
                
                HashMap<Integer, Integer> playList = playMap.get(gen);
                playList.put(i, plays[i]);
            } else {
                totalMap.put(gen, (long) plays[i]);
                HashMap<Integer, Integer> newMap = new HashMap<>();
                newMap.put(i, plays[i]);
                playMap.put(gen, newMap);
            }
        }
        
        List<Long> values = new ArrayList<>(totalMap.values());
        values.sort(Comparator.reverseOrder());
        
        Set<String> keySet = totalMap.keySet();
        
        for (Long value : values) {
            for (String key : keySet) {
                if (totalMap.get(key) == value) {
                    HashMap<Integer, Integer> list = playMap.get(key);
                    Set<Integer> listKeys = list.keySet();
                    List<Integer> listValues = new ArrayList<>(list.values());
                    listValues.sort(Comparator.reverseOrder());
                    for (int i = 0; i < 2 && i < listValues.size(); i++) {
                        for (Integer listKey : listKeys) {
                            if (list.get(listKey) == listValues.get(i))
                                answer.add(listKey);
                        }
                    }
                }
            }
        }
        
        int[] result = new int[answer.size()];
        
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}