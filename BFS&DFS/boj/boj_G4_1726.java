package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//key : 1칸이나 2칸 뒤가 0이 아니면 3번째 칸이 0일 경우에도 못간다.

class Cur {
    int x;
    int y;
    int dir;
    int count = 0;
    public Cur(int x, int y, int dir, int count) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.count = count;
    }
}

public class boj1726 {
    static int[][] arr;
    static Cur fin;
    static int[] moveX = {0,0,1,-1};
    static int[] moveY = {1,-1,0,0};
    static int M,N;
    static int ans=0;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        arr = new int[M+1][N+1];
        visited = new boolean[M+1][N+1][5];
        for(int i=1; i <= M; i++) {
            String[] st = br.readLine().split(" ");
            for(int j=1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st[j-1]);
            }
        }
        //출발 위치, 바라보는 방향
        //동1,서2,남3,북4
        String[] s = br.readLine().split(" ");
        Cur cur = new Cur(Integer.parseInt(s[0]), Integer.parseInt(s[1]),Integer.parseInt(s[2]), 0);

        s = br.readLine().split(" ");
        fin = new Cur(Integer.parseInt(s[0]), Integer.parseInt(s[1]),Integer.parseInt(s[2]), 0);
        bfs(cur);
        System.out.println(ans);

    }

    private static void bfs(Cur cur) {
        Queue<Cur> que = new LinkedList<>();
        que.add(cur);

        while(!que.isEmpty()) {
            Cur poll = que.poll();
            if(poll.x == fin.x && poll.y == fin.y && poll.dir == fin.dir) {
                ans = poll.count;
                break;
            }

            //자신의 현재 dir에 따라 이동
            for(int i=1; i<=4; i++) {
                if(poll.dir == i) {
                    for(int k=1; k <= 3; k++) {
                        int nextX = poll.x + moveX[i-1]*k;
                        int nextY = poll.y + moveY[i-1]*k;
                        if (nextX > 0 && nextX <= M && nextY > 0 && nextY <= N && arr[nextX][nextY] == 0) {
                            if (!visited[nextX][nextY][poll.dir]) {
                                visited[nextX][nextY][poll.dir] = true;
                                que.add(new Cur(nextX, nextY, poll.dir, poll.count + 1));
                            }
                        }
                        else if(nextX > 0 && nextX <= M && nextY > 0 && nextY <= N && arr[nextX][nextY] != 0) break;
                    }
                    break;
                }
            }

            //방향 변경
            int[] nextDir = new int[2];
            nextDir[0] = poll.dir == 1 || poll.dir == 2 ? 3 : 1;
            nextDir[1] = poll.dir == 1 || poll.dir == 2 ? 4 : 2;

            if(!visited[poll.x][poll.y][nextDir[0]]) {
                visited[poll.x][poll.y][nextDir[0]] = true;
                que.add(new Cur(poll.x, poll.y,nextDir[0], poll.count+1));
            }
            if(!visited[poll.x][poll.y][nextDir[1]]) {
                visited[poll.x][poll.y][nextDir[1]] = true;
                que.add(new Cur(poll.x, poll.y, nextDir[1], poll.count + 1));
            }
        }
    }
}
