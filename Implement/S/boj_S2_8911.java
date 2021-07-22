package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj8911 {
    static int[] x = {1,0,-1,0};
    static int[] y = {0,1,0,-1};
    //F는 한눈금 앞, B는 한눈금 뒤, L은 왼쪽 90도, R은 오른쪽 회전
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int cur = 0;
        String ans = "";
        for (int i = 0; i < T; i++) {
            int curX = 0, curY = 0;
            int ansX1 = 0, ansX2 = 0, ansY1 = 0, ansY2 = 0;
            String st = br.readLine();
            for (int j = 0; j < st.length(); j++) {
                if (st.charAt(j) == 'F') {
                    //한눈금 앞- 현재 방향 중심으로
                    curX += x[cur];
                    curY += y[cur];
                } else if (st.charAt(j) == 'B') {
                    curX -= x[cur];
                    curY -= y[cur];
                } else if (st.charAt(j) == 'L') {
                    cur = cur == 0 ? 3 : cur - 1;
                } else {
                    cur = cur == 3 ? 0 : cur + 1;
                }
                ansX1 = Math.max(ansX1, curX);
                ansX2 = Math.min(ansX2, curX);
                ansY1 = Math.max(ansY1, curY);
                ansY2 = Math.min(ansY2, curY);
            }
            System.out.println(Math.abs(ansX1 - ansX2) * Math.abs(ansY1 - ansY2));
        }
    }
}
