package SecondBase;

import java.util.*;
import java.io.*;

public class LRUCache{

	CacheQueue cache= new CacheQueue();
	HashMap<Integer,Node> cmap;
	private int size;

	LRUCache(int size){
		if(size<1){
			System.out.println("Illegal size, defaulting to 5");
			this.size=5;
		}
		else
			this.size=size;
		cmap=new HashMap<>(this.size);
		cache= new CacheQueue(this.size);
	}

	private Node get(int key){
		if(cmap.containsKey(key)){
			return cmap.get(key);
		}
		else
			return null;
	}

	private void set(int key){
		Node current=get(key);
		if(current==null){
			if(cache.size<this.size){
				System.out.println("\nCache Miss and Cache Not full, Inserting "+ key +" at tail");
				cache.insert(key);
				cmap.put(key,cache.tail);
			}
			else{
				System.out.println("\nCache Miss and Reached Size, Delete head and insert "+ key +" at tail");
				cmap.remove(cache.getHead());
				cache.deleteHead();
				cache.insert(key);
				cmap.put(key,cache.tail);
			}
		}
		else{
			Node temp=current;
			System.out.println("\nCache Hit, Re Organize : "+ temp.data);

			if(temp==cache.head){
				System.out.println("Cache Hit at Head");
				//Moving head
				temp.prev.next=null;
				cache.setHead(temp.prev);
				// To the tail 
				cache.setTail(current);

			}
			else if(temp==cache.tail){
				System.out.println("Cache Hit at Tail, Doing nothing");
			}
			else{
				System.out.println("Cache Hit in Middle");
				temp.prev.next=temp.next;
				temp.next.prev=temp.prev;
				cache.setTail(current);
			}
			
		}
		display();
	}

	private void display(){
		Node temp=this.cache.tail;
		System.out.println("Size of the Cache: "+ cache.size);
		System.out.println("Contents of the Cache");
		while(temp!=null){
			System.out.print(temp.data + " " );
			temp=temp.next;
		}
		System.out.println();
		System.out.println("Contents of the HashMap");
		for(Map.Entry e : this.cmap.entrySet())
			System.out.println(e.getKey()+" : "+ e.getValue());
	}

	public static void main(String args[]){
		LRUCache lru= new LRUCache(3);
		lru.set(1);lru.set(2);lru.set(3);lru.set(4);lru.set(2);lru.set(5);lru.set(1);lru.set(1);lru.set(2);lru.set(1);
		//lru.display();

	}

}