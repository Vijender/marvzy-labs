public static int findSmallestArray(int[] arr, int tSum) {

    int count = 0;
    IO.println("tsum = " + tSum);
    for (int i = 0; i < arr.length - 1; i++) {
        int wSum = arr[i];
        int wCount = 0;
        for (int j = i + 1; j < arr.length; j++) {
            wSum += arr[j];
            if (wSum == tSum) {
                wCount = (j - i + 1);
                if (count == 0) {
                    count = wCount;
                } else {
                    count = Math.min(wCount, count);
                }
                break;
            }
        }
        IO.println("wCount = " + wCount + " count = " + count);
    }
    if (arr.length == 1) {
        if (arr[0] == tSum) {
            count = 1;
        }
    }
    return count;
}


void main() {

    int[] arr = new int[]{2, 1, 3, 5, 2, 3};
    IO.println(findSmallestArray(arr, 7));
    IO.println(findSmallestArray(new int[]{2, 1, 5, 2, 8}, 7));
    IO.println(findSmallestArray(new int[]{3, 4, 1, 1, 6}, 8));

    IO.println("completed");

}
