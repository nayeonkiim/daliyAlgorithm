package StringProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class boj_S4_11656 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		List<String> arr = new ArrayList<>();
		for(int i=0; i < str.length(); i++) {
			arr.add(str.substring(i,str.length()));
		}
		
		Collections.sort(arr);
		
		for(String st : arr) {
			System.out.println(st);
		}
	}
}
