import java.util.ArrayList;
import java.util.List;

public class B77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, n, k, 1, new ArrayList<Integer>());
        return res;
    }

    public void backTrack(List<List<Integer>> res, int n, int k, int index, List<Integer> track){
        if(track.size() == k) {
            res.add(new ArrayList<>(track));
            return ;
        }

        for(int i=index; i<=n; i++){
            if(track.contains(i)) continue;
            track.add(i);
            index = index +1;
            backTrack(res, n, k, index, track);
            track.remove(track.size()-1);
        }

    }

    public static void main(String[] args) {
        new B77().combine(3, 3);
    }
}
