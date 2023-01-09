public class Offer {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int length = matrix.length;
        if(length ==0) return false;
        boolean flag = false;
        for (int i=0; i<matrix.length; i++) {
            int len = matrix[i].length;
            if(len ==0) continue;
            if (target >= matrix[i][0] && target <= matrix[i][len - 1]) {
                flag = flag || help(matrix[i], target);
            }
        }
        return flag;
    }
    public boolean help(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(target == nums[mid]){
                return true;
            }else if(target < nums[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return false;
    }
}
