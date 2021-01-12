package StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_S5_2941_Re {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//trim - 공백제거
		String input = br.readLine().trim();
		int result = 0;
		int length = input.length();
		
		int i;
		for(i=0; i < length; i++) {
			result++;
			switch(input.charAt(i)) {
				case 'c':
			}
		}
		
		System.out.println(result);
	}
}
