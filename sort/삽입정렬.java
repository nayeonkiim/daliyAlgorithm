package week6;

public class 삽입정렬 {

	public static void main(String[] args) {
		
		int n = 10;
		int[] arr = {7,5,9,0,3,1,6,2,4,8};
		
		for(int i=1; i < n; i++) {
			for(int j= i; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				//자기보다 작은 데이터 만나면 그 위치에서 멈춤.
				//자기의 앞부분은 이미 정렬된 상태.
				else break;
			}
		}
		
		for(int i=0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
