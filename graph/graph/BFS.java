package graph;

import java.util.LinkedList;
import java.util.Queue;

class BfsTest{
	
	private int[][] ad;
	private boolean[] visit;
	private int Nv;
	private Queue <Integer> q;

	
	public BfsTest(int Nv) {
		this.Nv = Nv;
		this.ad = new int[Nv+1][Nv+1];
		this.visit = new boolean[Nv+1];
		for(int i=0;i<visit.length;i++)
			visit[i] = false;

		this.q = new LinkedList<>();
	}
	
	public void putSingle(int a, int b) {
		this.ad[a][b] = 1;
	}
	
	public void put(int a, int b) {
		this.ad[a][b] = this.ad[b][a] = 1;
	}
	
	public void print() {
		for(int i=0;i<this.ad.length;i++) {
			for(int j=0;j<this.ad[i].length;j++) {
				System.out.print(""+this.ad[i][j]);
			}
			System.out.println();
		}
	}

	public void bfs(int k) {
		q.offer(k);
		visit[k] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			System.out.print(v +" ");
			
			for(int i=0;i<ad[v].length;i++) {
				if(ad[v][i] == 1) {
					if(visit[i] == false) {
						q.offer(i);
						//큐에 넣을 노드들을 잠재적으로 방문한다는 가정하에 입력
						visit[i] = true;
					}
				}
 			}
		}
	}
	
	 
}

public class BFS{
	
	public static void main(String[] args) {
		int nV = 7;
		BfsTest bfs = new BfsTest(nV);
		
		bfs.putSingle(1, 2);
		bfs.putSingle(1, 3);
		bfs.putSingle(1, 4);
		bfs.putSingle(2, 5);
		bfs.putSingle(3, 5);
		bfs.putSingle(5, 6);
		bfs.putSingle(5, 7);
		bfs.putSingle(7, 3);
	
		bfs.print();
		
		System.out.println();
		System.out.print("정점 1부터 탐색 :");
		bfs.bfs(1);
	}
}

