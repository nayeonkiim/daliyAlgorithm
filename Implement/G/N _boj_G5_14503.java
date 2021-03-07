package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//청소하는 영역의 개수,
public class boj_G5_14503 {
    static int[][] arr;
    static boolean[][] visited;
    static int count = 0;
    static int N, M;
    static boolean flag = false;
    static int befr=0, befc=0, befd =-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);  //세로
        M = Integer.parseInt(st[1]);  //가로

        String[] way= br.readLine().split(" ");
        int r = Integer.parseInt(way[0]);   //북쪽으로 떨어져있는 만큼
        int c = Integer.parseInt(way[1]);   //서쪽으로 떨어져있는 만큼
        int d = Integer.parseInt(way[0]);   //방향(북동남서)

        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i < N; i++) {
            String[] num = br.readLine().split(" ");
            for(int j=0; j < M; j++) {
                arr[i][j] = Integer.parseInt(num[j]);
            }
        }
        robot(r,c,d);
    }

    private static void robot(int r, int c, int d) {
        //탈출 조건
        if(arr[r][c] == 1 || visited[r][c]) {
            flag = false;
            return;
        }

        //벽이 아니고 청소하지 않은 곳인 경우
        if(arr[r][c] != 1 && visited[r][c] != true) {
            visited[r][c] = true;
            isVisited(r,c,d);
            robot(r, c, d);

            if(!flag) {
                count++;
                if(count < 4) {
                    if (d == 1) {
                        d = 0;
                    } else if (d == 2) {
                        d = 1;
                    } else if (d == 3) {
                        d = 2;
                    } else if (d == 0) {
                        d = 3;
                    }
                }else{
                    flag = true;
                    back(r,c,d);
                    robot(r,c,d);
                }
            }
        }
    }

    private static void back(int r, int c, int d) {
        if (d == 0) {
            r += 1;
        } else if (d == 1) {
            c-=1;
        } else if (d == 2) {
            r -= 1;
        } else {
            c += 1;
        }
    }

    private static void isVisited(int r, int c, int d) {
        befr = r;
        befc = c;
        befd = d;

        if (d == 0) {
            c -= 1;
            d = 3;
        } else if (d == 1) {
            r -= 1;
            d -= 1;
        } else if (d == 2) {
            c += 1;
            d -= 1;
        } else {
            r += 1;
            d -= 1;
        }
    }
}
