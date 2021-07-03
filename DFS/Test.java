package InterviewImportant.Arithmiy.DFS;

public class Test {

    //给定一个二维的 0-1 矩阵，其中 0 表示海洋，1 表示陆地。单独的或相邻的陆地可以形成岛
    //屿，每个格子只与其上下左右四个格子相邻。求最大的岛屿面积。
    int[] direction = {-1,0,1,0,-1};
    public int maxAreaOfIsland(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int maxArea = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){

                if (grid[i][j]=='1'){
                    maxArea = Math.max(maxArea,dfs(grid,i,j));

                }
            }
        }
        return maxArea;
    }

    private int dfs(char[][] grid, int r, int c) {

        if (grid[r][c]==0)return 0;
        grid[r][c] = 0;

        int x,y,area = 1;
        for (int i=0;i<4;i++){
            x = r+direction[i] ;
            y = c+direction[i+1];
            if (x>=0&&x<grid.length&&y>=0&&y<grid[0].length){
                area +=dfs(grid,x,y);
            }
        }

        return area;
    }


    public static void main(String[] args) {

    }

    //方法2
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length==0 || grid==null) return 0;
        int max_area = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                max_area = Math.max(max_area, dfs(grid, i, j));
            }
        }
        return max_area;
    }


    public int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length ||
                c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;

        }

        grid[r][c] = 0;
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) +
                dfs(grid, r, c + 1) + dfs(grid, r, c - 1);

    }


    //给定一个二维的 0-1 矩阵，如果第 (i, j) 位置是 1，则表示第 i 个人和第 j 个人是朋友。已知
    //朋友关系是可以传递的，即如果 a 是 b 的朋友，b 是 c 的朋友，那么 a 和 c 也是朋友，换言之这
    //三个人处于同一个朋友圈之内。求一共有多少个朋友圈。
    /*策略：
    图的表示方法是，每个位置代表一个节点，每个节点与上下左右四个节点相
    邻。而在这一道题里面，每一行（列）表示一个节点，它的每列（行）表示是否存在一个相邻节
    点。因此题目 695 拥有 m × n 个节点，每个节点有 4 条边；而本题拥有 n 个节点，每个节点最多
    有 n 条边，表示和所有人都是朋友，最少可以有 1 条边，表示自己与自己相连。当清楚了图的表
    示方法后，这道题与题目 695 本质上是同一道题：搜索朋友圈（岛屿）的个数（最大面积）。我
    们这里采用递归的第一种写法。
     */

    public int findCircleNum(int[][] friends) {

        if (friends.length == 0 || friends == null) {
            return 0;
        }
        int n = friends.length;
        boolean[] visited = new boolean[n];
        int maxNum =0;
        for (int i=0;i<n;i++){
            if (!visited[i]){
                dfs1(friends,i,visited);
                maxNum++;
            }

        }
        return maxNum;
    }


    private void dfs1(int[][] friends, int i, boolean[] visited) {
        visited[i] = true;
        for (int j=0;j<friends[0].length;j++){
            if (friends[i][j] == 1&&!visited[j]) {
                dfs1(friends,j,visited);

            }
        }

    }


}
