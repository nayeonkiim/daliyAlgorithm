package StringProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class boj_S4_4949 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
				String str = br.readLine();
				if(str.equals(".")) {
					break;
				}
				
				char p = 0;
				boolean result = true;
				Stack<Character> st = new Stack<>();
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i) == '(') {
						st.add('(');
					}else if(str.charAt(i) == ')') {
						if(!st.isEmpty())
							p = st.pop();
						else {
							result = false;
							break;
						}
						
						if(p != '(') {
							result = false;
							break;
						}
					}else if(str.charAt(i) == '[') {
						st.add('[');
					}else if(str.charAt(i) == ']') {
						if(!st.isEmpty())
							p = st.pop();
						else {
							result = false;
							break;
						}
						
						if(p != '[') {
							result = false;
							break;
						}
					}
				}
				if(result && st.isEmpty())
					System.out.println("yes");
				else {
					System.out.println("no");
				}

		}
	}

}

