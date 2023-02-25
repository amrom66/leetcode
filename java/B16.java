import java.util.Arrays;

public class B16 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int ous = new B16().threeSumClosest(nums, target);
        System.out.println(ous);
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length -1;
            int tmpTarget = target - nums[i];

            while(left < right){
                int tmpSum = nums[left] + nums[right];
                if(tmpSum > tmpTarget){
                    right --;
                }else if(tmpSum == tmpTarget){
                    return nums[i] + nums[left] + nums[right];
                }else{
                    left ++;
                }
                if(Math.abs(tmpTarget-tmpSum) < closest){
                    closest = Math.abs(tmpTarget - tmpSum);
                    sum = nums[i] + tmpSum;
                }
            }
        }

        return sum;
    }

}
