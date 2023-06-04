import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A2465 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Double> set = new HashSet<>();
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int min = nums[left];
            int max = nums[right];
            set.add((min + max) / 2.0);
            left++;
            right--;
        }
        return set.size();
    }
}
