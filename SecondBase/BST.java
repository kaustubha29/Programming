package SecondBase;

import java.io.*;
import java.util.*;

public class BST extends Trees{

	void insert(int data){
		if(root==null){
			root = new TreeNode(data);
			//System.out.println("Inserted :: " + root.data);
		}
		else{
			temp=root;
			while(temp.left!=null && data<temp.data) temp=temp.left;
			while(temp.right!=null && data>temp.data) temp=temp.right;
			if(data==temp.data){
				System.out.println("Ignoring Duplicate Entry :: " + data);
				return;	
			}
			else if(data<temp.data){
				temp.left= new TreeNode(data);
				//System.out.println("Inserted :: " + temp.left.data);
			}
			else{
				temp.right= new TreeNode(data);
				//System.out.println("Inserted :: " + temp.right.data);
			}
		}

	}

	TreeNode insertSortedArray(int[] arr){
		return insertSortedArrayHelper(arr,0,arr.length-1);
	}

	TreeNode insertSortedArrayHelper(int[] arr, int l, int r){
		if(l>r) return null;
		int mid = (l+r)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = insertSortedArrayHelper(arr,l,mid-1);
		node.right= insertSortedArrayHelper(arr,mid+1,r);
		return node;
	}

	void delete(int data){
		deleteHelper(this.root,data,this.root);
	}

	void deleteHelper(TreeNode head, int data, TreeNode parent){
		if(head==null) return;
		if(data<head.data)
			deleteHelper(head.left,data,head);
		if(data>head.data)
			deleteHelper(head.right,data,head);
		if(data==head.data){
			if(head.left==null){ 
				if (parent.left==head) parent.left=head.right;
				else parent.right=head.right;
			}
			else if(head.right==null){
				if (parent.left==head) parent.left=head.left;
				else parent.right=head.left;
			}
			else{
				head.data=inOrderPreSuc(head,head.data)[1];
				deleteHelper(head.right,head.data,head);
			}
		}

	}

	TreeNode Balance(TreeNode n){
		if(isBalanced(n)){return n;}
		ArrayList<TreeNode> nodes= new ArrayList<TreeNode>();
		nodes=inOrder(n,nodes);
		int[] nodeData= new int[nodes.size()];
		int i=0;
		for(TreeNode t : nodes){
			nodeData[i++]=t.data;
		}
		BST newTree = new BST(nodeData);
		return newTree.root;
	}

	@Override
	protected boolean search(TreeNode n, int val){
		if(n==null) return false;
		if(n.data==val) return true;
		if(val<n.data)  return search(n.left,val);
		else return search(n.right,val);
	}

	@Override
	protected TreeNode LCAHelper(TreeNode head,int n1, int n2){
		if(head==null) return null;
		if(n1<head.data && n2<head.data)
			return LCAHelper(head.left,n1,n2);
		else if(n1>head.data && n2>head.data)
			return LCAHelper(head.right,n1,n2);
		return head;
	}

	@Override
	protected int findLevel(TreeNode head,int n, int level){
		if (head==null) return -1;
		if(head.data==n) return level;
		if(n<head.data)
			return findLevel(head.left,n,level+1);
		else
			return findLevel(head.right,n,level+1);	
	}
	
	void printAncestors(TreeNode n, int val){
		if(n==null || !search(n,val)) return; 
		if(val<n.data){
			System.out.print(n.data+ " ");
			printAncestors(n.left,val);
		}
		else {
			System.out.print(n.data+ " ");
			printAncestors(n.right,val);
		}
	}

	int[] inOrderPreSuc(TreeNode head, int val){
		int[] res = {-1,-1};
		return inOrderPreSucHelper(head,val,res);
	}
	
	int[] inOrderPreSucHelper(TreeNode head, int val, int[] res){
		if (head==null) return res;
		if(val<head.data){
			// Predecessor is to the left, Current successor is the head 
			res[1]=head.data;
			inOrderPreSucHelper(head.left,val,res);
		}
		if(val>head.data){
			// Successor is to the right, Current predecessor is the head
			res[0]=head.data;
			inOrderPreSucHelper(head.right,val,res);
		}
		if (val==head.data){
			// Predecessor is to the left, Successor is to the right 
			int[] leftres=inOrderPreSucHelper(head.left,val,res); 
			int[] rightres=inOrderPreSucHelper(head.right,val,res);
			res[0]=leftres[0];
			res[1]=rightres[1];
		}
		return res;
	}
	
	public static int c=0;
	void KthLargest(int k){
		KthLargestHelper(this.root,k);
	}

	void KthLargestHelper(TreeNode head,int k){
		if(head==null || c>=k) return;
		KthLargestHelper(head.right,k);
		c++;
		if(c==k){
			System.out.println(k + " largest element is " + head.data);
			return;
		}
		KthLargestHelper(head.left,k);
		//return 0;
	}

	/*
	* Constructors
	*/

	BST (int n){
		Random r = new Random(n);
		for(int i : r.intList)
			this.insert(i);
		System.out.println("Created BST with " + n + " Random integers");
	}

	BST(){
		this.root=null;
	}

	BST (int[] sortedArray){
		this.root=insertSortedArray(sortedArray);
	}

	public static void main(String[] args){
		//BST tree=new BST(8);
		BST tree=new BST();tree.insert(5);tree.insert(3);tree.insert(7);tree.insert(2);tree.insert(4);tree.insert(9);tree.insert(3);tree.insert(10);tree.insert(1);
		//BST tree=new BST();tree.insert(50);tree.insert(30);tree.insert(20);tree.insert(40);tree.insert(70);tree.insert(60);tree.insert(80);
		//int[] val = {1,2,3,4,5,7,9,10};BST tree = new BST(val);
		System.out.println("Size of Tree   : " +tree.size(tree.root));
		System.out.println("Root of Tree   : " +tree.root.data);
		System.out.println("Height of Tree : " +tree.height(tree.root));
		System.out.println("In Order");tree.inOrder(tree.root);
		System.out.println("\nPre Order");tree.preOrder(tree.root);
		System.out.println("\nPost Order");tree.postOrder(tree.root);
		System.out.println("\nLevel Order using Queue");tree.LevelOrderQueue(tree.root);
		System.out.println("\nLevel Order");tree.levelOrder(tree.root);System.out.println();
		System.out.println("\nVertical Order");tree.verticalOrder(tree.root);System.out.println();
		/*tree.KthLargest(3);
		System.out.println("\nIs tree BST? : " +tree.isBST(tree.root));
		System.out.println("Is 7 present ? : " +tree.search(tree.root,7));
		System.out.print("Ancestors of 7 : ");tree.printAncestors(tree.root,7);
		System.out.println("\nIs tree Balanced? : " +tree.isBalanced(tree.root));
		System.out.println("\nDiameter of Tree: " +tree.diameter(tree.root));
		//System.out.println("\nBalancing Tree .... ");
		//tree.root=tree.Balance(tree.root);
		//System.out.println("\nIs tree Balanced Now? : " +tree.isBalanced(tree.root));
		//System.out.println("\nLevel Order");tree.levelOrder(tree.root);
		System.out.println();
		System.out.println("LCA of 7, 4 is : "+ tree.LCA(7,4).data);
		//System.out.println("DIstance between 5, 4 is : " + tree.findLevel(tree.root,4,0));
		System.out.println("\nDIstance between 7, 4 is : "+ tree.distance(7,4));
		System.out.println("\nDeleting 7");tree.delete(7);System.out.println("In Order");tree.inOrder(tree.root);
		System.out.println("\nDeleting 3");tree.delete(3);System.out.println("In Order");tree.inOrder(tree.root);
		System.out.println("\nDeleting 1");tree.delete(1);System.out.println("In Order");tree.inOrder(tree.root);
		System.out.println("\nDeleting 10");tree.delete(10);System.out.println("In Order");tree.inOrder(tree.root);
		System.out.println("\nDeleting 11");tree.delete(11);System.out.println("In Order");tree.inOrder(tree.root);
		System.out.println("\nLevel Order");tree.levelOrder(tree.root);System.out.println();
		int[] inpresuc=tree.inOrderPreSuc(tree.root,3);System.out.println("In order Predecessor,Successor of 3 : " + inpresuc[0] + " , " + inpresuc[1]);
		inpresuc=tree.inOrderPreSuc(tree.root,7);System.out.println("In order Predecessor,Successor of 7 : " + inpresuc[0] + " , " + inpresuc[1]);
		inpresuc=tree.inOrderPreSuc(tree.root,8);System.out.println("In order Predecessor,Successor of 8 : " + inpresuc[0] + " , " + inpresuc[1]);
		inpresuc=tree.inOrderPreSuc(tree.root,4);System.out.println("In order Predecessor,Successor of 4 : " + inpresuc[0] + " , " + inpresuc[1]);
		inpresuc=tree.inOrderPreSuc(tree.root,1);System.out.println("In order Predecessor,Successor of 1 : " + inpresuc[0] + " , " + inpresuc[1]);
		inpresuc=tree.inOrderPreSuc(tree.root,10);System.out.println("In order Predecessor,Successor of 10 : " + inpresuc[0] + " , " + inpresuc[1]);
*/


	}
	
}