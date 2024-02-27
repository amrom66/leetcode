public class Sort {
    public void quickSort(int[] nums) {
        int length = nums.length;
        quickSort(nums, 0, length - 1);
    }

    // 从大到小排序
    public void quickSort2(int[] nums) {
        int length = nums.length;
        quickSort2(nums, 0, length - 1);
    }

    // 从大到小排序
    public void quickSort2(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] < pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] > pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        quickSort2(nums, start, left - 1);
        quickSort2(nums, left + 1, end);
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] < pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    public static void main(String[] args) {
        int i;
        int a[] = { 30, 40, 60, 10, 20, 50 };

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        new Sort().quickSort2(a);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}