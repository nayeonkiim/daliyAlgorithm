package StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_S5_2941 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int len = str.length();
		int ans = 0;
		
		for(int i=0; i < len; i++) {
			
			char ch = str.charAt(i);
			
			if(ch == 'c' && i < len-1) {
				if(str.charAt(i+1) == '=' || str.charAt(i+1) == '-') {
					i+=1;
				}
			}else if(ch == 'd' && i < len-1) {
				if(str.charAt(i+1) == '-') {
					i+=1;
				}else if(str.charAt(i+1) == 'z' && i < len-2) {
					
					if(str.charAt(i+2) == '=')
						i += 2;
				}
			}else if((ch == 'l' || ch == 'n')  && i < len-1) {
				if(str.charAt(i+1) == 'j') {
					i+=1;
				}
			}else if((ch == 's' || ch == 'z') && i < len-1) {
				if(str.charAt(i+1) == '=') {
					i+=1;
				}
			}
			ans += 1;
		}
		System.out.println(ans);
	}
	
	//다른 사람 풀이 - 굳 아이디어
	public int anotherAns(String str) {
		String[] crotia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i=0; i <crotia.length; i++) {
			str = str.replaceAll(crotia[i], "*");
		}
		
		int answer = str.length();
		System.out.println(answer);
		
		return answer;
	}
}
