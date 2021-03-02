package S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

//배열에서 절댓값이 가장 작은 값을 출력
public class boj_S1_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int tempO1 = o1;
                int tempO2 = o2;
                if(o1 < 0) {
                    tempO1 *= -1;
                }
                if(o2 < 0){
                    tempO2 *= -1;
                }
                if(tempO1 < tempO2) {
                    return -1;
                }else if(tempO1 > tempO2) {
                    return 1;
                }else{
                    if(o1 > o2) {
                        return 1;
                    }else {
                        return -1;
                    }
                }
            }
        });

        for(int i=0; i < x; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a != 0) {
                pq.add(a);
            }else {
                if (pq.isEmpty()) {
                    System.out.println("0");
                }else {
                    System.out.println(pq.poll());
                }
            }
        }
    }
}
