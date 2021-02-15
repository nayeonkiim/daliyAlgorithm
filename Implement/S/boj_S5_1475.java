package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_S5_1475 {
    //0부터 9번까지 숫자가 하나씩 있다. 6을 뒤집어서 9로 사용가능하다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] con = new int[10];

        for(int i=0; i < N.length(); i++){
            con[N.charAt(i)-'0']+=1;
        }

        int max = 0;
        for(int i=0; i < 10; i++){
            if(i != 6 && i != 9 && max < con[i]){
                max = con[i];
            }
        }
        int com = (con[6]+con[9])%2 == 0 ? (con[6]+con[9])/2 : (con[6]+con[9])/2+1;
        int ans = Math.max(com, max);
        System.out.println(ans);
    }
}
