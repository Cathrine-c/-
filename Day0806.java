package InterviewImportant.jianzhi;


public class Day0806 {


    //给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    //假设一个二叉搜索树具有如下特征：
    //节点的左子树只包含小于当前节点的数。
    //节点的右子树只包含大于当前节点的数。
    //所有左子树和右子树自身必须也是二叉搜索树。
    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;

        boolean left = isValidBST(root.left);
        if(!left){

            return false;

        }

        if(max!=null&&root.val<=max.val){
            return false;

        }

        max = root;
        boolean right = isValidBST(root.right);
        return right;

    }



    //给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;

        if (p == null || q == null) return false;


        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }

    //给定一个二叉树，检查它是否是镜像对称的。
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;

        return isSymmetricHelper(root.left,root.right);

    }

    private boolean isSymmetricHelper(TreeNode p,TreeNode q){
        if(p==null&&q==null)return true;

        if(p==null||q==null)return false;

        if(p.val!=q.val)return false;

        return isSymmetricHelper(p.left,q.right)&&isSymmetricHelper(p.right,q.left);

    }


}
