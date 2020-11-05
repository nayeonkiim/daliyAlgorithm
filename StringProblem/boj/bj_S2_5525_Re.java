package StringProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//내풀이 시간 초과남
//이 풀이는 내 풀이 아님
public class bj_S2_5525_Re {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		char[] s = br.readLine().toCharArray();
		
		int result = 0;
		int patternCnt = 0;
		for(int i = 1; i < m-1; i++) {
			if(s[i - 1] == 'I' && s[i] =='O' && s[i+1] == 'I') {
				patternCnt++;
				if(patternCnt == n) {
					patternCnt--;
					result++;
				}
				i++;
			}else patternCnt = 0;
		}
		System.out.println(result);
	}
}
