package permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 모든순열 {
	
	public static boolean next_permutation(int[] a) {
		 int i = a.length-1;
	     while (i > 0 && a[i-1] >= a[i]) {
	    	 i-= 1;
	     }

	     if (i <= 0) {
	    	 return false;
	     }

	    int j = a.length-1;
	    while (a[j] <= a[i-1]) {
	       j -= 1;
	    }

	    int temp = a[i-1];
	    a[i-1] = a[j];
	    a[j] = temp;

	    j = a.length-1;
	    while (i < j) {
	    	temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	        i += 1;
	        j -= 1;
	    }
	    
        return true;
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		
		int[] a = new int[N]; 
		for(int i=0; i < N; i++) {
			a[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(a);
		do {
			for(int i=0; i < N; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}while(next_permutation(a));
	}
}
