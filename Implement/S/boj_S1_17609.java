package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());
        for(int i=0; i < b; i++) {
            //회문이면 0,유사회문이면 1, 둘다 아니면 2
            String st = br.readLine();
            int s = 0, e = st.length()-1;
            int count = 0;
            int ans = isPalindrome(st,s,e,0);
            if(ans == 0)
                System.out.println("0");
            else if(ans == 1)
                System.out.println("1");
            else
                System.out.println("2");

        }
    }

    private static int isPalindrome(String st, int s, int e, int count) {
        if(s >= e) return count;

        if(st.charAt(s) != st.charAt(e)){
            count += 1;
            if (count <= 1)
                count = Math.min(isPalindrome(st,s+1, e, count), isPalindrome(st, s, e-1, count));
            else
                return count;

        }else {
            count = isPalindrome(st, s+1, e-1, count);
        }
        return count;
    }
}
