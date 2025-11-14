
    private static int binarySearch(int[] source, int N, int x) {

        int mid = (N%2 == 1) ? (N+1)/2 : (N) / 2;
        int m = mid - 1;
        int N1 = mid;
        int M1 = mid;
        for (int i = 0; i < mid; i++) {
            N1 =  (N1%2 == 1) ? (N1+1)/2 : (N1) / 2;
            System.out.println(M1 + "" + N1 + " " + m);

            if (source[m] == x) {
                return m;
            } else if (source[m] > x) {
                M1 = M1 - N1;
                m = M1 -1;
            } else  if (source[m] < x) {
                M1 = M1 + N1;
                m = M1  -1;
        }

    }


        return -1;
    }

    public static int rBinarySearch(int[] source, int low, int high,  int x) {

        if (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println("m -" + mid);
            System.out.println("m e -" + source[mid]);

            if (source[mid] == x) {
                return mid;
            } else if (source[mid] > x) {
                return rBinarySearch(source, low, mid - 1, x);
            } else if (source[mid] < x) {
                return rBinarySearch(source, mid + 1, high, x);
            }
        }
        return -1;
     }

     void main() {
        int[] arr = {1,2,3,4,5,10};

        int x = 10;
        int result = binarySearch(arr, arr.length, x);

        System.out.println(result);

        if  (result == -1) { System.out.println("Element not found");
        } else System.out.println("Element found");

        int result2 = rBinarySearch(arr, 0, arr.length-1, x);
        System.out.println(result2);

    }

