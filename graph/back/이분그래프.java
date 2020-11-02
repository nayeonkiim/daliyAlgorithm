package back;

import java.util.ArrayList;
import java.util.Scanner;

// 그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할 - 이분그래프
// 해당 그래프가 이분 그래프인지 아닌지 판별
// 간선으로 연결되어 있는 정점의  color의 값이 서로 같으면 안됨.
public class 이분그래프 {
	static int a;
	static int b;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> arr = null;
		int[] color;
		boolean ok = true;
		
		int c = sc.nextInt();
		while(c-- > 0) {
			//정점
			int n = sc.nextInt();
			//간선
			int m = sc.nextInt();
			arr = new ArrayList<ArrayList<Integer>>();
			
			for(int j=0;j<n+1;j++) {
				arr.add(new ArrayList<Integer>());
			}
			
			// 간선으로 정점을 서로 이어주기
			for(int j=0;j<m;j++) {
				a = sc.nextInt();
				b = sc.nextInt();
				arr.get(a).add(b);
				arr.get(b).add(a);
			}
			
			//맨처음에 0으로 되어있어
			color = new int[n+1];

			//여기서 color[1]=1,color[2]=1,color[3]=2
			for(int j=1; j<=n;j++) {
				if(color[j] == 0) {
					dfs(arr,color,j,1);
				}
			}
			for(int j=1; j<=n;j++) {
				for(int k : arr.get(j)) {
					if(color[k] == color[j]) {
						ok = false;
					}
				}
			}
			if(ok) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> a,int[] color, int x, int c){
		color[x] = c;
		for(int y : a.get(x)) {
			if(color[y] == 0) {
				dfs(a,color,y,3-c);
			}
		}
	}
}
