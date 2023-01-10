import java.util.Arrays;
import java.util.*;

public class A18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        if (length < 4)
            return null;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < length - 3; i++) {
            Integer target1 = target - nums[i];
            Set<List<Integer>> tmpSet = threeSum(nums, target1, i + 1, nums[i]);
            if (null != tmpSet && !tmpSet.isEmpty()) {
                set.addAll(tmpSet);
            }
        }
        list.addAll(set);
        return list;
    }

    public Set<List<Integer>> threeSum(int[] nums, int target, int begin, int origin) {
        int length = nums.length;
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = begin; i < length - 2; i++) {
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == target) {
                    List<Integer> tmpList = new ArrayList<Integer>();
                    tmpList.add(origin);
                    tmpList.add(nums[i]);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    set.add(tmpList);
                    right--;
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return set;
    }

}