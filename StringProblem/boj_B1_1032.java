package StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_B1_1032 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		
		for(int i=0; i< N; i++) {
			str[i] = br.readLine();
		}
		
		int[] same = new int[str[0].length()];
		for(int i=1; i<N; i++) {
			for(int j = 0; j < str[0].length(); j++) {
				if(str[0].charAt(j) == str[i].charAt(j)) {
					same[j] += 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < same.length; i++) {
			if(same[i] == N-1) {
				sb.append(str[0].charAt(i));
			}else {
				sb.append("?");
			}
		}
		System.out.println(sb);
	}
}
