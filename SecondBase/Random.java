package SecondBase;

import java.util.*;

public class Random{
	List<Integer> intList = new ArrayList<Integer>();

	Random(int size){
		List<Integer> tempList=new ArrayList<Integer>();
		for(int i=0;i<2*size;i++)
			this.intList.add(i);
		Collections.shuffle(this.intList);
		intList=intList.subList(0,size);
		System.out.println("Generated Random ints : " + intList);
	}

	Random(int size,int max){
		List<Integer> tempList=new ArrayList<Integer>();
		for(int i=0;i<max;i++)
			this.intList.add(i);
		Collections.shuffle(this.intList);
		intList=intList.subList(0,size);
		System.out.println("Generated Random ints : " + intList);
	}

	
}