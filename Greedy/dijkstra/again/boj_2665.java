package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//유사 문제 : 벽 부수고 이동하기, 알고스팟
public class boj_2665 {
    //해당 인덱스로 가기 위해 최소로 만나게 될 벽의 갯수 -> d
    static int[][] d;
    static int[][] arr;
    static int[] nextX = {-1,0,1,0};
    static int[] nextY = {0,1,0,-1};
    static final int INF = (int)1e9;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n+1][n+1];
        arr = new int[n+1][n+1];
        for(int i=1; i <= n; i++) {
            String[] str = br.readLine().split("");
            for(int j=1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(str[j-1]);
                d[i][j] = INF;
            }
        }

        bfs();
        System.out.println(d[n][n]);
    }

    private static void bfs() {
        Queue<Point> pq = new LinkedList<>();
        pq.add(new Point(1,1));
        d[1][1] = 0;

        while(!pq.isEmpty()) {
            Point poll = pq.poll();
            int x = poll.x;
            int y = poll.y;

            for(int i=0; i < 4; i++) {
                int x2 = x + nextX[i];
                int y2 = y + nextY[i];
                if(x2 > 0 && y2 > 0 && x2 <= n && y2 <= n && d[x2][y2] > d[x][y]) {
                    if(arr[x2][y2] == 1) {
                        d[x2][y2] = d[x][y];
                        pq.add(new Point(x2,y2));
                    }else {
                        d[x2][y2] = d[x][y] + 1;
                        pq.add(new Point(x2, y2));
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
