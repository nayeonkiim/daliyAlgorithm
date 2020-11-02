package week1;

import java.util.Arrays;

public class 더좋은풀이들 {
	
	// 최대공약수 최소공배수
//	public int[] gcdlcm(int a, int b) {
//		
//		int[] answer = new int[2];
//		int mini = 0;
//		int maxi = 1;
//		
//		for(int i=1;i<a;i++) {
//			if(a%i ==0 && b%i == 0) {
//				maxi = i;
//			}
//		}
//		
//		for(int i = a*b; i>0; i--) {
//			if(i%a == 0 && i%b == 0) {
//				mini = i;
//			}
//		}
//		answer[0] = maxi;
//		answer[1] = mini;
//		
//		return answer;
//		
//	}
	
	//문자열다루기기본
//	public boolean solution(String s) {
//	     int length = s.length();
//	        if (length != 4 && length != 6)
//	            return false;
//	        for (int i = 0; i < length; ++i) {
//	            char c = s.charAt(i);
//	            if (c < '0' || c > '9')
//	                return false;
//	        }
//	        return true;
//	  }
//	 public static void main(String[] args) {
//		 	String s = "a234";
//		 	더좋은풀이들 c = new 더좋은풀이들();
//	        System.out.print(c.solution(s));
//	 }
}
