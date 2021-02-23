package S;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_S2_2504 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();

        boolean flag = true;
        int ans = 0, ope = 1;
        Stack<Character> st = new Stack<>();
        for(int i=0; i < ch.length; i++) {
            if(ch[i]=='(') {
                st.add('(');
                ope *= 2;
            }else if(ch[i] == '[') {
                st.add('[');
                ope *= 3;
            }else if(ch[i] == ')') {
                if(st.isEmpty() || st.peek() != '(') {
                    System.out.println("0");
                    flag = false;
                    break;
                }

                if(ch[i-1] == '(') {
                    ans += ope;
                }
                ope /= 2;
                st.pop();

            }else if(ch[i] == ']') {
                if(st.isEmpty() || st.peek() != '[') {
                    System.out.println("0");
                    flag = false;
                    break;
                }

                if(ch[i-1] == '[') {
                    ans += ope;
                }
                ope /= 3;
                st.pop();
            }
        }

        if(flag && st.isEmpty()) {
            System.out.println(ans);
        }else if(flag && !st.isEmpty()) {
            System.out.println("0");
        }
    }
}

