package StringProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_S4_1120_Re {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int diffLen = B.length() - A.length();
		int k = 0, result = 0, less = Integer.MAX_VALUE, count = 0;
		
		while(k + A.length() -1 < B.length()) {
			for(int i=0; i<A.length(); i++) {
				if(A.charAt(i) != B.charAt(k)) {
					result += 1;
				}
				k++;
			}
			count+=1;
			k = count;
			less = Math.min(less,result);
			result = 0;
		}
		System.out.println(less);
	}
}
