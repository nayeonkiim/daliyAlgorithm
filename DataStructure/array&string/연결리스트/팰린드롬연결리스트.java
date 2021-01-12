package 연결리스트;

import java.util.LinkedList;


public class 팰린드롬연결리스트 {

	 public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	 public static boolean isPalindrome(ListNode head) {
		 int leng = 0, i = 0;
		 boolean answer = true;
		 ListNode h = head;
		 while(head != null) {
			 leng += 1;
			 head = head.next;
		 }
		 int[] re = new int[leng];
		 while(h != null) {
			 re[i] = h.val;
			 h = h.next;
			 i++;
		 }
		 for(int j=0;j<re.length/2;j++) {
			 if(re[j] == re[re.length-j-1]) {
				 answer = true;
			 }else {
				 answer = false;
				 return answer;
			 }
		 }
		 return answer;
	 }
	 
	 public static void main(String[] args) {
		 팰린드롬연결리스트 palin = new 팰린드롬연결리스트();
		 ListNode[] node = new ListNode[4];
		 node[0] = new ListNode(1);
		 node[1] = new ListNode(2);
		 node[2] = new ListNode(2);
		 node[3] = new ListNode(1,null);
		 node[0].next = node[1];
		 node[1].next = node[2];
		 node[2].next = node[3];
		 ListNode head = node[0];
		 System.out.print(palin.isPalindrome(head));
	 }
}