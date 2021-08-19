package InterviewImportant.jianzhi;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Node1 {
    public int val;
    public List<Node1> neighbors;
    public Node1() {
        val = 0;
        neighbors = new ArrayList<Node1>();
    }
    public Node1(int _val) {
        val = _val;
        neighbors = new ArrayList<Node1>();
    }
    public Node1(int _val, ArrayList<Node1> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}




public class Day0819 {

    public static void main(String[] args) {

    }

    //给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
    //每条从根节点到叶节点的路径都代表一个数字：
    //
    //例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
    //计算从根节点到叶节点生成的 所有数字之和 。
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;

        return getNumbers(root,0);
    }


    private int getNumbers(TreeNode root,int upTen){

        if(root==null)return 0;

        if(root.left==null&&root.right==null){
            return upTen*10+root.val;
        }
        int n1 = getNumbers(root.left,upTen*10+root.val);

        int n2 = getNumbers(root.right,upTen*10+root.val);
        return n1+n2;

    }


    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，
     * 并将这些区域里所有的 'O' 用 'X' 填充。
     */
    //方法1
    int row,col;
    public void solve1(char[][] board) {
        if(board==null||board.length==0){
            return;
        }

        row = board.length;
        col = board[0].length;

        for(int i=0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);

        }

        for(int j=0;j<col;j++){

            dfs(board,0,j);
            dfs(board,row-1,j);
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='-')board[i][j] = 'O';

            }
        }
        return;

    }


    public void dfs(char[][] board,int i,int j){

        if(i<0||j<0||i>=row||j>=col||board[i][j]!='O')return;

        board[i][j] = '-';

        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
        return;
    }




    //方法2
    public void solve2(char[][] board) {
        int rows = board.length,cols = board[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if((i==0||j==0||i==rows-1||j==cols-1)&&board[i][j]=='O'){

                    dfs(board,i,j,rows,cols);
                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(board[i][j]=='O')board[i][j]='X';

                if(board[i][j]=='#')board[i][j]='O';

            }
        }


    }


    public void dfs(char[][] board,int i,int j,int rows,int cols){

        if(i<0||j<0||i>=rows||j>=cols||board[i][j]=='X'||board[i][j]=='#')return;

        board[i][j] = '#';

        dfs(board,i-1,j,rows,cols);
        dfs(board,i+1,j,rows,cols);
        dfs(board,i,j-1,rows,cols);
        dfs(board,i,j+1,rows,cols);

    }


    //给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
    //图中的每个节点都包含它的值 val（int） 和其邻居的列表
    Map<Integer, Node1> isVisited = new HashMap<>();
    public Node1 cloneGraph(Node1 node) {

        if(node==null)return null;

        Node1 newNode = new Node1(node.val);

        isVisited.put(newNode.val,newNode);

        for(Node1 neighbor: node.neighbors){

            Node1 newNeighbor = isVisited.get(neighbor.val);
            if(newNeighbor==null){
                newNeighbor = cloneGraph(neighbor);
            }
            newNode.neighbors.add(newNeighbor);

        }
        return newNode;

    }


}
