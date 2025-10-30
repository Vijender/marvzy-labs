public class TwoSum {

        static void main() {

            TwoSum obj = new TwoSum();
            obj.twoSum(new int[]{3,2,4}, 6);

        }

        public void twoSum(int[] nums, int target) {

            int n = nums.length;
            int[] results = new int[2];

            for (int i = 0; i < nums.length ; i++) {

                int temp = target - nums[i];
                results[0] = i;

                for(int k=n-1;k > 0; ) {
                    if (temp == nums[k]) {
                        // i,k
                        results[1] = k;
                        System.out.println("results " + results[0] + results[1]);
                        k = k - 1;
                    } else break;

                }
            }
        }

}
