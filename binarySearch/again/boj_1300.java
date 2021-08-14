package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        //left와 right을 어떻게 잡느냐,,,
        //right을 k로 잡는 이유 : 답은 항상 k보다 작거나 같다.
        long left = 1, right = k;
        long ans = 0;

        while(left <= right) {
            long mid = (left+right)/2;
            long cnt = 0;

            for(int i=1; i <= N; i++) {
                cnt += Math.min(mid/i, N);
            }

            if(cnt < k)
                left = mid + 1;
            else {
                ans = mid;
                right = mid-1;
            }
        }
        System.out.println(left);
     }
}
