package SecondBase;

import java.io.*;
import java.util.*;
	


public class GraphM{
	int V;
	int[][] adjMat;

	boolean visited[]=new boolean[V];

	private boolean[] getVisitedArray(){
		boolean visited[]= new boolean[V];
		for(boolean vis:visited)
			vis=false;
		return visited;
	}

	GraphM(int V){
		this.V=V;
		adjMat=new int[V][];
		for (int i=0;i<V;i++)
			adjMat[i]=new int[V];
		for(int i=0;i<V;i++){
			for(int j=0;j<V;j++)
				adjMat[i][j]=0;
		}
	}

	private void addEdge(Integer v, Integer e){
		adjMat[v][e]=1;
		adjMat[e][v]=1;
	}

	private void addEdgeDir(Integer v, Integer e){
		adjMat[v][e]=1;
	}

	private void printGraph(){

		System.out.print("\n      ");
		for(int i=0;i<V;i++)
			System.out.print(i+ " ");
		System.out.print("\n      ");
		for(int i=0;i<V;i++)
			System.out.print("|"+ " ");
		for(int v=0;v<V;v++){
			System.out.print("\n"+v+" --> ");
			for(int e:adjMat[v]){
				System.out.print(e+ " ");
			}
		}
		System.out.println();
	}
	
	private LinkedList<Integer> getEdges(int v){
		LinkedList<Integer> edges=new LinkedList<Integer>();
		for(int i=0;i<V;i++){
			if(adjMat[v][i]==1) edges.add(i);
		}
		return edges;
	}

	private void printAllEdges(){
		for(int i=0;i<V;i++){
			System.out.print("\nEdges of Vertex "+i+" : ");
			for(Integer e:getEdges(i))System.out.print((int)e+ " ");
		}

	}
	private void BFS(int v){
		visited=getVisitedArray();
		System.out.println("\nBFS of Graph from Vertex : "+ v );
		Queue q=new LinkedList<Integer>();
		q.add(v);
		visited[v]=true;

		while(!q.isEmpty()){
			int cur=(int)q.poll();
			System.out.print(cur+ " ");
		
			for(int i=0;i<V;i++){
				if(adjMat[cur][i]==1){
					if(!visited[i]){
						q.add(i);
						visited[i]=true;
					}
				}
		
			}
		}
	}

	private void DFS(int v){
		visited=getVisitedArray();
		System.out.println("\nDFS of Graph from Vertex : "+ v );
		Stack<Integer> s=new Stack<Integer>();
		s.push(v);
		visited[v]=true;

		while(!s.isEmpty()){
			int cur=(int)s.pop();
			System.out.print(cur+" ");

			for(int i=0;i<V;i++){
				if(adjMat[cur][i]==1){
					if(!visited[i]){
						visited[i]=true;
						s.push(i);
					}
				}
			}
		}
	}
	private void DFSRec(int v){
		visited=getVisitedArray();
		System.out.println("\nDFS Rec of Graph from Vertex : "+ v );
		DFSRecHelper(v,visited);
	}
	private void DFSRecHelper(int v, boolean[] visited){
		visited[v]=true;
		System.out.print(v+ " ");
		for(int i=0;i<V;i++){
			if(adjMat[v][i]==1){
				if(!visited[i])
					DFSRecHelper(i,visited);
			}
		}
	}

	private boolean Path(int a, int b){
		visited=getVisitedArray();
		System.out.print("\nPath between "+ a+" and "+b +" : ");
		Stack<Integer> path = new Stack<Integer>();
		if(!PathHelper(a,b,visited,path)){
			System.out.print(" No path ");
			return false;	
		}
		return true; 
	}
	private boolean PathHelper(int a, int b, boolean[]visited, Stack<Integer> path){
		path.push(a);
		visited[a]=true;
		for(int i=0;i<V;i++){
			if(adjMat[a][i]==1){
				if(i==b){
					path.push(b);
					System.out.print(path);
					return true;
				}
				if(!visited[i]){
					visited[i]=true;
					if(PathHelper(i,b,visited,path))
						return true;
				}
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



	public static void main(String[] args){
			
			GraphM g= new GraphM(6);
			g.addEdgeDir(0,1);g.addEdgeDir(0,2);g.addEdgeDir(0,3);g.addEdgeDir(0,4);g.addEdgeDir(0,5);
			//g.addEdgeDir(0,1);g.addEdgeDir(0,2);g.addEdgeDir(1,4);g.addEdgeDir(1,3);g.addEdgeDir(2,0);g.addEdgeDir(3,4);g.addEdgeDir(4,1);g.addEdgeDir(4,3);g.addEdgeDir(5,2);
			//g.addEdge(1,4);g.addEdge(1,3);g.addEdge(1,0);g.addEdge(3,4);g.addEdge(3,5);g.addEdge(5,2);g.addEdge(5,0);g.addEdge(0,2);
			g.printGraph();
			g.printAllEdges();
			g.BFS(0);g.BFS(1);g.BFS(2);
			g.DFS(1);g.DFSRec(1);g.DFS(0);g.DFSRec(0);
			g.Path(0,0);g.Path(3,5);g.Path(1,4);g.Path(2,4);g.Path(4,3);g.Path(5,5);
			System.out.println("\nDoes GraphL have Cycle? : "+ g.hasCycle());
			

		
		}
}