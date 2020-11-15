package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
	
	//부모 찾기 (재귀)
	public static int getParent(int[] parent, int x) {
		if(x == parent[x]) return x;
		return getParent(parent, parent[x]);
	}
		
	//각 부모 노드를 합침
	public static void unionParent(int[] parent, int x, int y) {
		x = getParent(parent,x);
		y = getParent(parent,y);
		if(x < y) parent[y] = x;
		else parent[x] = y;
	}
		
	//같은 부모 노드를 가지는지 확인
	public static int find(int[] parent, int x, int y) {
		x = getParent(parent, x);
		y = getParent(parent,y);
		//같은 부모일 경우
		if(x == y) return 1;
		//다른 부모일 경우
		else return 0;
	}	
	
	public static class Edge{
		int[] node;
		int distance;
		Edge(int a, int b, int distance){
			this.node = new int[2];
			this.node[0] = a;
			this.node[1] = b;
			this.distance = distance;
 		}
		
	}
	
	public static void main(String[] args) {
		//정점의 갯수
		int n = 7;
		//간선의 갯수
		int m = 11;
		
		List<Edge> list = new ArrayList<>();
		list.add(new Edge(1,7,12));
		list.add(new Edge(1,4,28));
		list.add(new Edge(1,2,67));
		list.add(new Edge(1,5,17));
		list.add(new Edge(2,4,24));
		list.add(new Edge(2,5,62));
		list.add(new Edge(3,5,20));
		list.add(new Edge(3,6,37));
		list.add(new Edge(4,7,13));
		list.add(new Edge(5,6,45));
		list.add(new Edge(5,7,73));
		
		Collections.sort(list, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.distance - o2.distance;
			}
		});
		
		//index : 정점 정보, 값 : 부모노드 정보
		int[] set = new int[n];
		for(int i=0; i < n; i++) {
			set[i] = i;
		}
		
		int sum = 0;
		for(int i=0; i < list.size(); i++) {
			//부모 노드가 동일하지 않은 경우
			if(find(set,list.get(i).node[0]-1, list.get(i).node[1]-1) == 0) {
				sum += list.get(i).distance;
				//부모 합쳐
				unionParent(set, list.get(i).node[0] - 1, list.get(i).node[1] - 1);
			}
		}
		
		System.out.println(sum);
	}

}
