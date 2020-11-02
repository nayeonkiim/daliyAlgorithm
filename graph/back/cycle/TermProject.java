package back.cycle;

import java.util.Scanner;

//짱 어렵,,,!!
public class TermProject {
	//입력받은 수 저장
	static int[] a = new int[100001];
	//정점 방문한 순서 저장
	static int[] d = new int[100001];
	//몇번째 탐색에 의해 방문하는 것인지 저장
	static int[] s = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int c = sc.nextInt();
			int count = c;
			for(int i=1;i<c+1;i++) {
				a[i] = sc.nextInt();
				d[i] = 0;
				s[i] = 0;
			}
			
			int ans = 0;
			for(int i=1;i<=c;i++) {
				//방문한 적이 없는 경우
				if(d[i] == 0) {
					ans += dfs(i,1,i);
				}
			}
			System.out.println(c-ans);
		}
	}

	private static int dfs(int x, int cnt, int step) {
		//이미 방문을 했는데
		if(d[x] != 0) {
			//출발한 노드와 s[i]가 동일한가? 즉 사이클 구조인가?
			if(step != s[x]) {
				return 0;
			}else {
				//맨처음(사이클의 처음 정점) d[x]
				//cnt는 총 사이클 수
				//cnt-d[x]로 사이클 안의 정점의 갯수 구함
				return cnt-d[x];
			}
		}
		d[x] = cnt;
		s[x] = step;
		return dfs(a[x],cnt+1,step);
	}

}
