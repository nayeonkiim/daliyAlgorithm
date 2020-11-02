package 연결리스트;

import 연결리스트.팰린드롬연결리스트.ListNode;

public class 두정렬리스트의병합 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	// 정렬이 아니라 하나씩 연결하는 걸로 생각함.
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			 if(l1 == null){
				 return l2;
		     }
		     if(l2 == null){
		        return l1;
		     }
		            
			ListNode head = l1.val < l2.val ? l1 : l2;
		    ListNode tail = l1.val > l2.val ? l1 : l2;
			while(head != null) {
				ListNode nextl1 = head.next;
		        ListNode nextl2 = tail.next;
		        head.next = l2;
		        tail.next = nextl1;
		        head = head.next.next;
		        tail = nextl2;
		    }
			return l1.val < l2.val ? l1 : l2;
		}
	
	public static void main(String[] args) {
		두정렬리스트의병합 two = new 두정렬리스트의병합();
		ListNode[] list1 = new ListNode[3];
		ListNode[] list2 = new ListNode[3];
		list1[0] = new ListNode(1);
		list1[1] = new ListNode(2);
		list1[2] = new ListNode(4,null);
		list1[0].next = list1[1];
		list1[1].next = list1[2];
		
		list2[0] = new ListNode(1);
		list2[1] = new ListNode(3);
		list2[2] = new ListNode(4,null);
		
		list2[0].next = list2[1];
		list2[1].next = list2[2];
		
		ListNode l1 = list1[0];
		ListNode l2 = list2[0];
		
		ListNode k = two.mergeTwoLists(l1, l2);
		while(k != null) {
			System.out.print(k.val + " ");
			k = k.next;
		}
	}
}
