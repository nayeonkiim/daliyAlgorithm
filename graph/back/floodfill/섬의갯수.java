package back.floodfill;

import java.util.Scanner;

//상하좌우대각선까지 가눙
public class 섬의갯수 {
	public static final int[] dx = {0,0,1,-1,1,1,-1,-1};
	public static final int[] dy = {1,-1,0,0,1,-1,1,-1};
	private static void dfs(int[][] a, int i, int j, int m, int n) {
		a[i][j] = 0;
		
		for(int k=0;k<8;k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			if(nx >=0 && nx < m && ny >=0 && ny < n && a[nx][ny] == 1) {
				dfs(a,nx,ny,m,n);
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==0 && m==0) {
				break;
			}
			
			int[][] a = new int[m][n];
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			int ans = 0;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(a[i][j] == 1) {
						dfs(a,i,j,m,n);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
		}
	}

}
