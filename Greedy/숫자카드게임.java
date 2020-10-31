package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자카드게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		int[] minn = new int[N];
		for(int i=0; i<N; i++) {
			minn[i] = 10001;
		}
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				
				//대신 min()함수 써도 댐
				if(arr[i][j] < minn[i]) {
					minn[i] = arr[i][j];
				}
			}
		}
		
		int maxx = 0;
		for(int i = 0; i < N; i++) {
			//대신 max()함수 써도 댐
			if(maxx < minn[i]) {
				maxx = minn[i];
			}
		}
		System.out.print(maxx);
		
	}

}
