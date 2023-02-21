
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B89 {

    public static void main(String[] args) {
        int n = 2;
        List<Integer> out = new B89().grayCode(n);
        out.stream().forEach(ss -> System.out.print(ss));
    }

    private List<Integer> list = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        Set<Integer> set = new HashSet<>();
        int npow = 1;
        while(n>0){
            npow *= 2;
            n--;
        }

        List<Integer> res = new ArrayList<>();
        res.add(0);
        backTrack(res, set, npow);
        
        return list;
    }

    public void backTrack(List<Integer> res, Set<Integer> set, int npow){
        if(res.size() == npow){
            list = res;
            return ;
        }
        for(int i=1; i<npow; i++){
            int last = res.get(res.size()-1);
            if(set.contains(i)) continue;
            if(Math.abs(last-i)%2==0 || Math.abs(last-i)==1){
                set.add(i);
                res.add(i);
                backTrack(res, set, npow);
                res.remove(res.size()-1);
                set.remove(i);
            }
        }
    }
}
