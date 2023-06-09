import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        Map<String, Integer> mm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int index1 = map.get(list2[i]);
                if (mm.containsKey(list2[i])) {
                    mm.put(list2[i], Math.min(index1 + i, mm.get(list2[i])));
                } else {
                    mm.put(list2[i], index1 + i);
                }
                min = Math.min(min, mm.get(list2[i]));
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mm.entrySet()) {
            if (entry.getValue() == min) {
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[res.size()]);
    }

}
