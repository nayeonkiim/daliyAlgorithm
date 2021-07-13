package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj1946 {
    public static class Score implements Comparable<Score>{
        int a;
        int b;
        public Score(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Score o) {
            if(this.a < o.a) {
                return -1;
            }else {
                return 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int count = N;
            List<Score> lists = new ArrayList<>();
            for(int j=0; j < N; j++) {
                String[] st = br.readLine().split(" ");
                lists.add(new Score(Integer.parseInt(st[0]), Integer.parseInt(st[1])));
            }
            Collections.sort(lists);

            int cur = lists.get(0).b;
            for(int j=1; j < N; j++) {
                if(cur > lists.get(j).b) {
                    cur = lists.get(j).b;
                }else {
                    count -= 1;
                }
            }
            System.out.println(count);
        }
    }
}

//good
//서류 등수를 배열의 index로 주고 면접 등수로 비교하는 방법
/*
public class boj1946Good {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];

            for (int j=0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int rank = Integer.parseInt(st.nextToken());
                arr[rank] = Integer.parseInt(st.nextToken());
            }
            int ans = 1;
            int min = arr[1];
            for (int j = 2; j <= N; j++) {
                if(arr[j] < min) {
                    ans += 1;
                    min = arr[j];
                }
            }
            sb.append(ans);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
*/
