package graph;

import java.util.ArrayList;
import java.util.Stack;

// 인접행렬 이용한 DFS 구현 (재귀)
class DfsGraph1 {
	private int nV;  //정점의 갯수
	private int[][] dfsGraph;  //그래프
	private boolean[] visitArr;  //정점 방문 여부 확인 배열
	
	public DfsGraph1(int nV) {
		this.nV = nV;
		this.dfsGraph = new int[this.nV+1][this.nV+1];
		this.visitArr = new boolean[this.nV+1];
	}
	
	//그래프 return
	public int[][] getGraph() {
		return this.dfsGraph;
	}
	
	//그래프 추가(양방향) - 정점 x와 y가 연결되어있음을 의미
	public void put(int x,int y) {
		this.dfsGraph[x][y] = this.dfsGraph[y][x] = 1;
	}
	
	//그래프 추가(단방향)
	public void putSingle(int x,int y) {
		this.dfsGraph[x][y] = 1;
	}
	
	//그래프 출력
	public void printGraphToAdjArr() {
		for(int i=0;i<this.dfsGraph.length;i++) {
			for(int j=0;j<this.dfsGraph[i].length;j++) {
				System.out.print(""+this.dfsGraph[i][j]);
			}
			System.out.println();
		}
	}
	
	//정점 방문 여부 확인 배열 초기화
	public void clearVisitArr() {
		for(int i=0;i<this.visitArr.length;i++) {
			this.visitArr[i] = false;
		}
	}
	
	//그래프 탐색(재귀호출)
	public void dfs(int vIdx) {
		// dfs()에 들어온 vIdx는 방문한 것이므로 방문 배열의 해당 index값을 true로 바꿔주고 값을 출력함.
		this.visitArr[vIdx] = true;
		System.out.print(vIdx + " ");
		
		for(int i=1;i<=this.nV;i++) {
			// 둘은 서로 연결되어 있다고 표시되지만 방문하지 않은 경우
			if(dfsGraph[vIdx][i] == 1 && visitArr[i] == false) {
				dfs(i);
			}
		}
	}
}

//인접리스트 이용한 DFS 구현 (재귀)
class DfsGraph2{
	private int nV;
	private ArrayList<ArrayList<Integer>> dfsGraph;
	private boolean[] visitArr;
	
	public DfsGraph2(int nV) {
		this.nV = nV;
		this.dfsGraph = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<this.nV+1;i++) {
			this.dfsGraph.add(new ArrayList<Integer>());
		}
		this.visitArr = new boolean[this.nV+1];
	}
	
	public ArrayList<ArrayList<Integer>> getGraph() {
		return this.dfsGraph;
	}
	
	public ArrayList<Integer> getNode(int i){
		return this.dfsGraph.get(i);
	}
	
	public void put(int x, int y) {
		this.dfsGraph.get(x).add(y);
		this.dfsGraph.get(y).add(x);
	}
	
	public void putSingle(int x, int y) {
		this.dfsGraph.get(x).add(y);
	}
	
	public void printGraphToAdjList() {
		for(int i=1;i<this.dfsGraph.size();i++) {
			System.out.print("정점" + i +"의 인접리스트");
			
			for(int j=0;j<this.dfsGraph.get(i).size();j++) {
				System.out.print("->" + this.dfsGraph.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public void clearVisitArr() {
		for(int i=0;i<this.visitArr.length;i++) {
			this.visitArr[i] = false;
		}
	}
	
	public void dfs(int vIdx) {
		this.visitArr[vIdx] = true;
		System.out.print(vIdx + " ");
		
		for(int i : this.dfsGraph.get(vIdx)) {
			if(this.visitArr[i] == false)
				dfs(i);
		}
	}
}

//인접행렬 이용한 DFS 구현 (스택)
class DfsGraph3{
	private int nV;  //정점의 갯수
	private int[][] dfsGraph;  //그래프
	private boolean[] visitArr;  //정점 방문 여부 확인 배열
	private Stack<Integer> stack;
	
	public DfsGraph3(int nV) {
		this.nV= nV;
		this.dfsGraph = new int[this.nV+1][this.nV+1];
		this.visitArr = new boolean[nV+1];
		for(int i=0;i<visitArr.length;i++)
			visitArr[i] = false;
		
		this.stack = new Stack<>();
	}
	
	public void putSingle(int a, int b) {
		this.dfsGraph[a][b] = 1;
	}
	
	public void put(int a,int b) {
		this.dfsGraph[a][b] = this.dfsGraph[b][a] = 1;
	}
	
	public void printGraphToAdjArr(){
		for(int i=0;i<dfsGraph.length;i++) {
			for(int j=0;j<dfsGraph[i].length;j++) {
				System.out.print(dfsGraph[i][j]);
			}
			System.out.println();
		}
	}
	
	public void dfs(int vIdx) {
		stack.push(vIdx);
		
		while(!stack.isEmpty()) {
			int v = stack.pop();
			if(visitArr[v] == false) {
				visitArr[v] = true;
				System.out.print(v+" ");
				
				for(int i = dfsGraph[v].length-1;i>0;i--) {
					if(dfsGraph[v][i] == 1) {
						if(visitArr[i] == false) {
							stack.push(i);
						}
					}
				}
			}
		}
	}
}

public class DFS {
	
	public static void main(String[] args) {
		int nV = 7;
		
		DfsGraph3 dfsGraph = new DfsGraph3(nV);
		
		dfsGraph.putSingle(1, 2);
		dfsGraph.putSingle(1, 3);
		dfsGraph.putSingle(1, 4);
		dfsGraph.putSingle(2, 5);
		dfsGraph.putSingle(3, 5);
		dfsGraph.putSingle(5, 6);
		dfsGraph.putSingle(5, 7);
		dfsGraph.putSingle(7, 3);
		
		dfsGraph.printGraphToAdjArr();
		
		System.out.println();
		System.out.print("정점 1부터 탐색 :");
		dfsGraph.dfs(1);
	}
}
	
