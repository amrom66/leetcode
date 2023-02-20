import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class B39 {
    //candidates = [2,3,6,7], target = 7
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        backTrack(res, candidates, target, new ArrayList<>());

        return res.stream().toList();
    }

    public void backTrack(Set<List<Integer>> res, int[] candidates, int target, List<Integer> track){
        if(target < 0) return ;
        if(target == 0){
            res.add(track.stream().sorted().toList());
            return ;
        }

        for(int i=0; i<candidates.length; i++){
            track.add(candidates[i]);
            backTrack(res, candidates, target-candidates[i], track);
            track.remove(track.size()-1);
        }
    }
    
}