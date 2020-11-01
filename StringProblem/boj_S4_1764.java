package StringProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_S4_1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String,Integer> map = new HashMap<>();
		
		for(int i = 0; i < N+M; i++) {
			String input = br.readLine();
			if(map.get(input) == null) {
				map.put(input, 0);
			}
			map.put(input, map.get(input)+1);
		}
		
		int k = 0;
		for(String keys: map.keySet()) {
			if(map.get(keys) > 1) {
				k++;
			}
		}
		
		String[] notLis = new String[k];
		k = 0;
		for(String keys: map.keySet()) {
			if(map.get(keys) > 1 && k < notLis.length) {
				notLis[k++] = keys;
			}
		}
		
		Arrays.sort(notLis);
			
		System.out.println(k);
		for(int i=0;i<k;i++)
			System.out.println(notLis[i]);
	}

}
