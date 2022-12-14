import java.util.HashSet;
import java.util.Set;

public class A217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (Integer num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}