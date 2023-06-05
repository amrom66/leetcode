public class A2460 {

    public int[] applyOperations(int[] nums) {

        int n = nums.length;

        int index = 0;
        while (index < n - 1) {
            if (nums[index] == nums[index + 1]) {
                nums[index] = 2 * nums[index];
                nums[index + 1] = 0;
            }
            index++;
        }

        // [1,4,0,2,0,0]
        int slow = 0;
        int fast = 0;
        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }
            fast++;
        }

        for (int i = slow; i < n; i++) {
            nums[i] = 0;
        }

        return nums;
    }
}
