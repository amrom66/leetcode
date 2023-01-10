import java.util.ArrayList;
import java.util.List;

public class A118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        list.add(list0);
        if(numRows == 1) return list;

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        list.add(list1);

        for(int i=2; i<=numRows; i++){
            List<Integer> pre = list.get(i-1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j=1; j<i-1; j++){
                curr.add(pre.get(j-1)+pre.get(j));
            }
            curr.add(1);
            list.add(curr);
        }

        return list;
    }

}