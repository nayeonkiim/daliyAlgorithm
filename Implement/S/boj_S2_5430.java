package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 입력으로 들어오는 배열의 갯수가 0일때가 있기 때문에 split(,)으로 하면 안된다.
 */

public class boj_S2_5430 {
    //두가지 함수 R(뒤집기)과 D(버리기)가 있다.
    //R은 배열에 있는 숫자의 순서를 뒤집는 함수, D는 첫번째 숫자를 버리는 함수.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i < T; i++) {
            String p = br.readLine();  //RDD
            int n = Integer.parseInt(br.readLine());  //배열의 갯수
            String str = br.readLine();  //배열 [1,2,3,4] - 배열안의 수는 100까지
            String newStr = str.substring(1,str.length()-1);
            String[] s;
            if(newStr.length() != 0)
                s = newStr.split(",");
            else
                s = new String[0];


            int start = 0, end = s.length;
            boolean flag = true, err = false;
            for(int j=0; j < p.length(); j++) {
                //true이면 앞부터, false이면 뒤부터
                if(p.charAt(j) == 'R'){
                    int temp = end;
                    end = start;
                    start = temp;
                    flag = !flag;
                }else if(p.charAt(j) == 'D') {
                    //입력 배열의 길이가 0이면 error
                    if(s.length == 0 || n == 0){
                        System.out.println("error");
                        err = true;
                        break;
                    }

                    if(flag) {
                        if(start+1 <= end)
                            start += 1;
                        else{
                            System.out.println("error");
                            err = true;
                            break;
                        }
                    }else {
                        if(start-1 >= end)
                            start -= 1;
                        else{
                            System.out.println("error");
                            err = true;
                            break;
                        }
                    }
                }
            }

            //err 가 아닌 경우에만 답이 될 수 있다.
            if(!err && flag) {
                System.out.print("[");
                for(int j=start; j < end; j++) {
                    if(j != end-1)
                        System.out.print(s[j] +",");
                    else
                        System.out.print(s[j]);
                }
                System.out.println("]");
            }
            if(!err && !flag){
                System.out.print("[");
                for(int j=start-1; j >= end; j--) {
                    if(j != end)
                        System.out.print(s[j] + ",");
                    else
                        System.out.print(s[j]);
                }
                System.out.println("]");
            }
        }
    }
}

