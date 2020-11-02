package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 크레인인형뽑기게임 {
	
    public int solution(int[][] board, int[] moves) {
        int answer = 0, i =0;
        int[] ans = new int[moves.length];
        for(int m : moves) {
        	for(int j=0;j<board.length;j++) {
        		if(board[j][m-1] == 0) {
            		continue;
            	}
        		
            	if(i != 0 && ans[i-1] == board[j][m-1]) {
            		ans[i-1] = 0;
            		board[j][m-1] = 0;
            		answer +=2;
            		i--;
            		for(int k=0;k<ans.length;k++) {
            			System.out.println("ans[k],i : "+ans[k]+","+i);
            		}
            		System.out.println("answer: "+answer);
            		break;
            	}
            	ans[i] = board[j][m-1];
            	i++;
                board[j][m-1] = 0;
                for(int k=0;k<ans.length;k++) {
        			System.out.println("ans[k],i : "+ans[k]+","+ i);
        		}
                System.out.println("answer: "+answer);
            	break;
        	}
        }
        return answer;
    }
	
    //스택이용
    public int solution2(int[][] board, int[] moves) {
    	 int answer = 0;
    	 return answer;
    }
    
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},
				{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		크레인인형뽑기게임 ke = new 크레인인형뽑기게임();
		System.out.print(ke.solution(board, moves));
	}

}
