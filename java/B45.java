public class B45 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        int out = new B45().jump(nums);
        System.out.println(out);
    }

    public int jump(int[] nums) {
        return help(nums, nums.length-1);
    }

    public int help(int[] nums, int end){
        if(end == 0) return 0;
        
        int min = Integer.MAX_VALUE;

        for(int i=0; i<end; i++){
            if(nums[i] + i >= end){
                int tmp = help(nums, i);
                min = Math.min(min, tmp+1);
            }
        }
        return min;
    }
}
