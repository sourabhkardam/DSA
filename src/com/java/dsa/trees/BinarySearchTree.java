package com.java.dsa.trees;

public class BinarySearchTree {

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.add(50);
		binarySearchTree.add(60);
		binarySearchTree.add(40);
		binarySearchTree.add(30);
		binarySearchTree.add(70);
		binarySearchTree.add(20);
		binarySearchTree.add(10);
		binarySearchTree.add(80);

		System.out.print("Pre-Order Traversal: ");
		binarySearchTree.preOrder();
		System.out.println();

		System.out.print("In-Order Traversal: ");
		binarySearchTree.inOrder();
		System.out.println();

		System.out.print("Post-Order Traversal: ");
		binarySearchTree.postOrder();
	}

	private TreeNode rootNode;

	class TreeNode {
		private Integer data;
		private TreeNode left;
		private TreeNode right;

		TreeNode(Integer data) {
			this.data = data;
		}
	}

	public void add(Integer data) {
		// if rootNode is null then new node will be assigned to rootNode
		// else rootNode will be assigned to rootNode
		rootNode = addRecursively(rootNode, data);
	}

	private TreeNode addRecursively(TreeNode currentNode, Integer data) {
		if (currentNode == null) {
			return new TreeNode(data);
		}

		if (data < currentNode.data) {
			// if currentNode.left is null then new node will be assigned to
			// currentNode.left
			// else currentNode.left will be assigned to currentNode.left
			currentNode.left = addRecursively(currentNode.left, data);
		} else {
			// if currentNode.right is null then new node will be assigned to
			// currentNode.right
			// else currentNode.right will be assigned to currentNode.right
			currentNode.right = addRecursively(currentNode.right, data);
		}

		return currentNode;
	}

	public void preOrder() {
		preOrderTraversal(rootNode);
	}

	private void preOrderTraversal(TreeNode currentNode) {
		if (currentNode != null) {
			System.out.print(currentNode.data + " ");
			preOrderTraversal(currentNode.left);
			preOrderTraversal(currentNode.right);
		}
	}

	public void postOrder() {
		postOrderTraversal(rootNode);
	}

	private void postOrderTraversal(TreeNode currentNode) {
		if (currentNode != null) {
			postOrderTraversal(currentNode.left);
			postOrderTraversal(currentNode.right);
			System.out.print(currentNode.data + " ");
		}
	}

	public void inOrder() {
		inOrderTraversal(rootNode);
	}

	private void inOrderTraversal(TreeNode currentNode) {
		if (currentNode != null) {
			inOrderTraversal(currentNode.left);
			System.out.print(currentNode.data + " ");
			inOrderTraversal(currentNode.right);
		}
	}

}
