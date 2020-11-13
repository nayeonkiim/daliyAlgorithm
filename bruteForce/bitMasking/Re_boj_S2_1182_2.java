package bruteForce;

import java.util.Scanner;

public class Re_boj_S2_1182_2 {
	//집합의 부분집합을 구할때 비트마스크는 유용
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int ans = 0;
		// 1<<n 은  2^n/ 1<<5, 100000 = 2^5
		//정수 0부터 2^N - 1까지 반복문, 그 안에 원소의 개수(N)개만큼 도는 반복문.
		for(int i=1; i <(1<<n); i++) {
			int sum = 0;
			for(int k=0; k < n; k++) {
				//&는 두 비트 모두 1인 경우
				//반복문 두개의 인덱스를 AND연산하면 부분집합 구할 수 있음
				if((i&(1<<k)) != 0) {
					//System.out.println("i, k : "+i+" "+k);
					sum+=a[k];
				}
			}
			if(sum == s) {
				ans += 1;
			}
		}
		System.out.println(ans);
	}
}
