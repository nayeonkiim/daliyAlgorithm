package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_S5_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        for(int i=0; i < N; i++) {
            String str = br.readLine();
            int[] arr = new int[1000];
            arr[str.charAt(0)-'0'] = 1;
            boolean flag = false;
            for(int j=1; j < str.length(); j++) {
                 if(str.charAt(j-1) != str.charAt(j) && arr[str.charAt(j)-'0'] != 0){
                     flag = true;
                     break;
                 }else {
                     arr[str.charAt(j)-'0'] += 1;
                 }
            }
            if(!flag){
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}
