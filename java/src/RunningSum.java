public static int[] runningSum(int[] nums) {
    int[] result = new int[nums.length];
    int temp = 0;
    for (int i = 0; i < nums.length; i++) {
        temp = temp + nums[i];
        result[i] = temp;
    }

    return result;
}

void main() {

    IO.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));

}
