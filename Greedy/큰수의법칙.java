package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰수의법칙 {
	//다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙.
	//특정 인덱스에 해당하는 수가 연속해서 k번을 초과하여 더해질 수 없는 것이 법칙의 특징
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int maxx = 0;
		String[] str = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(arr);
		
		int count = 0, idx = N-1, ans = 0;
		for(int i = 0; i < M; i++) {
			if(count >= K) {
				idx--;
				count = 0;
			}else {
				idx = N-1;
			}
			ans += arr[idx];
			count++;
		}
		
		System.out.println(ans);
	}

}
