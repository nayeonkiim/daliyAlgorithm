package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_S5_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] name = new String[n];
        int[] dd = new int[n];
        int[] mm = new int[n];
        int[] yy = new int[n];

        int max = Integer.MAX_VALUE, idx= 0, min = Integer.MIN_VALUE;
        int idxMin = 0;
        for(int i=0; i < n; i++){
            String[] str = br.readLine().split(" ");
            name[i] = str[0];
            dd[i] = Integer.parseInt(str[1]);
            mm[i] = Integer.parseInt(str[2]);
            yy[i] = Integer.parseInt(str[3]);
            if(max > yy[i]) {
                max = yy[i];
                idx = i;
            }
            if(min < yy[i]) {
                min = yy[i];
                idxMin = i;
            }
        }

        int bir= mm[idx], birIdx = idx, biry = dd[idx];
        for(int i=idx+1; i < n; i++) {
            if (yy[idx] == yy[i] && bir > mm[i]) {
                bir = mm[i];
                biry = dd[i];
                birIdx = i;
            }else if(yy[idx] == yy[i] && bir == mm[i]) {
                if(biry > dd[i]) {
                    bir = mm[i];
                    biry = dd[i];
                    birIdx = i;
                }
            }
        }

        int birMin= mm[idxMin], birMinIdx = idxMin, biryMin = dd[idxMin];
        for(int i=idxMin+1; i < n; i++) {
            if (yy[idxMin] == yy[i] && birMin < mm[i]) {
                birMin = mm[i];
                biryMin = dd[i];
                birMinIdx = i;
            }else if(yy[idxMin] == yy[i] && birMin == mm[i]) {
                if(biryMin < dd[i]) {
                    birMin = mm[i];
                    biryMin = dd[i];
                    birMinIdx = i;
                }
            }
        }
        System.out.println(name[birMinIdx]);
        System.out.println(name[birIdx]);
    }
}
