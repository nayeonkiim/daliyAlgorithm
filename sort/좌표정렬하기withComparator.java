package week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*https://www.acmicpc.net/problem/11650*/

public class 좌표정렬하기withComparator {
	public static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<Point>();
		
		for(int i=0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Point(a,b));
		}
		
		Collections.sort(list, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x < o2.x) {
					return -1;
				}else if(o1.x == o2.x) {
					if(o1.y < o2.y) {
						return -1;
					}else if(o1.y == o2.y) {
						return 0;
					}else {
						return 1;
					}
				}else {
					return 1;
				}
			}
			
		});
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i < list.size(); i++) {
			bw.write(list.get(i).x +" " + list.get(i).y + "\n");
		}
		bw.flush();
	}

}
