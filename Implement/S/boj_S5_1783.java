package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//병든 나이트의 이동횟수가 4번보다 적지 않다면, 이동 방법을 모두 한번씩 사용해야 한다.
//이동횟수가 4번보다 적은 경우에는 이동방법에 대한 제약이 없다.
public class boj_S5_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        long n = Long.parseLong(str[0]);  //세로길이
        long m = Long.parseLong(str[1]);  //가로길이

        long ans = 0;
        if(n == 1) ans = 1;
        else if(n == 2) ans = Math.min((m+1)/2, 4);
        else if(m < 7) {
            ans = Math.min(m, 4);
        }else {
            ans = 4 + (m-7) + 1;
        }
        System.out.println(ans);
    }
}
