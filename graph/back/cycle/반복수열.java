package back.cycle;

import java.util.Scanner;

//수열을 계속 진행하다가 만나게 되는 수열 중 반복하지 않는 부분의 갯수 리턴
public class 반복수열 {
	public static int[] check = new int[100000];
	
	public static int pow(int x, int p) {
		int ans = 1;
		for(int i=0;i<p;i++) {
			ans = ans * x;
		}
		return ans;
	}
	
	public static int next(int a,int p) {
		int ans = 0;
		while(a > 0) {
			ans += pow(a%10, p);
			a/=10;
		}
		return ans;
	}
	
	public static int length(int a, int p, int cnt) {
		//이미 방문을 한 경우
		if(check[a] != 0) {
			return check[a]-1;
		}
		check[a] = cnt;
		int b = next(a,p); //74
		return length(b,p,cnt+1);
	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int p = sc.nextInt();
		System.out.println(length(a,p,1));
	}
	
}
