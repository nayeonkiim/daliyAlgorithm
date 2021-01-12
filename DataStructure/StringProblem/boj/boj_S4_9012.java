package StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_S4_9012 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i < N; i++) {
			String str = br.readLine();
			
			String ans = "YES";
			Stack<Character> stack = new Stack<>();
			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == '(') {
					stack.add(str.charAt(j));
				}else if(str.charAt(j) == ')') {
					if(!stack.isEmpty()) {
						char p = stack.pop();
						if(p != '(') {
							ans = "NO";
							break;
						}
					}else {
						ans = "NO";
						break;
					}
				}
			}
			
			if(stack.isEmpty() && ans.equals("YES")){
				System.out.println("YES");
					
			}else if (!stack.isEmpty() || ans.equals("NO")) {
				System.out.println("NO");
			}
		}
	}

}
