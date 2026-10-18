class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int p1 = 0 , p2  = 0;
        visited[p1][p2] = true;

        while(true){
           char ch = grid[p1][p2];
           int nr = p1, nc = p2;

            if (ch == 'L')
                nc--;
            else if (ch == 'R')
                nc++;
            else if (ch == 'U')
                nr--;
            else if (ch == 'D')
                nr++;

            if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                break;

            if (visited[nr][nc])
                break;

            p1 = nr;
            p2 = nc;
            visited[p1][p2] = true;
        }

        return new int[] { p1, p2 };
    }
}