package SecondBase;

import java.io.*;
import java.util.*;
	


public class GraphL{
	int V;
	LinkedList<Integer>[] adjList;

	boolean visited[]=new boolean[V];


	private boolean[] getVisitedArray(){
		boolean visited[]= new boolean[V];
		for(boolean vis:visited)
			vis=false;
		return visited;
	}

	GraphL(int V){
		this.V=V;
		adjList=new LinkedList[V];
		for(int i=0;i<V;i++){
			adjList[i]=new LinkedList<Integer>();
		}
	}

	private void addEdge(Integer v, Integer e){
		adjList[v].add(e);
		adjList[e].add(v);
	}

	private void addEdgeDir(Integer v, Integer e){
		adjList[v].add(e);
	}

	private void printGraph(){
		for(int v=0;v<V;v++){
			System.out.print("\n"+v+" --> ");
			for(Integer e:adjList[v]){
				System.out.print((int)e+ " ");
			}
		}
		System.out.println();
	}

	private LinkedList<Integer> getEdges(int v){
		return adjList[v];
	}

	private void BFS(int v){
		visited=getVisitedArray();
		System.out.println("\nBFS of GraphL from Vertex : "+ v );
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(v);
		visited[v]=true;

		while(!q.isEmpty()){
			int cur=(int)q.poll();
			System.out.print(cur+ " ");
			for(Integer e: adjList[cur]){
				if(!visited[e]) {
					//System.out.print((int)e+ " ");
					visited[e]=true;
					q.add(e);
				}
			}
		}
	}

	private void DFS(int v){
		visited=getVisitedArray();
		System.out.println("\nDFS of GraphL from Vertex : "+ v );
		Stack<Integer> s=new Stack<Integer>();
		s.push(v);
		visited[v]=true;

		while(!s.isEmpty()){
			int cur=(int)s.pop();
			System.out.print(cur+ " ");
			for(Integer e : adjList[cur]){
				if(!visited[e]){
					visited[e]=true;
					s.push(e);
				}
			}
		}
	}

	private void DFSRec(int v){
		visited=getVisitedArray();
		System.out.println("\nDFS Recursion of Graph from Vertex : "+ v );
		DFSRecHelper(v,visited);
	}
	private void DFSRecHelper(int v, boolean[] visited){
		System.out.print(v+" ");
		visited[v]=true;
		for(Integer e : adjList[v]){
			if(!visited[e]){
				visited[e]=true;
				DFSRecHelper(e,visited);
			}
		}
	}

	private boolean Path(int a, int b){
		visited=getVisitedArray();
		System.out.print("\nPath between "+ a+" and "+b +" : ");
		Stack<Integer> s = new Stack<Integer>();
		if(!PathHelper(a,b,visited,s)){
			System.out.print(" No path ");
			return false;	
		}
		return true; 
	}
	
	
	private boolean PathHelper(int a, int b, boolean[]vistied,Stack<Integer> s){	
		s.push(a);
		visited[a]=true;
		for(Integer e : adjList[a]){
			if((int)e == b){
				s.push(e);
				System.out.print(s);
				return true;
			}
			if(!visited[e]){
				visited[e]=true;
				if(PathHelper(e,b,visited,s))
					return true;
			}
		}
		return false;
	}

	private boolean hasCycle(){
		boolean result=false;
		boolean finalres=false;
		for(int i=0;i<V;i++){
			result=Path(i,i);
			if(result) finalres=true;
			System.out.print("\nCycle from Vertex "+i+" ? "+result);
		}
		return finalres;
	}

	/*private boolean hasCycle(){
		visited=getVisitedArray();
		boolean[] recStack =getVisitedArray();
		boolean result=false;
		for(int v=0;v<V;v++){
			result= hasCycleHelper(v,visited,recStack);
			System.out.println("\nCycle from vertex : "+v+" "+result);
			visited=getVisitedArray();
		}
		return result;
	}	

	private boolean hasCycleHelper(int v, boolean[] visited, boolean[] recStack){
		if(!visited[v]){
			visited[v]=true;
			recStack[v]=true;
			for(int e: adjList[v]){
				if(hasCycleHelper(e,visited,recStack) && !visited[e])
					return true;
				else if(recStack[v])
					return true;		
			}
		}
		
		else
			recStack[v]=false;
		return false;
	}
	*/


	public static void main(String[] args){
		
		GraphL g= new GraphL(6);
		g.addEdgeDir(0,1);g.addEdgeDir(0,2);g.addEdgeDir(0,3);g.addEdgeDir(0,4);g.addEdgeDir(0,5);
		//g.addEdgeDir(0,1);g.addEdgeDir(0,2);g.addEdgeDir(1,4);g.addEdgeDir(1,3);g.addEdgeDir(2,0);g.addEdgeDir(3,4);g.addEdgeDir(4,1);g.addEdgeDir(4,3);g.addEdgeDir(5,2);
		//g.addEdge(1,4);g.addEdge(1,3);g.addEdge(1,0);g.addEdge(3,4);g.addEdge(3,5);g.addEdge(5,2);g.addEdge(5,0);g.addEdge(0,2);
		g.printGraph();
		g.BFS(0);g.BFS(1);g.BFS(2);
		g.DFS(1);g.DFSRec(1);g.DFS(0);g.DFSRec(0);
		g.Path(0,0);g.Path(3,5);g.Path(1,4);g.Path(2,4);g.Path(4,3);g.Path(5,5);
		System.out.println("\nDoes GraphL have Cycle? : "+ g.hasCycle());
		//System.out.print("\nEdges of Vertex 1 : ");for(Integer e:g.getEdges(1))System.out.print((int)e+ " ");

	
	}
}