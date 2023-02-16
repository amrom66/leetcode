import java.util.ArrayList;
import java.util.List;

public class B78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            res.addAll(help(nums, i));
        }
        return res;
    }
    
    public List<List<Integer>> help(int[] nums, int k){
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, nums, 0, k, new ArrayList<>());
        return res;
    }

    public void backTrack(List<List<Integer>> res, int[] nums, int index, int k, List<Integer> track){
        if(track.size() == k){
            res.add(new ArrayList<>(track));
            return ;
        }
        for(int i=index; i<nums.length; i++){
            if(track.contains(nums[i])) continue;
            track.add(nums[i]);
            backTrack(res, nums, index+1, k, track);
            index = index +1;
            track.remove(track.size()-1);
        }
    }
}
