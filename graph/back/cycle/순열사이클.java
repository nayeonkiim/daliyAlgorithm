package back.cycle;

import java.util.Scanner;

//DFS
public class 순열사이클 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int count = 0;
		while(t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n+1];
			for(int i=1;i<n+1;i++) {
				arr[i] = sc.nextInt();
			}
			
			boolean[] visit = new boolean[n+1];
			for(int i=1;i<n+1;i++) {
				if(visit[i] == false) {
					bfs(arr,i,visit);
					count++;
				}
			}
			System.out.println(count);
			count = 0;
		}
	}

	private static void bfs(int[] arr, int i, boolean[] visit) {
		if(visit[i] == true)
			return;
		
		visit[i] = true;
		int vis = arr[i];
		if(visit[vis] == false) {
			bfs(arr,vis,visit);
		}else {
			return;
		}
	}
}
