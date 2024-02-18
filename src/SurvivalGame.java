public class SurvivalGame {
    private int[][] grid;
    private int n, m;

    public SurvivalGame(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
    }

    public int play() {
        boolean changed = true;
        int iterations = 0;
        while (changed) {
            changed = false;
            int[][] newGrid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newGrid[i][j] = grid[i][j];
                    if (grid[i][j] == 1 && isAdjacentToZombie(i, j)) {
                        newGrid[i][j] = 2;
                        changed = true;
                    }
                }
            }
            grid = newGrid;
            if (changed) {
                iterations++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return iterations;
    }

    private boolean isAdjacentToZombie(int i, int j) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 2) {
                return true;
            }
        }
        return false;
    }
}
