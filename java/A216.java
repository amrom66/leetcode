import java.util.ArrayList;
import java.util.List;

public class A216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, 1, k, n, new ArrayList<>());
        return res;
    }

    public void backTrack(List<List<Integer>> res,int index, int k, int n, List<Integer> track){
        if(n ==0) {
            if(track.size() == k){
                res.add(new ArrayList<>(track));
            }
            return ;
        }
        if(n <0) {
            return ;
        }
        for(int i=index; i<=9; i++){
            track.add(i);
            index ++;
            backTrack(res, index, k, n-i, track);
            track.remove(track.size()-1);
        }
    }
}
