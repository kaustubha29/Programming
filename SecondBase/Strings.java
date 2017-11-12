package SecondBase;

import java.io.*;
import java.util.*;

public class Strings{

	static void printMap(Map map){
		/*
		for(Map.Entry entry : map.entrySet()){  
   			System.out.println(entry.getKey()+" "+entry.getValue());  
 		 } 
 		 */ 
		Set<?> keys = map.keySet();
		Iterator<?> iter = keys.iterator();
		while(iter.hasNext()){
			Object key = iter.next();
			System.out.println("Key: " + key + " Value: " + map.get(key));
		}
	}

	private static boolean isAnagram(String s1, String s2){
		if(s1.length()!=s2.length()) return false;
		s1=s1.toLowerCase();
		s2=s2.toLowerCase();
		HashMap<Character,Integer> hm= new HashMap<Character,Integer>();
		for (int i=0;i<s1.length();i++){
			char c=s1.charAt(i);
			if(hm.containsKey(c)) hm.put(c,hm.get(c)+1);
			else hm.put(c,1);
		}
		for (int i=0;i<s2.length();i++){
			char c=s2.charAt(i);
			if(!hm.containsKey(c)) return false;
			else hm.put(c,hm.get(c)-1);
		}

		//One Way
		// Set<Character> keys=hm.keySet();
		// Iterator<Character> iter =keys.iterator();
		// while(iter.hasNext()){
		// 	if (hm.get(iter.next()) != 0) return false;
		// }

		//Second Way

		for(Map.Entry entry: hm.entrySet()){
			if((int)entry.getValue()!=0) return false;
		}
		//printMap(hm);
		return true;
	}


	private static boolean hasUniqueLetters(String s){
		HashSet<Character> set= new HashSet<Character>();
		for(int i=0;i<s.length();i++){
			if(set.contains(s.charAt(i))) return false;
			else set.add(s.charAt(i));
		}
		return true;
	}

	static String swap(String str, int i, int j){
		char charArray[] = str.toCharArray();
		char temp=charArray[i];
		charArray[i]=charArray[j];
		charArray[j]=temp;
		return String.valueOf(charArray);
	}

	static void permutations(String str){
		int r=str.length();
		if (r<2) System.out.println(str);
		else permute(str,0,r-1);
	}

	static void permute(String str, int l, int r){
		if(l==r)
			System.out.print(str+ " ");
		else{
			for (int i=l;i<=r;i++){
				str=swap(str,l,i);
				permute(str,l+1,r);
				str=swap(str,l,i);
			}
		}
	}

	static HashSet<String> recPermute(String str){
		HashSet<String> permutations=new HashSet<String>();

		if(str.length()<2){
			permutations.add(str);
			//return permutations;
		}
		else{
			char first=str.charAt(0);
			String remainingStr=str.substring(1);
			HashSet<String> remPerms = recPermute(remainingStr);
			for(String w:remPerms){
				for(int i=0;i<=w.length();i++)
					permutations.add(insertCharAt(w,first,i));
			}
		}
		return permutations;
	}

	static String insertCharAt(String word, char c, int pos){
		String first = word.substring(0,pos);
		String last = word.substring(pos);
		return first+c+last;
	}

	/*static boolean isBalancedParenthesis(String str){
		if(str.lenght()<2) return false;
	}*/


	static void firstNonRepChar(){
		String input="";
		System.out.println("Type q! to exit ");
		HashMap<Character,Integer> charMap = new LinkedHashMap<>();
		ArrayList<Character> charNonRepSet = new ArrayList<Character>();
		HashSet<Character> charRepSet = new HashSet<>();
		Scanner in = new Scanner(System.in);
		String c="";char ch;
		while(true){
			System.out.print("\nEnter next Char : ");
			c= in.next();
			if(c.equals("q!")) break;
			input+=c;
			System.out.println("Current String : "+ input);
			System.out.print("First Non Repeating Char : ");
			ch=c.charAt(0);

			//Map Approach
			
			/*if(!charMap.containsKey(ch))
				charMap.put(ch,1);
			else
				charMap.put(ch,charMap.get(ch)+1);
			for(Map.Entry e: charMap.entrySet()){
				if((int)e.getValue()==1){
					System.out.print(e.getKey());
					break;
				}
			}*/

			//Set Approach

			if(charRepSet.add(ch))
				charNonRepSet.add(ch);
			else
				charNonRepSet.remove((Character)ch);								

			if(!charNonRepSet.isEmpty())
				System.out.print(charNonRepSet.get(0));
		}
	}


	public static void main(String[] args){
		/*System.out.println("Enter 1 words ");
		Scanner in = new Scanner(System.in);

		String s1=in.next();
		//String s2=in.next();
		//System.out.println("Are "+ s1 + ", " + s2 + " Anagrams? " + isAnagram(s1,s2) );
		System.out.println("Does "+ s1 + " have unique letters? " + hasUniqueLetters(s1));
		System.out.println("All Permutations of " + s1 );permutations(s1);
		System.out.println("\nAll Permutations of " + s1 +" \n" +recPermute(s1));
		*/
		firstNonRepChar();
	}
}
