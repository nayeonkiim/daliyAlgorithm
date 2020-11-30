package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Re부분수열의합14225 {
	static int[] num = new int[2000010];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		String[] str = br.readLine().split(" ");
		for(int i=0; i < N; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(a);
		go(a,0,0);
		
		for(int i=1; i < num.length; i++) {
			if(num[i] == 0) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void go(int[] a, int index, int total) {
		if(index == a.length) {
			num[total]++;
			return;
		}
		
		//a[index] 포함하는 경우
		go(a,index+1,total+a[index]);
		//a[index] 포함 안하는 경우
		go(a,index+1,total);
	}
}
