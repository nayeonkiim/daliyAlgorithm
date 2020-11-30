package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 로또6603 {
	public static ArrayList<Integer> list = new ArrayList<Integer>(); 
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] str = br.readLine().split(" ");
			
			if(str[0].equals("0"))
				break;
			
			int n = Integer.parseInt(str[0]);
			int[] a = new int[n];
			for(int i=0; i <a.length; i++) {
				a[i] =  Integer.parseInt(str[i+1]);
			}
			
			go(a,0,0);
			System.out.println();
		}
	}

	private static void go(int[] a, int index, int cnt) {
		if(cnt == 6) {
			for(int i=0; i < 6; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		int b = a.length;
		if(index == b) {
			return;
		}
		
		list.add(a[index]);
		go(a,index+1,cnt+1);
		
		list.remove(list.size()-1);
		go(a,index+1,cnt);
	}
}