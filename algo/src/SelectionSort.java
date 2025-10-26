public class SelectionSort {

    public static int[] sort(int[] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = i+1; j < mat.length ; j++) {

                if (mat[i] > mat[j]) {
                    int temp = mat[j];
                    mat[j] = mat[i];
                    mat[i] = temp;
                }

            }
        }

        return mat;

    }

    public static void main(String... args) {

        System.out.println("Insertion Sort");
        int[] mat = {1, 3, 34, 4, 5};
         mat = (sort(mat));
        for(int i= 0; i < mat.length; i++) {
            System.out.println(mat[i]);
        }

    }

}
