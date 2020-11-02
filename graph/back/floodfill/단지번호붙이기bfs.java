package back.floodfill;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

public class 단지번호붙이기bfs {
	static final int[] dx = {1,-1,0,0};
	static final int[] dy = {0,0,1,-1};
	static int[][] check;
	private static void dfs(int[][] arr, int i, int j, int n,int cnt) {
		check[i][j] = cnt;
		arr[i][j] = 0;
		
		for(int k=0;k<4;k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			if(nx >=0 && nx < n && ny >=0 && ny < n && arr[nx][ny] == 1) {
				dfs(arr,nx,ny,n,cnt);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		int[][] arr = new int[t][t];
		for(int i=0;i<t;i++) {
			String s = sc.nextLine();
			for(int j=0;j<t;j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		
		check = new int[t][t];
		int cnt = 0;
		for(int i=0;i<t;i++) {
			for(int j=0;j<t;j++) {
				if(arr[i][j] == 1) {
					dfs(arr,i,j,t,++cnt);
				}
			}
		}
		
		int[] ans = new int[cnt];
		for(int i=0;i<t;i++) {
			for(int j=0;j<t;j++) {
				for(int k=0;k<cnt;k++) {
					if(check[i][j] == k+1) {
						ans[k] += 1; 
					}
				}
			}
		}
			
		System.out.println(cnt);
		Arrays.sort(ans);
		for(int i=0;i<cnt;i++) {
			System.out.println(ans[i]);
		}
	}
}
