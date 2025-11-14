public static boolean checkMatrix(int[][] matrix) {

    for (int row = 0; row < matrix.length - 1; row++) {
        for (int col = 0; col < matrix[row].length - 1; col++) {
            IO.println(row + " " + col);
            if (matrix[row][col] != matrix[row + 1][col + 1]) {
                return false;
            }

        }

    }
    return true;
}


void main() {
    IO.println(checkMatrix(new int[][]{{1, 2, 3},
            {2, 1, 3},
            {3, 2, 1}}));
    IO.println(checkMatrix(new int[][]{{1, 2}, {2, 1}}));
}
