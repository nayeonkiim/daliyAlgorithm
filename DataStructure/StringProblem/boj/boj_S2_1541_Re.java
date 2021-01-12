package StringProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_S2_1541_Re {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		List<Integer> num =new ArrayList<>();
		List<Character> bul = new ArrayList<>();
		
		int start = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '+' || str.charAt(i) == '-') {
				bul.add(str.charAt(i));
				num.add(Integer.parseInt(str.substring(start,i)));
				start = i+1;
			}
		}
		num.add(Integer.parseInt(str.substring(start)));
		
		int idx = 0, hasmin = 0, result = 0;
		while(idx < num.size()) {
			
			if(hasmin == 1) {
				result -= num.get(idx);
			}else {
				result += num.get(idx);
			}
			
			if(idx < bul.size() && bul.get(idx) == '-') {
				hasmin = 1;
			}
			idx++;
		}
		System.out.println(result);
	}
}
