package week12;

import java.util.Arrays;

public class pg_49191 {
    public static int[][] graph;
    public static int INF = (int)1e9;
    public static int solution(int n, int[][] results) {
        int answer = 0;
        graph = new int[n+1][n+1];

        for(int i=1; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }
        for(int i=1; i <= n; i++){
            graph[i][i] = 0;
        }

        for(int i=0; i < results.length; i++){
            graph[results[i][0]][results[i][1]] = 1;
        }

        for(int k=1; k <= n; k++) {
            for(int i=1; i <= n; i++){
                for(int j=1; j <= n; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }

        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);
        for(int i=0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                //모든 노드에 대해서 승패를 알 수 있어야 순위를 정할 수 있다.
                //하나의 노드라도 연결이 되어 있지 않으면 순위를 정할 수 없다.
                if(i==j) continue;
                if(graph[i][j] == INF && graph[j][i] == INF) {
                    flag[i] = false;
                    break;
                }
            }
        }

        //순위를 정할 수 없는 flag는 false이므로 true인 flag만 answer++ 해준다.
        for(int i=1; i < flag.length; i++) {
            if(flag[i]) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
        System.out.println(solution(n,results));
    }
}
