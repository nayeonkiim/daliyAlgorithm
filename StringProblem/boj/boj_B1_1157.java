package StringProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_B1_1157 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().toUpperCase();
		
		int[] total = new int[26];
		for(int i=0; i<str.length(); i++) {
			total[str.charAt(i)-'A']++;
		}
		
		int most = 0;
		char idx = 0;
		for(int i=0; i<26; i++) {
			most = Math.max(most, total[i]);
		}
		
		int count = 0;
		for(int i=0; i < 26; i++) {
			if(most == total[i]) {
				count++;
				idx = (char)(i+'A');
			}
		}
		if(count > 1)
			System.out.println("?");
		else
			System.out.println(idx);
	}
}
