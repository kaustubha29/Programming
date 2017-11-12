package SecondBase;

public class Node{
	Object data;
	Node next;
	Node prev;
	Node(Object data){
		this.data=data;
		next=null;
		prev=null;
	}

	Node(Object data, Node next){
		this.data=data;
		this.next=next;
	}
}