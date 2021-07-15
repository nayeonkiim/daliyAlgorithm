package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split("-");

        int sum = 0;
        for(int i=0; i < st.length; i++) {
            int cur = 0, ssum = 0;
            for(int j=0; j < st[i].length(); j++) {
                if(!isNumber(st, i, j)) {
                    ssum += Integer.parseInt(st[i].substring(cur, j));
                    cur = j+1;
                }
            }

           ssum += Integer.parseInt(st[i].substring(cur));
            
            if(i == 0){
                sum += ssum;
            }else{
                sum -= ssum;
            }
        }
        System.out.println(sum);
    }

    private static boolean isNumber(String[] st, int i, int j) {
        if(st[i].charAt(j) - '0' >= 0 && st[i].charAt(j) - '0' < 10) {
            return true;
        }else{
            return false;
        }
    }
}
//괄호를 하나 치는게 아니라 적절히 쳐서 최솟값
//즉, +일 경우까지 쭉 묶어서 - 붙여 계산하는게 최솟값이 된다.