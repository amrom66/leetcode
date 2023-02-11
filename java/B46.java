import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
public class B46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, nums, new LinkedList<>());
        return res;
    }

    public void backTrack(List<List<Integer>> res, int[] nums, LinkedList<Integer> track){
        if(track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(track.contains(nums[i])) continue;
            track.add(nums[i]);
            backTrack(res, nums, track);
            track.removeLast();
        }
    }
    
}
