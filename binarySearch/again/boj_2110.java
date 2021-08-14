package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int C = Integer.parseInt(str[1]);

        int[] arr = new int[N];
        for(int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N-1] - arr[0];

        int ans = 0;
        while(left <= right) {
            int mid = (left+right)/2;
            int start = arr[0];
            int count = 1;
            for(int i=0; i < N; i++) {
                int ch = arr[i] - start;
                if(ch >= mid) {
                    count++;
                    start = arr[i];
                }
            }

            if(count >= C) {
                ans = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        System.out.println(ans);
    }
}
