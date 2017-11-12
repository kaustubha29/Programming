package SecondBase;

import java.util.*;
import java.io.*;

public class CacheQueue{
	
	Node head;
	Node tail;
	protected int size=0;

	protected void insert(Object val){
		this.size++;	
		if(head==null){
			head=new Node(val);
			head.next=null;
			head.prev=null;
			this.setHead(head);
			this.setTail(head);
		}
		else{
			Node temp=this.tail;
			temp.prev=new Node(val);
			temp.prev.next=temp;
			this.setTail(temp.prev);		
		}
		//System.out.println("Size : "+ this.size);
	}

	protected void deleteHead(){
		Node temp=this.head;
		this.setHead(temp.prev);
		temp.prev.next=null;
		this.size--;
	}

	protected void deleteTail(){
		Node temp=this.tail;
		this.setTail(temp.next);
		temp.next.prev=null;
		this.size--;
	}

	protected Object delete(Object val){
		if(val==this.head.data){
			deleteHead();
			return val;
		}
		if(val==this.tail.data){
			deleteTail();
			return val;
		}
		Node temp=this.tail;
		while(temp!=null && temp.data!=val)
			temp=temp.next;
		Object retval=temp.data;
		if(temp!=null){
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
		}
		this.size--;
		return retval;
	}

	protected Object getHead(){
		return this.head.data;
	}

	protected Object getTail(){
		return this.tail.data;
	}

	protected void setHead(Node val){
		this.head=val;
	}

	protected void setTail(Node val){
		if (val!=head){
			this.tail.prev=val;
			val.next=this.tail;
		}
		this.tail=val;
	}

	CacheQueue(int size){
		//this.size=size;
	}
	CacheQueue(){
		this.size=0;
	}

}