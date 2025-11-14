import java.util.HashSet;

public static void dfs(int r, int c, int[][] matrix, HashSet<XCoordinate> visited) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] == 0 || visited.contains(new XCoordinate(r, c))) {
        return;
    }
    visited.add(new XCoordinate(r, c));
    dfs(r + 1, c, matrix, visited);
    dfs(r - 1, c, matrix, visited);
    dfs(r, c - 1, matrix, visited);
    dfs(r, c + 1, matrix, visited);
}

public static Integer findIsland(int[][] matrix) {
    HashSet<XCoordinate> visited = new HashSet<>();
    int r = matrix.length;
    int c = matrix[0].length;
    int count = 0;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (matrix[i][j] == 1 && !visited.contains(new XCoordinate(i, j))) {
                dfs(i, j, matrix, visited);
                count++;
            }
        }
    }
    return count;
}

void main() {
    int[][] matrix = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
    System.out.println(findIsland(matrix));
}