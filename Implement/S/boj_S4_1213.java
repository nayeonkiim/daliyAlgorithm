package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_S4_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int leng = str.length();
        String[] s = str.split("");

        Arrays.sort(s);
        String[] ans = new String[leng];
        int start =0, end = leng-1, count = 0;
        boolean flag = false;
        if(leng == 2){
            if(s[0].equals(s[1])){
                System.out.print(s[0]+s[1]);
                return;
            }else{
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        for(int i=0; i < leng-1; i++) {
            if(!s[i].equals(s[i+1])){
                count++;
                continue;
            }else{
                ans[start] = s[i];
                ans[end] = s[i+1];
                s[i] = "";
                s[i+1] = "";
                i++;
                start +=1;
                end-=1;
            }

            if(leng%2 != 0 && count > 1) {
                flag = true;
                break;
            }
            else if(leng%2 == 0 && count > 0) {
                flag = true;
                break;
            }
        }
        if(leng%2 != 0 && count > 1) {
            flag = true;
        }
        else if(leng%2 == 0 && count > 0) {
            flag = true;
        }

        if(flag) {
            System.out.println("I'm Sorry Hansoo");
        }else{
            for(int i=0; i < leng; i++){
                if(!s[i].equals("")) {
                    ans[leng / 2] = s[i];
                }
            }
            for(int i=0; i < leng; i++) {
                System.out.print(ans[i]);
            }
        }
    }
}
