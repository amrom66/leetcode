import java.util.Arrays;

public class A2357 {

    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int index = 0;

        while (index < nums.length) {
            if (nums[index] == 0) {
                index++;
                continue;
            }
            int x = Math.max(1, nums[index]);
            for (int j = index; j < nums.length; j++) {
                nums[j] = nums[j] - x;
            }
            count++;
            if (nums[index] == 0)
                index++;
        }
        return count;
    }
}
