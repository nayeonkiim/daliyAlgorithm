package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_S5_2477 {
    static class Com {
        int num;
        int leng;
        Com(int num, int leng) {
            this.num = num;
            this.leng = leng;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        ArrayList<Com> list = new ArrayList<>();
        int[] a = new int[5];
        for(int i=0; i < 6; i++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            if(a[n] == 0){
                a[n] = m;
            }else {
                a[n] = 0;
            }
            list.add(new Com(n,m));
        }

        int ans = 1;
        for(int i=0; i < 5; i++) {
            if (a[i] != 0) {
                ans *= a[i];
            }
        }

        for(int i=0; i < 6; i++){
            if(i == 5){
                if (list.get(5).num == 1 && list.get(0).num == 3) {
                    ans -= list.get(5).leng * list.get(0).leng;
                    break;
                } else if (list.get(5).num == 4 && list.get(0).num == 1) {
                    ans -= list.get(5).leng * list.get(0).leng;
                    break;
                } else if (list.get(5).num == 2 && list.get(0).num == 4) {
                    ans -= list.get(5).leng * list.get(0).leng;
                    break;
                } else if (list.get(5).num == 3 && list.get(0).num == 2) {
                    ans -= list.get(5).leng * list.get(0).leng;
                    break;
                }
            }else {
                if (list.get(i).num == 1 && list.get(i + 1).num == 3) {
                    ans -= list.get(i).leng * list.get(i+1).leng;
                    break;
                } else if (list.get(i).num == 4 && list.get(i + 1).num == 1) {
                    ans -= list.get(i).leng * list.get(i+1).leng;
                    break;
                } else if (list.get(i).num == 2 && list.get(i + 1).num == 4) {
                    ans -= list.get(i).leng * list.get(i+1).leng;
                    break;
                } else if (list.get(i).num == 3 && list.get(i + 1).num == 2) {
                    ans -= list.get(i).leng * list.get(i+1).leng;
                    break;
                }
            }
        }
        System.out.println(ans*T);
    }
}