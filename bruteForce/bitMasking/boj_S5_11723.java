package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_S5_11723 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		int S = 0, N = 20;
		for(int i=0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			//원소 추가
			if(str[0].equals("add")) {
				S = (S | (1 << Integer.parseInt(str[1])-1));
			//원소 제거
			}else if(str[0].equals("remove")) {
				S = (S & ~(1 << Integer.parseInt(str[1])-1));
			//원소 존재 유무 체크
			}else if(str[0].equals("check")) {
				int res = (S & (1 << Integer.parseInt(str[1])-1));
				if(res != 0) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
			//있으면 제거, 없으면 추가
			}else if(str[0].equals("toggle")) {
				S = (S ^ (1 << Integer.parseInt(str[1])-1));
			//집합으로 변경
			}else if(str[0].equals("all")) {
				S = (1 << N)-1;
			//공집합으로 변경
			}else if(str[0].equals("empty")) {
				S = 0;
			}
		}
	}
}
