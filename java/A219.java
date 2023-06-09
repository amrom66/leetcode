import java.util.HashSet;
import java.util.Set;

public class A219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (window.size() == k + 1)
                window.remove(nums[i - k - 1]);
            if (window.contains(nums[i]))
                return true;
            window.add(nums[i]);
        }

        return false;
    }

}