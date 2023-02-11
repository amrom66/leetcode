import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class B47 {
    //给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(i, nums[i]);
        }
        backTrack(res, map, new LinkedList<>());
        return new ArrayList<>(res);
    }

    public void backTrack(Set<List<Integer>> res, Map<Integer, Integer> map, LinkedList<Integer> track){
        if(track.size() == map.size()) {
            LinkedList<Integer> updatedList = track.stream().map(num -> map.get(num))
            .collect(Collectors.toCollection(LinkedList::new));
            if(!res.contains(track)) res.add(new LinkedList<>(updatedList));
            return ;
        }
        for(Map.Entry<Integer, Integer> entry :map.entrySet()){
            if(track.contains(entry.getKey())) continue;
            track.add(entry.getKey());
            backTrack(res, map, track);
            track.removeLast();
        }
    }
}
