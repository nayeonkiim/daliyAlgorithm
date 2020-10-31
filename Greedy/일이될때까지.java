package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일이될때까지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int count = 0;
	
		while(true) {
			if(N == 1)
				break;
			if(N % K != 0) {
				N -= 1;
				count++;
			}else {
				N /= K;
				count++;
			}
		}
		System.out.println(count);
	}
	
}
