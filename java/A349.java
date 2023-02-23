import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class A349 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = {2,2};
        new A349().intersection(nums1, nums2);
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1<len2) return intersection(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        Set<Integer> set = new HashSet<>();
        while(index1<len1 && index2<len2){
            if(nums1[index1] == nums2[index2]){
                set.add(nums1[index1]);
                index1 ++;
                index2 ++;
            }else if(nums1[index1] > nums2[index2]){
                index2 ++;
            }else{
                index1 ++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            res[index++] = iterator.next();
        }
        return res;
    }
}
