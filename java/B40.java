import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class B40 {

    public static void main(String[] args) {
        int[] candidates = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 30;
        List<List<Integer>> out =new B40().combinationSum2(candidates, target);
        out.stream().forEach(list ->{
            list.stream().forEach(num ->{
                System.out.print(out + " ");
            });
            System.out.println();
        });
    }

    //candidates = [10,1,2,7,6,1,5], target = 8,
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        backTrack(res, candidates, 0, target, new ArrayList<>());
        return res.stream().collect(Collectors.toList());
    }

    public void backTrack(Set<List<Integer>> res, int[] candidates,int index, int target, List<Integer> track){
        if(target == 0) {
            res.add(new ArrayList<>(track));
            return ;
        }
        if(target < 0) {
            return ;
        }
        for(int i=index; i<candidates.length; i++){
            int tmp = candidates[i];
            track.add(tmp);
            index ++;
            backTrack(res, candidates, index, target-tmp, track);
            track.remove(track.size()-1);
        }
    }
}
