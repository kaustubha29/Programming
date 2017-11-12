package SecondBase;

import java.io.*;
import java.util.*;


public class LinkedListMy{
	Node head;
	private Node temp;

	void insert(Object data){
		if(head==null){
			head = new Node(data,null);
			temp=head;
		}
		else{
			while(temp.next!=null) temp=temp.next;
			temp.next=new Node(data);
		}
	}

	void printList(){
		temp=head;
		while(temp!=null){
			System.out.print(temp.data+ " ");
			temp=temp.next;
		}
		System.out.println();
	}

	
	// PRINT REVERSE

	void printReverse(){
		if(head!=null)
		printReverseHelper(head);
		System.out.println();
	}
	void printReverseHelper(Node n){
		if(n.next!=null)
			printReverseHelper(n.next);
		System.out.print(n.data+ " ");
	}


	// INPLACE REVERSAL

	void inPlaceReversal(){
		Node p=head;
		Node q=head.next;
		Node r=head.next.next;

		while(r!=null){

			if(p==head) p.next=null;
			q.next=p;
			p=q;q=r;r=r.next;
			
		}
		q.next=p;
		head=q;
	}
 
	// Recursive Reverse

	void recReverse(){
		recReverseHelper(head,null);
	}

	void recReverseHelper(Node curr, Node prev){
		if(curr.next==null){
			head = curr;
			curr.next= prev;
		}
		else{
			Node nextNode= curr.next;
			curr.next=prev;
			recReverseHelper(nextNode,curr);
		}
	}

	int length(){
		temp=head;
		int len=0;
		while(temp!=null){
			len++;
			temp=temp.next;
		}
		return len;
	}

	void deleteNodeAt(int pos){
		int len=this.length();
		temp=head;
		if(pos==1){
			head=head.next;
		}
		else if (pos < len && pos >0){
			for(int i=1;i<pos-1;i++)
				temp=temp.next;
			Node toDelete = temp.next;
			temp.next=toDelete.next;
			toDelete.next=null;
		}
		else if (pos==len){
			while(temp.next.next!=null) temp=temp.next;
			temp.next=null;
		}
		else System.out.println("Illegal Position");
	}




	LinkedListMy(int len){
		Random r = new Random(len);
		for(int i : r.intList)
			this.insert(i);
	}
	LinkedListMy(){this.head=null;}


	public static void main(String[] args){
		LinkedListMy l = new LinkedListMy(10);
		//l.insert(22);l.insert(3);l.insert(56);
		System.out.print("Print List       : ");l.printList();
		//System.out.println("Length of List : " + l.length());
		//System.out.print("Print List : ");l.printList();
		System.out.print("Print Reverse.   : ");l.printReverse();
		System.out.print("Recursive Reverse: ");l.recReverse();l.printList();
		System.out.print("In Place Reverse : ");l.inPlaceReversal();l.printList();
		//System.out.println("Delete Node at Pos : 3");l.deleteNodeAt(3);System.out.print("Print List : ");l.printList();

	}
}

