package StringProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_S4_4949 {
	//괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램 짜는것
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean result = true;
		
		char p = 0;
		
		while(true) {
			
			String str = br.readLine();
			if(str.equals("."))
				break;
			
			Stack<Character> stack = new Stack<>();
			for(int i=0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					stack.add(str.charAt(i));
				}else if(str.charAt(i) == ')') {
					if(!stack.isEmpty()) {
						p = stack.pop();
						if(p == '(') {
							result = true;
						}else {
							result = false;
							break;
						}
					}else {
						result = false;
						break;
					}
					
				}else if(str.charAt(i) == '[') {
					stack.add(str.charAt(i));
				}else if(str.charAt(i) == ']') {
					if(!stack.isEmpty()) {
						p = stack.pop();
						if(p == '[') {
							result = true;
						}else {
							result = false;
							break;
						}
					}else {
						result = false;
						break;
					}
				}
			}
			
			if(!stack.isEmpty() || result == false) {
				System.out.println("no");
			}else if(result == true) {
				System.out.println("yes");
			}
		}
	}
}
