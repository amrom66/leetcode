public class Sort {

    // 30, 40, 60, 10, 20, 50
    public void mergeSort(int[] nums) {
        int length = nums.length;
        mergeSort(nums, 0, length - 1);
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int index1 = left;
        int index2 = mid + 1;
        int index = 0;
        while (index1 <= mid && index2 <= right) {
            if (nums[index1] <= nums[index2]) {
                tmp[index] = nums[index1];
                index1++;
            } else {
                tmp[index] = nums[index2];
                index2++;
            }
            index++;
        }
        while (index1 <= mid) {
            tmp[index++] = nums[index1++];
        }
        while (index2 <= right) {
            tmp[index++] = nums[index2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[left + i] = tmp[i];
        }
    }

    public void insertSort2(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int base = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] < base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }

    public void insertSort(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int base = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
    }

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

    public void bubbleSort(int[] nums) {
        int length = nums.length;
        if (length <= 1)
            return;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public void bubbleSort2(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int i;
        int nums[] = { 30, 40, 60, 10, 20, 50 };

        System.out.printf("before sort:");
        for (i = 0; i < nums.length; i++)
            System.out.printf("%d ", nums[i]);
        System.out.printf("\n");

        new Sort().mergeSort(nums);

        System.out.printf("after  sort:");
        for (i = 0; i < nums.length; i++)
            System.out.printf("%d ", nums[i]);
        System.out.printf("\n");
    }
}