package programmers;

public class 비밀지도 {
	
	// 이진수로 변경 (toBinaryString)
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		for(int i=0;i<n;i++) {
			answer[i] = "";
			String ar1 = Integer.toBinaryString(arr1[i]);
			String ar2 = Integer.toBinaryString(arr2[i]);
			if(ar1.length() != n) {
				int p = ar1.length();
				for(int k=0;k<n-p;k++) {
					ar1 = '0'+ar1;
				}
			}
			if(ar2.length() != n) {
				int p = ar2.length();
				for(int k=0;k<n-p;k++) {
					ar2 = '0'+ar2;
				}
			}
			
			for(int j=0;j<n;j++) {
				if(ar1.charAt(j) == '1' || ar2.charAt(j) == '1') {
					answer[i] += "#";
				}else {
					answer[i] += ' ';
				}
			}
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		int n=5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		비밀지도 bi = new 비밀지도();
		String[] sol = bi.solution(n, arr1, arr2);
		
		for(int i=0;i<sol.length;i++) {
			System.out.println(sol[i]);
		}
	}

}
