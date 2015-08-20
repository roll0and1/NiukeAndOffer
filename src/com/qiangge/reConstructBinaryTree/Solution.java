package com.qiangge.reConstructBinaryTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Tree {
	TreeNode root;

	public Tree() {
		root = null;
	}

	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.val + ";");
		}
	}
}

public class Solution {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length == 0 || in.length == 0) {
			return null;
		}
		return reConstruct(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	/**
	 * 
	 * @param pre前序遍历数组
	 * @param in中序遍历数组
	 * @param preStart前序遍历数组起点
	 * @param preEnd前序遍历数组终点
	 * @param inStart中序遍历数组起点
	 * @param inEnd中序遍历数组终点
	 * @return
	 */
	private TreeNode reConstruct(int[] pre, int[] in, int preStart, int preEnd,
			int inStart, int inEnd) {
		// 前序遍历的第一个数字是根节点的值
		int rootValue = pre[preStart];
		TreeNode rootNode = new TreeNode(rootValue);
		rootNode.left = null;
		rootNode.right = null;
		if (preStart == preEnd) {
			if (inStart == inEnd && pre[preEnd] == in[inEnd]) { //youyiwen
				return rootNode;
			} else {
				System.out.println("invalid input");
			}
		}
		// 中序遍历确定左右子树
		int index = inStart;
		// 在中序遍历的数组中找到根节点的位置，根节点左边就是左子树，根节点右边就是右子树
		for (int i = 0; i < in.length; i++) {
			if (in[i] == rootValue) {
				index = i;
				break;
			}
		}
		int leftTreeLength = index - inStart;
		int rightTreeLength = inEnd - index;
		if (leftTreeLength > 0) {
			rootNode.left = reConstruct(pre, in, preStart + 1, preStart
					+ leftTreeLength, inStart, index - 1);
		}
		if (rightTreeLength > 0) {
			rootNode.right = reConstruct(pre, in, preEnd - rightTreeLength + 1,
					preEnd, index + 1, inEnd);
		}
		return rootNode;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode root = solution.reConstructBinaryTree(pre, in);
		Tree tree = new Tree();
		tree.postOrder(root);

	}
}
