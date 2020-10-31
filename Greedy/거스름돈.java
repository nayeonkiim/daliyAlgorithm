package Greedy;

public class 거스름돈 {
	
	public static void main(String args[]) {
		
		int[] change = { 500, 100, 50, 10, 1};
		
		int N = 2045;
		
		int count = 0;
		for(int i=0; i < change.length; i++) {
			if(N > change[i]) {
				count += N / change[i];
				N %= change[i];
			}
		}
		System.out.println(count);
	}
}
