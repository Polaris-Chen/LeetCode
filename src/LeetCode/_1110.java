package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _1110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        if (search(root.val, to_delete)) {
            if (root.left != null&&!search(root.left.val, to_delete)) {
                result.add(root.left);
            }
            if (root.right != null&&!search(root.right.val, to_delete)) {
                result.add(root.right);
            }
            aux_delNodes(root.left, root, to_delete, result);
            aux_delNodes(root.right, root, to_delete, result);
        } else {
            result.add(root);
            aux_delNodes(root, root, to_delete, result);
        }
        return result;
    }

    public void aux_delNodes(TreeNode root, TreeNode rootFather, int[] to_delete, List<TreeNode> temp) {


        if (root == null) {
            return;
        } else if (search(root.val, to_delete)) {
            if (rootFather.left != null && rootFather.left.val == root.val) {
                rootFather.left = null;
            }
            if (rootFather.right != null && rootFather.right.val == root.val) {
                rootFather.right = null;
            }

            if (root.left != null) {
                if (!search(root.left.val, to_delete)) {
                    temp.add(root.left);
                }
            }
            if (root.right != null) {
                if (!search(root.right.val, to_delete)) {
                    temp.add(root.right);
                }
            }
        }

            aux_delNodes(root.left, root, to_delete, temp);
            aux_delNodes(root.right, root, to_delete, temp);


    }

        public boolean search( int i, int[] nums){
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    return true;
                }
            }
            return false;
        }
    }

