package com.coding.graphs;

public class MaximumAreaOfIsland {
    public static int maximumAreaOfIsland(char[][] grid) {
        if(grid.length == 0 || grid == null)
            return 0;

        int area = 0;
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        for (int r = 0; r < numberOfRows; r++) {
            for (int c = 0; c < numberOfColumns; c++) {
                area = Math.max(area, dfs(grid, r, c));
            }
        }
        return area;
    }

    private static int dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return 0;
        }

        // Mark current node as visited
        grid[r][c] = '0';

        return 1 + dfs(grid, r - 1, c) +
                    dfs(grid, r + 1, c) +
                    dfs(grid, r, c - 1) +
                    dfs(grid, r, c + 1);
    }
}
