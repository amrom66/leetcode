class A1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for(Integer num : nums){
            sum = sum + num;
        }
        long gap = Math.abs(goal - sum);
        if(gap == 0) return 0;
        return (int)((gap+limit-1)/limit);
    }
}
