class numIslands {
    private int rows, cols;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfsMark(grid, r, c);
                }
            }
        }
        return count;
    }

    private void dfsMark(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') return;
        grid[r][c] = '0';
        dfsMark(grid, r + 1, c);
        dfsMark(grid, r - 1, c);
        dfsMark(grid, r, c + 1);
        dfsMark(grid, r, c - 1);
    }
}