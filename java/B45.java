public class B45 {

    public int jump(int[] nums) {
        return help(nums, nums.length - 1);
    }

    public int help(int[] nums, int end) {
        if (end == 0)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < end; i++) {
            if (nums[i] + i >= end) {
                int tmp = help(nums, i);
                min = Math.min(min, tmp + 1);
            }
        }
        return min;
    }
}
