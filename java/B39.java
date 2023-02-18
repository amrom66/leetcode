import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(res, candidates, 0, target, new ArrayList<>());
        return res;
    }

    public void backTrack(List<List<Integer>> res, int[] candidates, int index, int target, List<Integer> track){
        if(target == 0){
            res.add(new ArrayList<>(track));
            return ;
        }
        if(target <0 ){
            return ;
        }
        for(int i=index; i<candidates.length; i++){
            track.add(candidates[i]);
            backTrack(res, candidates, index, target-candidates[i], track);
            index ++;
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new B39().combinationSum(candidates, target);
        res.stream().forEach(re ->{
            re.stream().forEach(r ->{
                System.out.print(r + "\t");   
            });
            System.out.println();
        });
    }
    
}
