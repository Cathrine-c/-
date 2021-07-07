package InterviewImportant.Arithmiy;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Day0706 {


    //判断一棵二叉树是否为平衡二叉树，左右子树高度差不超过1
    public boolean isBalanced(TreeNode root) {
        if (root==null)return true;

        if (Math.abs(highTree(root.left)-highTree(root.right))<=1){
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        return true;

    }

    private int highTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return 1+Math.max(highTree(node.left),highTree(node.right));

    }


    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，
    // 只能调整树中节点指针的指向。

    /**
     *
     排序链表： 节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点。
     双向链表： 在构建相邻节点的引用关系时，设前驱节点 pre 和当前节点 cur ，不仅应构建 pre.right = cur ，也应构建 cur.left = pre 。
     循环链表： 设链表头节点 head 和尾节点 tail ，则应构建 head.left = tail 和 tail.right = head 。
     */

    Node head,pre;

    public Node treeToDoublyList(Node root) {

        if (root==null)return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;

    }

    public void dfs(Node root){

        if (root==null) return;

        dfs(root.left);
        if (pre != null) {
            pre.right = root;
        }else {
            head = root;
        }
        root.left=pre;
        pre=root;

        dfs(root.right);

    }

      //二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val == root.val) {
            return p;
        }

        if (q.val == root.val) {
            return q;

        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);

        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right,p,q);

        }else {
            return root;
        }


    }


    //输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
    public boolean verifyPostorder(int[] postorder) {

        if (postorder.length==0)return true;

        int n = postorder.length;

        return dfs(postorder,0,n-1);

    }

    private boolean dfs(int[] postorder,int l,int r){
        if (l>=r)return true;
        int k = l;
        int root = postorder[r];

        while (k<r&&postorder[k]<root)k++;

        for (int i=k;i<r;i++){
            if (postorder[i] > root) {
                return false;
            }
        }
        return dfs(postorder,l,k-1)&&dfs(postorder,k,r-1);

    }



    //二叉树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        postOrder(root,list);

        return list;

    }

    private void postOrder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);

    }


    //二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

       if (root==p||root==q){
           return root;
       }

       TreeNode left = lowestCommonAncestor1(root.left,p,q);
       TreeNode right = lowestCommonAncestor1(root.right,p,q);
        if (left != null && right != null) {
            return root;

        }
        if (left != null) {
            return left;

        }

        if (right != null) {
            return right;
        }


        return null;
        
    }


}
