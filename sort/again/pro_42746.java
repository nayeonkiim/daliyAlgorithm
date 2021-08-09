package sort;

import java.util.Arrays;
import java.util.Comparator;

public class 수찾기 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];

        for(int i=0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //compareTo는 string 간의 사전적 비교를 위해 사용된다.
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(str[0].equals("0")) return "0";

        for(String s : str) answer += s;
        return answer;
    }
}