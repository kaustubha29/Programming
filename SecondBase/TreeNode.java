package SecondBase;

public class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;


	TreeNode(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}

	TreeNode(){
		this.data=-1;
		this.left=null;
		this.right=null; 	
	}
}