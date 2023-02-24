import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class B90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<=nums.length; i++){
            backTrack(res, nums, 0, i, new ArrayList<Integer>());
        }
        return res.stream().collect(Collectors.toList());
    }

    public void backTrack(Set<List<Integer>> res, int[] nums, int index, int size, List<Integer> track){
        if(track.size() == size){
            res.add(new ArrayList<Integer>(track));
            return ;
        }
        
        for(int i=index; i<nums.length; i++){
            track.add(nums[i]);
            index ++;
            backTrack(res, nums, index, size, track);
            track.remove(track.size() -1);
        }
    }
}
