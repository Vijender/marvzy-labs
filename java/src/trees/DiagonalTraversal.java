public static List<Integer> printDiagonal(int[][] matrix) {

    int n = matrix.length - 1;
    int r = 0, c = 0;
    int ir = 0, ic = 0;
    List<Integer> result = new ArrayList<>();

    while (r <= n && c <= n) {
        while (ir >= 0 && ic <= n) {
            IO.println(ir + " " + ic);
            result.add(matrix[ir][ic]);
            ir--;
            ic++;
        }
        if (r == n) {
            c++;
            ic = c;
        } else {
            r++;
            ic = 0;
        }
        ir = r;
        IO.println(r + " ZZ " + c);
    }

    return result;
}

void main() {


    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    List<Integer> result = printDiagonal(matrix);
    IO.println(result);
}
