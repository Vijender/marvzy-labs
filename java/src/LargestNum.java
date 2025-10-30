import java.util.Arrays;


    public static int largest(int[] arr) {
        // code here
        int largest = -1;
        for (int j : arr) {
            if (j > largest) {
                largest = j;
            }

        }
        return largest;
    }

    public static int slargest(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-1];
    }


     void main() {

        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println(largest(arr));
        System.out.println(slargest(arr));
    }
