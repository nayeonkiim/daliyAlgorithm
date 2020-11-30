package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re부분수열의합1182 {
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		String[] str = br.readLine().split(" ");
		int[] a = new int[N];
		for(int i=0; i < N; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		
		go(a,0,0,S);
		//S가 0이면 모두 포함안하는 공집합 발생.
		if(S == 0)
			ans-=1;
		
		System.out.println(ans);
	}

	private static void go(int[] a, int index, int total, int s) {
		if(index == a.length) {
			if(total == s) {
				ans+=1;
				return;
			}else {
				return;
			}
		}
		
		//a[index]를 포함
		go(a,index+1,total+a[index],s);
		//a[index]를 포함하지 않음
		go(a,index+1,total,s);
	}
}
	