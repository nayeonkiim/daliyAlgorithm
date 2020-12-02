package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*https://www.acmicpc.net/problem/11650*/
public class 좌표정렬하기withComparable {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] a = new Point[n];
		for(int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			a[i] = new Point(x,y);
		}
		
		Arrays.sort(a);
		StringBuilder sb = new StringBuilder();
		for(Point p : a) {
			sb.append(p.x + " " + p.y + "\n");
		}
		System.out.print(sb);
	}
}

class Point implements Comparable<Point>{
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point that) {
		if(this.x < that.x) {
			//this가 that보다 앞에 있는 경우 -1
			return -1;
		}else if(this.x == that.x){
			if(this.y < that.y) {
				return -1;
			}else if(this.y == that.y) {
				//this와 that이 동일한 위치 0
				return 0;
			}else {
				return 1;
			}
		//that이 this보다 앞에 있는 경우 1
		}else {
			return 1;
		}
	}
}


