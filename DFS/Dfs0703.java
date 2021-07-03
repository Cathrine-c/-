package InterviewImportant.Arithmiy.DFS;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class Dfs0703 {


    //给定一个二叉树，找出其最小深度。/最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    //说明：叶子节点是指没有子节点的节点。
    //递归法
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {

            return 1+minDepth(root.right);
        }

        if (root.right == null && root.left != null) {
            return 1+minDepth(root.left);

        }

        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }


    //深度优先搜索
    public static int minDepthWithDfs(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = minDepthWithDfs(root.left);
        int right = minDepthWithDfs(root.right);

        if (left==0)return right+1;
        if (right==0)return left+1;
        return Math.min(left,right)+1;

    }



    //给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
    //叶子节点 是指没有子节点的节点。
    static boolean ans = false;
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        dfs(root,targetSum);
        return ans;

    }


    private static void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                ans = true;
            }
        }

        dfs(node.left,sum-node.val);
        dfs(node.right,sum-node.val);

    }


    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        TreeNode B = new TreeNode(4);
        TreeNode C = new TreeNode(11);
        TreeNode D = new TreeNode(7);
        TreeNode E = new TreeNode(2);
        A.left = B;
        B.left = C;
        C.left = D;
        C.right = E;

       // System.out.println(minDepth(A));
        System.out.println(hasPathSum(A, 22));
    }

}
