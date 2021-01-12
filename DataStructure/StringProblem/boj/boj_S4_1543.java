package StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_S4_1543 {
	//영어로만 이루어진 어떤 문서 검색하는 함수.
	//어떤 단어가 총 몇번 등장하는지 세
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String dan = br.readLine();
		String find = br.readLine();
		String sub = null;
		
		int to = find.length();
		int count = 0, i=0;
		while(i+to-1 < dan.length()) {
			sub = dan.substring(i,i+to);
			if(sub.equals(find)) {
				i += to;
				count++;
			}else {
				i++;
			}
		}
		System.out.println(count);
	}
}
