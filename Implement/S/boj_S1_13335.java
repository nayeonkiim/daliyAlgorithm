package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_S1_13335 {
    //n개의 트럭이 다리를 지나간다. 다리의 길이는 w 단위길이이며, 하나의 단위시간에 하나의 단위길이만큼 이동이 가능
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int t_count = Integer.parseInt(str[0]);  //트럭수
        int b_leng = Integer.parseInt(str[1]); //다리의 길이
        int b_weight = Integer.parseInt(str[2]);  //다리의 최대하중

        int[] arr = new int[t_count];
        String[] truck = br.readLine().split(" ");
        for(int i=0; i < t_count; i++) {
            arr[i] = Integer.parseInt(truck[i]);
        }

        ArrayList<Integer> bridge = new ArrayList<>();
        int sum = 0, count = 0;
        for(int i=0; i < t_count; i++) {
            if(bridge.size() >= b_leng) {
                int re= bridge.remove(0);
                sum -= re;
            }

            if(sum + arr[i] <= b_weight) {
                bridge.add(arr[i]);
                sum += arr[i];
            }else {
                bridge.add(0);
                i--;
            }
            count++;
        }

        count += b_leng;
        System.out.println(count);
    }
}
