package InterviewImportant.Arithmiy.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Dfs0705 {



    /*
       给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
      百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
      最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val == root.val) {
            return p;

        }

        if (q.val == root.val) {
            return q;

        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right,p,q);

        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);

        }else {
            return root;
        }

    }


    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();

        if (root==null)return list;

        helper(root,"",list);
        return list;
    }

    private void helper(TreeNode root, String s, List<String> list) {
        if (root==null)return;

        s+=root.val;
        if (root.left == null && root.right == null) {

            list.add(s);

        }else {
            helper(root.left,s+"->",list);
            helper(root.right,s+"->",list);
        }
    }


    /**
     给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     假定 BST 有如下定义：
     结点左子树中所含结点的值小于等于当前结点的值
     结点右子树中所含结点的值大于等于当前结点的值
     左子树和右子树都是二叉搜索树
     */

    HashMap<Integer,Integer> map = null;
    int max =0;
    public int[] findMode(TreeNode root) {

        map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        dfs(root);

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){

            if (entry.getValue() == max) {
                res.add(entry.getKey());

            }
        }

        int[] ans = new int[res.size()];

        for (int i=0;i<ans.length;i++){

            ans[i] = res.get(i);
        }

        return ans;
    }


    private void dfs(TreeNode root) {
        if (root==null)return;

        map.put(root.val,map.getOrDefault(root.val,0)+1);
        max = Math.max(map.get(root.val),max);
        dfs(root.left);
        dfs(root.right);

    }


    //给定一棵二叉搜索树，请找出其中第k大的节点。
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {

        inorder(root);

        return list.indexOf(list.size()-k);

    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.right);
        list.add(root.val);
        inorder(root.left);

    }


}
