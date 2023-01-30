import java.util.HashSet;
import java.util.Set;

public class B16 {
    public int threeSumClosest(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int m=j+1; m<nums.length; m++){
                    set.add(nums[i] + nums[j] + nums[m]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int tmp  = 0;
        for(Integer num : set){
            if(Math.abs(target-num) < min) {
                min = Math.abs(target-num);
                tmp = num;
            }
        }
        return tmp;
    }
}
