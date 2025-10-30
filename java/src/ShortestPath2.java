
import java.util.LinkedList;
import java.util.Queue;

// Helper class for matrix cell coordinates and distance
class Cell {
    int row, col, dist;
    Cell(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class ShortestPath2 {

    // Directions: up, down, left, right
    private static final int[] rowDir = {-1, 1, 0, 0};
    private static final int[] colDir = {0, 0, -1, 1};

    public static int shortestPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // If start or end is blocked, no path exists
        if (grid[0][0] == 0 || grid[n - 1][m - 1] == 0)
            return -1;

        boolean[][] visited = new boolean[n][m];
        Queue<Cell> queue = new LinkedList<>();

        // Start from (0,0)
        queue.add(new Cell(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Cell current = queue.remove();

            // Reached destination
            if (current.row == n - 1 && current.col == m - 1)
                return current.dist;

            // Explore all possible 4 directions
            for (int i = 0; i < 4; i++) {
                int newRow = current.row + rowDir[i];
                int newCol = current.col + colDir[i];

                if (isValid(newRow, newCol, n, m, grid, visited)) {
                    visited[newRow][newCol] = true;
                    queue.add(new Cell(newRow, newCol, current.dist + 1));
                }
            }
        }

        return -1; // No valid path found
    }

    private static boolean isValid(int r, int c, int n, int m, int[][] grid, boolean[][] visited) {
        return r >= 0 && c >= 0 && r < n && c < m && !visited[r][c] && grid[r][c] == 1;
    }

    static void main() {
        int[][] matrix = {
                {1, 1, 0, 1},
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {0, 0, 1, 1}
        };

        int result = shortestPath(matrix);
        System.out.println(result == -1 ? "No path exists" : "Shortest path length: " + result);
    }
}
