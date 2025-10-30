static boolean[][] visited;


public static boolean isSafe(int[][] mat, int row, int col) {
    return (row >= 0 && row < mat.length && col >= 0 && col < mat[0].length && mat[row][col] == 1 && !visited[row][col]);
}

public static int shortPath(int[][] mat, int i, int j, int x, int y, int min_dist, int dist) {

    if (i == x && j == y) {
        min_dist = Math.min(min_dist, dist);
        return min_dist;
    }
    visited[i][j] = true;
    IO.println("visited " + visited[i][j] + " " + i + " " + j + " " + dist);

    // Right
    if (isSafe(mat, i, j + 1)) {
        min_dist = shortPath(mat, i, j + 1, x, y, min_dist, dist + 1);
    }
    // Left
    if (isSafe(mat, i, j - 1)) {
        min_dist = shortPath(mat, i, j - 1, x, y, min_dist, dist + 1);
    }

    //UP
    if (isSafe(mat, i - 1, j)) {
        min_dist = shortPath(mat, i - 1, j, x, y, min_dist, dist + 1);
    }

    //Down
    if (isSafe(mat, i + 1, j)) {
        min_dist = shortPath(mat, i + 1, j, x, y, min_dist, dist + 1);
    }

    visited[i][j] = false;
    IO.println("visited X" + visited[i][j] + " " + i + " " + j + " " + dist);
    return min_dist;

}


public static int shortPathLength(int[][] mat, int[] s, int[] d) {

    if (mat.length == 0 || mat[s[0]][s[1]] == 0 || mat[d[0]][d[1]] == 0) {
        return -1;
    }

    visited = new boolean[mat.length][mat[0].length];
    for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[0].length; j++) {
            visited[i][j] = false;
        }
    }

    int dist = Integer.MAX_VALUE;
    dist = shortPath(mat, s[0], s[1], d[0], d[1], dist, 0);

    return dist;
}


void main() {


    int[][] mat = new int[][]{
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
    };

    int[] src = {0, 0};
    int[] dest = {3, 4};

    int dist = shortPathLength(mat, src, dest);
    IO.print(dist);
}
