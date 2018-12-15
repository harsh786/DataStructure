package TreePkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode sibling;

	TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class TreeQuestions {

	public TreeNode StartNode;
	public int MaximumSum = 0;
	public int MaxLevel = -1;
	public TreeNode BSTRootNode = null;

	public TreeQuestions() {
		TreeNode ObjTreeNode = new TreeNode(10);
		if (StartNode == null) {
			StartNode = ObjTreeNode;
		}
		StartNode.left = new TreeNode(5);
		StartNode.right = new TreeNode(4);
		StartNode.left.left = new TreeNode(11);
		StartNode.left.right = new TreeNode(6);
		StartNode.right.left = new TreeNode(3);
		StartNode.right.right = new TreeNode(2);
		StartNode.left.left.right = new TreeNode(4);
		StartNode.left.left.right.left = new TreeNode(20);
		StartNode.left.right.left = new TreeNode(40);
		StartNode.right.left.right = new TreeNode(7);
		StartNode.right.right.right = new TreeNode(4);
		StartNode.right.right.right.right = new TreeNode(8);
		StartNode.right.right.right.right.right = new TreeNode(30);
	}

	public void FindMaxSumPathFromRootToLeaf(TreeNode start, int sum) {
		if (start == null) {
			return;
		}
		int val = sum + start.data;
		FindMaxSumPathFromRootToLeaf(start.left, val);
		FindMaxSumPathFromRootToLeaf(start.right, val);
		if (start != null && start.left == null && start.right == null) {
			if (val > MaximumSum) {
				MaximumSum = val;
			}

		}

	}

	public boolean FindPathWithMaximumSum(TreeNode start, ArrayList<Integer> ls, Integer count, int sum) {
		if (start == null) {
			return false;
		}
		int val = sum + start.data;
		ls.add(count, start.data);

		if (start != null && start.left == null && start.right == null) {
			if (val == MaximumSum) {
				PrintArray(ls, count);
				return true;
			}
		}
		if (FindPathWithMaximumSum(start.left, ls, count + 1, val)
				|| FindPathWithMaximumSum(start.right, ls, count + 1, val)) {
			return true;
		}
		return false;
	}

	void PrintArray(ArrayList<Integer> ls, Integer count) {
		System.out.println("Path with maximum sum ::" + MaximumSum + ",count is:" + count);
		for (int i = 0; i <= count; i++) {
			System.out.print(ls.get(i) + " ");
		}
	}

	public void PrintTreeInZigZagOrder(TreeNode start) {

		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		System.out.print("\n");
		System.out.println("PrintTreeInZigZagOrder::");
		stack1.push(start);

		int leftToRight = 1;
		while (stack1.size() != 0) {
			TreeNode obj = stack1.pop();

			System.out.print(obj.data + " ");
			if (leftToRight == 1) {
				if (obj.left != null) {
					stack2.push(obj.left);
				}
				if (obj.right != null) {
					stack2.push(obj.right);
				}

			} else {
				if (obj.right != null) {
					stack2.push(obj.right);
				}
				if (obj.left != null) {
					stack2.push(obj.left);
				}

			}

			if (stack1.size() == 0) {
				stack1 = stack2;
				stack2 = new Stack<TreeNode>();
				leftToRight = 1 - leftToRight;
				System.out.print("\n");
			}

		}

	}

	public void PrintLeftTree(TreeNode start, int Level) {
		if (start != null) {
			if (Level > MaxLevel) {
				MaxLevel = Level;
				System.out.print(start.data + " ");
			}
			PrintLeftTree(start.left, Level + 1);
			PrintLeftTree(start.right, Level + 1);

		}
		return;
	}

	public void ConvertListIntoBST(ArrayList<Integer> ls) {

	}

	public void DiagonalTraversal(TreeNode start, int i, Map<Integer, List<Integer>> mp) {
		if (start == null) {
			return;

		}
		
		if (!mp.containsKey(i)) {
			 ArrayList<Integer> ls = new ArrayList<Integer>();
			 ls.add(start.data);
			 mp.put(i, ls);

		} else {
			mp.get(i).add(start.data);
		}
		DiagonalTraversal(start.left, i + 1, mp);
		DiagonalTraversal(start.right, i, mp);

	}

	public boolean CheckWhetherAllareOfSameLevel(TreeNode start, int level) {
		if (start != null) {

			if (start.left == null && start.right == null) {
				if (MaxLevel == -1) {
					MaxLevel = level;
				}

				if (level != MaxLevel) {
					return false;

				}

			}
			if ((!CheckWhetherAllareOfSameLevel(start.left, level + 1))
					|| (!CheckWhetherAllareOfSameLevel(start.right, level + 1))) {
				return false;

			}

		}
		return true;

	}

	public boolean IsCheckTreeIsbstNot(TreeNode start, Integer prev) {
		if (start != null) {
			if (!IsCheckTreeIsbstNot(start.left, prev)) {
				return false;
			}
			if (prev == 0) {
				prev = start.data;

			} else {
				if (prev > start.data) {
					return false;
				}
			}
			if (!IsCheckTreeIsbstNot(start.right, prev)) {
				return false;
			}
		}
		return true;
	}

	public void ConvertBinaryTreeToDoublyLinkedList(TreeNode s, TreeNode preNode) {
		if (s != null) {
			ConvertBinaryTreeToDoublyLinkedList(s.left, preNode);
			s.left = preNode;
			if (preNode != null) {
				preNode.right = s;
			}
			preNode = s.left;
			ConvertBinaryTreeToDoublyLinkedList(s.right, preNode);

		}

	}

	public void LevelOrderTraversalAndConnectNodeAtSameLevel(TreeNode s) {
		LinkedList<TreeNode> que = new LinkedList<TreeNode>();
		TreeNode PreNode = null;
		if (s != null) {
			que.addLast(s);
			que.addLast(null);

		}
		while (!que.isEmpty()) {
			TreeNode tr = que.pollFirst();
			if (tr == null) {
				PreNode.sibling = tr;

				if (!que.isEmpty()) {
					que.addLast(null);
				}
			} else {
				if (PreNode != null) {
					PreNode.sibling = tr;
				}
				PreNode = tr;
				System.out.println(tr.data + " ");
				if (tr.left != null) {
					que.addLast(tr.left);
				}
				if (tr.right != null) {
					que.addLast(tr.right);
				}
			}

		}

	}

	public void InordertaversalWithoutRecursion(TreeNode s) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		while (true) {
			while (s != null) {
				st.push(s);
				s = s.left;

			}
			if (!st.isEmpty()) {
				s = st.pop();
				System.out.println(s);
				s = s.right;
			} else {

				break;
			}

		}

	}

	/*
	 * 1. Initialize current as root 2. While current is not NULL If current
	 * does not have left child a) Print currents data b) Go to the right,
	 * i.e., current = current->right Else a) Make current as right child of the
	 * rightmost node in current's left subtree b) Go to this left child, i.e.,
	 * current = current->left
	 */
	
	public void InordertraversalWithoutRecursionAndStack(TreeNode current) {
		if (current == null) {
			return;
		}
		while (current != null) {
			if (current.left == null) {
				System.out.println(current.data + " ");
				current = current.right;
			} else {
				// find predecessor of current node
				TreeNode pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;

				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;

				} else {
					pre.right = null;
					System.out.println(current.data + " ");
					current = current.right;
				}
			}

		}

	}

	public void PrintBoundryTraversalOfTree(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println("Boundry traversal");
		System.out.print(root.data + " ");
		if (root.left == null && root.right == null) {
			return;
		}
		if (root.left != null) {
			PrintLeftOfBoundry(root.left);
		}

		PrintLeavesOfTreeBoundry(root);
		if (root.right != null) {
			PrintRightOfBoundry(root.right);
		}

	}

	private void PrintLeftOfBoundry(TreeNode root) {

		if (root.left == null && root.right == null) {
			return;

		} else {
			System.out.print(root.data + " ");
		}
		if (root.left != null) {
			PrintLeftOfBoundry(root.left);
		} else {
			PrintLeftOfBoundry(root.right);
		}

	}

	private void PrintLeavesOfTreeBoundry(TreeNode root) {

		if (root != null) {
			if (root.left == null && root.right == null) {
				System.out.print(root.data + " ");
			}
			PrintLeavesOfTreeBoundry(root.left);
			PrintLeavesOfTreeBoundry(root.right);
		}

	}

	private void PrintRightOfBoundry(TreeNode root) {
		if (root != null) {
			if (root.right != null) {
				PrintRightOfBoundry(root.right);
			} else {
				PrintRightOfBoundry(root.left);
			}
			if (root.left == null && root.right == null) {
				return;
			} else {
				System.out.print(root.data + " ");
			}

		}

	}

	public TreeNode BSTInsertionUsingRecursion(TreeNode root, int data) {

		if (root == null) {
			root = new TreeNode(data);

			if (this.BSTRootNode == null) {
				this.BSTRootNode = root;

			}

		} else {
			if (data < root.data) {
				root.left = BSTInsertionUsingRecursion(root.left, data);
			} else if (data > root.data) {
				root.right = BSTInsertionUsingRecursion(root.right, data);
			}
		}
		return root;

	}

	public void BSTInsertionUsingIterative(TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode(data);

			if (this.BSTRootNode == null) {
				this.BSTRootNode = root;

			}
			return;
		} else {
			TreeNode parent = null;
			while (root != null) {
				parent = root;
				if (data < root.data) {
					root = root.left;
				} else {
					root = root.right;
				}

			}

			if (data < parent.data) {
				parent.left = new TreeNode(data);
			} else {
				parent.right = new TreeNode(data);
			}

		}

	}

	public void AvlTreeInsertion(TreeNode root) {

	}

   
}

public class TreeProblems {

	public TreeProblems() {
		TreeQuestions ObjTreeQuestions = new TreeQuestions();
		ObjTreeQuestions.FindMaxSumPathFromRootToLeaf(ObjTreeQuestions.StartNode, 0);
		System.out.println("Maximum path sum ::" + ObjTreeQuestions.MaximumSum);
		ArrayList<Integer> ls = new ArrayList<Integer>();
		Integer Count = new Integer(0);
		ObjTreeQuestions.FindPathWithMaximumSum(ObjTreeQuestions.StartNode, ls, Count, 0);

		ObjTreeQuestions.PrintTreeInZigZagOrder(ObjTreeQuestions.StartNode);
		System.out.print("\nPrintLeftTree\n");
		ObjTreeQuestions.PrintLeftTree(ObjTreeQuestions.StartNode, 0);
		Map<Integer, List<Integer>> mp = new HashMap<Integer, List<Integer>>();
		// ObjTreeQuestions.ConvertListIntoBST(new
		// ArrayList<Integer>().add(arg0));
		ObjTreeQuestions.DiagonalTraversal(ObjTreeQuestions.StartNode, 0, mp);
		System.out.println(mp);
		System.out.println(
				"Leaf at same level:" + ObjTreeQuestions.CheckWhetherAllareOfSameLevel(ObjTreeQuestions.StartNode, 0));
		ObjTreeQuestions.PrintBoundryTraversalOfTree(ObjTreeQuestions.StartNode);
	}
}
