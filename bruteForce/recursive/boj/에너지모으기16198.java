package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 에너지모으기16198 {
	public static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split(" ");
		ArrayList<Integer> a = new ArrayList<>();
		for(int i=0; i < N; i++) {
			a.add(Integer.parseInt(str[i]));
		}
		
		int maxx = 0;
		System.out.println(go(a));
	}

	private static int go(ArrayList<Integer> a) {
		
		if(a.size() == 2) {
			return 0;
		}
		int ans = 0;
		for(int i=1; i < a.size()-1; i++) {
			int add = a.get(i-1) * a.get(i+1);
			ArrayList<Integer> b = new ArrayList<>(a);
			b.remove(i);
			add += go(b);
			if(ans < add) {
				ans = add;
			}
		}
		return ans;
	}
}
