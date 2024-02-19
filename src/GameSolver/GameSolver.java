package GameSolver;

import java.io.FileNotFoundException;

public class GameSolver {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "src/GameSolver/sample.txt";
        int[][][] matrices = ReadMatrixFromFile.readMatricesFromFile(filePath);

        for (int[][] matrix : matrices) {
            if (matrix != null) {
                System.out.println(solve(matrix));
            }
        }
    }

    private static int solve(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<int[]> queue = new Queue<int[]>();

        // Initialize the queue with the positions of all zombies.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 2) {
                    queue.enqueue(new int[]{i, j});
                }
            }
        }

        // Perform BFS from each zombie's position.
        int iterations = 0;
        while (!queue.isEmpty()) {
            iterations++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.dequeue();
                for (int j = 0; j < 4; j++) {
                    int newX = point[0] + dx[j];
                    int newY = point[1] + dy[j];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && matrix[newX][newY] == 1) {
                        matrix[newX][newY] = 2;
                        queue.enqueue(new int[]{newX, newY});
                    }
                }
            }
        }

        // Check if there are any humans left.
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == 1) {
                    return -1;
                }
            }
        }

        return iterations;
    }
}
