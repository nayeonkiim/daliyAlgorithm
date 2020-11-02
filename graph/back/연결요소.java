package back;

//https://www.acmicpc.net/problem/11724

import java.util.ArrayList;
import java.util.Scanner;

public class 연결요소 {
	//정점의 갯수
	static int n;
	//간선의 갯수
	static int m;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n+1;i++) {
			arr.add(new ArrayList<>());
		}
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		for(int i=0;i<arr.size();i++)
		{
			System.out.print(i+": ");
			for(int j=0;j<arr.get(i).size();j++) {
				System.out.print(arr.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
		int count =0;
		boolean[] flag = new boolean[n+1];
		//n은 정점의 갯수
		for(int i=1;i<n+1;i++) {
			if(flag[i] == false) {
				dfs(arr,flag,i);
				count++;
			}
		}
		System.out.print(count);
	}

	private static void dfs(ArrayList<ArrayList<Integer>> arr, boolean[] b, int i) {
		if(b[i]) {
			return;
		}
		b[i] = true;
		for(Object k : arr.get(i)) {
			if(b[(int) k] == false) {
				dfs(arr,b,(int)k);
			}
		}
	}
}
