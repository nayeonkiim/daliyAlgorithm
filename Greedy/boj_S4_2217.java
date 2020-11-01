package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_S4_2217 {
	
	public static void main(String args[]) throws RuntimeException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int ans = 0;
		
		for(int  i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int maxx = -1;
		
		Arrays.sort(arr);
		for(int i=0; i < N; i++) {
			int newNum = arr[i] * (N - i);
			
			maxx = Math.max(maxx, newNum);
		}

		System.out.println(maxx);
	}
}	
