public class C4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                nums[index] = nums1[index1];
                index1++;
            } else {
                nums[index] = nums2[index2];
                index2++;
            }
            index++;
        }
        if (index1 < m) {
            System.arraycopy(nums1, index1, nums, index, m - index1);
        } else {
            System.arraycopy(nums2, index2, nums, index, n - index2);
        }

        double ret = 0.0;

        if ((m + n) % 2 == 1) {
            ret = nums[(m + n) / 2];
        } else {
            double d1 = nums[(m + n) / 2];
            double d2 = nums[(m + n) / 2 + 1];
            ret = (d1 + d2) / 2;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        new C4().findMedianSortedArrays(nums1, nums2);
    }
}
