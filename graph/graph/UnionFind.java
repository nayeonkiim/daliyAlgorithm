package graph;

public class UnionFind {
	
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
	public static int findParent(int[] parent, int x, int y) {
		x = getParent(parent, x);
		y = getParent(parent,y);
		//같은 부모일 경우
		if(x == y) return 1;
		//다른 부모일 경우
		else return 0;
	}
	
	public static void main(String[] args) {
		int[] parent = new int[11];
		
		for(int i=1; i <= 10; i++) {
			parent[i] = i;
		}
		
		unionParent(parent, 1, 2);
		unionParent(parent, 2, 3);
		unionParent(parent, 3, 4);
		unionParent(parent, 5, 6);
		unionParent(parent, 6, 7);
		unionParent(parent, 7, 8);
		unionParent(parent, 8, 9);
		System.out.print("1과 5는 연결되어있나요? ");
		System.out.println(findParent(parent, 1,5));
	
		unionParent(parent, 1, 5);
		System.out.print("1과 5는 연결되어있나요? ");
		System.out.println(findParent(parent, 1,5));
	}
}
