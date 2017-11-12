package SecondBase;

import java.util.*;
import java.io.*;

public class Trees{

	TreeNode root;
	TreeNode temp;

	protected int height(TreeNode n){
		if(n==null) return 0;
		return 1+Math.max(height(n.left),height(n.right));
	}

	protected int size(TreeNode n){
		if(n==null) return 0;
		return 1+ size(n.left) + size(n.right);
	}
	protected boolean isBST(TreeNode n){
		return isBSTHelper(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	protected boolean isBSTHelper(TreeNode n, int min, int max){
		if (n==null) return true;
		if(n.data>max || n.data<min) return false;
		else return(isBSTHelper(n.left,min,n.data) && isBSTHelper(n.right,n.data,max));
	}

	protected boolean search(TreeNode n, int val){
		if(n==null) return false;
		if(n.data==val) return true;
		return search(n.left,val) || search(n.right,val);
	}

	protected boolean isBalanced(TreeNode n){
		if (n==null) return true;
		if(Math.abs(height(n.left)-height(n.right))<=1 && isBalanced(n.left) && isBalanced(n.right)) return true;
		return false;
	}

	protected TreeNode LCA(int n1, int n2){
		TreeNode t= new TreeNode(); 
		if(!search(this.root,n1) || !search(this.root,n2)) return t;
		return LCAHelper(this.root,n1,n2)!=null ? LCAHelper(this.root,n1,n2) : t;
	}
	protected TreeNode LCAHelper(TreeNode head,int n1, int n2){
		
		if(head==null) return null;
		if(n1==head.data || n2==head.data) return head;
		TreeNode leftLCA  = LCAHelper(head.left,n1,n2);
		TreeNode rightLCA = LCAHelper(head.right,n1,n2);

		if(leftLCA!=null && rightLCA!=null) return head;
		if(leftLCA!=null) return leftLCA;
		else return rightLCA;
	}

	protected int distance(int n1, int n2){
		if(!search(this.root,n1) || !search(this.root,n2)) return -1;
		TreeNode lca = LCA(n1,n2);
		return findLevel(lca,n1,0) + findLevel(lca,n2,0);
	}

	protected int findLevel(TreeNode head,int n, int level){
		if (head==null) return -1;
		if(head.data==n) return level;
		int leftLevel=findLevel(head.left,n,level+1);
		if(leftLevel==-1)
			return findLevel(head.right,n,level+1);
		return leftLevel;
	}

	/*protected int diameter(TreeNode n){
		if(n==null) return 0;
		int leftHeight=height(n.left);
		int rightHeight=height(n.right);
		return(Math.max(leftHeight+rightHeight+1, Math.max(diameter(n.left),diameter(n.right))));
	}*/
	
	private int dia=0;
	protected int diameter(TreeNode n){
		if(n==null) return 0;
		int height= diameterHelper(n);//,dia);
		return dia;
	}

	protected int diameterHelper(TreeNode n){//, int dia){
		if(n==null) return 0;
		int leftHeight=diameterHelper(n.left);
		int rightHeight=diameterHelper(n.right);
		dia=Math.max(dia, 1+leftHeight+rightHeight);
		return 1+Math.max(leftHeight,rightHeight);
	}
	/*
	*
	* TRAVERSALS
	*
	*/

	protected void levelPrint(TreeNode n, int level){
		if(n==null) return;
		if(level==1)
			System.out.print(n.data + " ");
		else
			levelPrint(n.left,level-1);
			levelPrint(n.right,level-1);
	}
	protected void levelOrder(TreeNode n){
		int h=height(n);
		for(int i=1;i<=h;i++){
			levelPrint(n,i);
			if(i!=h)System.out.println();
		}
	}

	protected void LevelOrderQueue(TreeNode n){
		if(n==null) return;
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(n);
		int count = 1;
		while(!q.isEmpty()){
			TreeNode cur=q.poll();
			count--;
			System.out.print(cur.data+" ");
			if(cur.left!=null) q.add(cur.left);
			if(cur.right!=null) q.add(cur.right);
			if(count==0){
				if(q.size()!=0)System.out.println();
				count=q.size();
			}
		}
	}

	protected void verticalOrder(TreeNode n){
		if(n==null) return;
		TreeMap<Integer,LinkedList<Integer>> verticalMap=new TreeMap<>();
		verticalOrderHelper(n,verticalMap,0);
		for(Map.Entry entry : verticalMap.entrySet()){  
   			System.out.println(entry.getKey()+" "+entry.getValue());  
 		} 
	}

	protected void verticalOrderHelper(TreeNode n, TreeMap<Integer,LinkedList<Integer>> verticalMap,int hd){
		if(n==null) return;
		if(verticalMap.containsKey(hd))
			verticalMap.get(hd).add(n.data);
		else{
			LinkedList l = new LinkedList();
			l.add(n.data);
			verticalMap.put(hd,l);
		}
		verticalOrderHelper(n.right,verticalMap,hd+1);
		verticalOrderHelper(n.left,verticalMap,hd-1);
	}

	protected void inOrder(TreeNode n){
		if(n!=null){
			inOrder(n.left);
			System.out.print(n.data + " ");
			inOrder(n.right);
		}
	}
	
	protected ArrayList<TreeNode> inOrder(TreeNode n, ArrayList<TreeNode> nodes){
		if(n==null) return null;
		inOrder(n.left,nodes);
		nodes.add(n);
		inOrder(n.right,nodes);
		return nodes;
	}

	protected void preOrder(TreeNode n){
		if(n!=null){
			System.out.print(n.data + " ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}

	protected void postOrder(TreeNode n){
		if(n!=null){
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.data + " ");
		}
	}

	Trees(){
		this.root=null;
	}


}