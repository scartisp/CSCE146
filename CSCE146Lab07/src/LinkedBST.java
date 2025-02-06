//Simion Cartis

public class LinkedBST<T extends Comparable<T>> {
	private class Node {
		T data;
		Node leftChild;
		Node rightChild;

		public Node(T aData) {
			data = aData;
		}
	}

	private Node root;

	public LinkedBST() {
		root = null;
	}

	public void add(T aData) {
		if (root == null)// If nothing is in the tree, make the root and add that data to it
			root = new Node(aData);
		else
			add(root, aData);
	}

	private Node add(Node aNode, T aData) {
		if (aNode == null)
			aNode = new Node(aData);
		else if (aData.compareTo(aNode.data) < 0)
			aNode.leftChild = add(aNode.leftChild, aData);// these lines decide where to add the new node
		else if (aData.compareTo(aNode.data) > 0)
			aNode.rightChild = add(aNode.rightChild, aData);
		return aNode;// this returns the new node, wherever it is
	}

	public void remove(T aData) {
		root = remove(root, aData);
	}

	public Node remove(Node aNode, T aData) {
		if (aNode == null)
			return null;
		else if (aData.compareTo(aNode.data) < 0)
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if (aData.compareTo(aNode.data) > 0)
			aNode.rightChild = remove(aNode.rightChild, aData);
		else {
			if (aNode.rightChild == null)
				return aNode.leftChild;
			else if (aNode.leftChild == null)
				return aNode.rightChild;
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		return aNode;
	}

	private Node findMinInTree(Node aNode) {
		if (aNode == null)
			return null;
		else if (aNode.leftChild == null)
			return aNode;// goes down the left path until it reaches a leaf
		else
			return findMinInTree(aNode.leftChild);
	}

	public void printPreOrder() {
		printPreOrder(root);
	}

	private void printPreOrder(Node aNode) {
		if (aNode == null)
			return;
		System.out.println(aNode.data);// prints the root, goes down left path. Every node visited is printed
		printPreOrder(aNode.leftChild);// once finds left-most leaf, pops to the branch of that leaf and goes down
		printPreOrder(aNode.rightChild);// right path. repeats.
	}

	public void printInOrder() {
		printInOrder(root);
	}

	private void printInOrder(Node aNode) {
		if (aNode == null)
			return;
		printInOrder(aNode.leftChild);
		System.out.println(aNode.data);
		printInOrder(aNode.rightChild);
	}

	public void printPostOrder() {
		printPostOrder(root);
	}

	private void printPostOrder(Node aNode) {
		if (aNode == null)
			return;
		printPostOrder(aNode.leftChild);// goes down the left path until null
		printPostOrder(aNode.rightChild);// if at leaf, right child is null, will then print leaf
		System.out.println(aNode.data);// then moves to right leaf, right and left child are null for it, so prints
		// pops off stack to the branch holding the leaves, prints it, goes to right
		// path and repeats
	}
}
