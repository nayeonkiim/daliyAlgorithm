package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_S4_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[] str = br.readLine().toCharArray();
        int[] a = new int[26];
        for(int i=0; i < str.length; i++){
            a[str[i] - 'A']++;
        }

        int ans = 0;
        for(int i=0; i < N-1; i++) {
            int[] cl = a.clone();
            int count = 0;
            char[] ch = br.readLine().toCharArray();
            for(int j=0; j < ch.length; j++) {
                if (cl[ch[j] - 'A'] > 0) {
                    cl[ch[j] - 'A']--;
                    count++;
                }
            }

            if(ch.length == str.length) {
                if(count == str.length){
                    ans++;
                }else if(count == str.length-1) {
                    ans++;
                }
            //비교 대상의 길이가 더 긴 경우
            }else if(ch.length-1 == str.length){
                if(count == str.length){
                    ans++;
                }
            }else if(ch.length+1== str.length){
                if(count == str.length-1){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}