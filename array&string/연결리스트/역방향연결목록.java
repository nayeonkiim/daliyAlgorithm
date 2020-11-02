package 연결리스트;

public class 역방향연결목록 {
	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode[] arrList = new ListNode[5];
		arrList[0] = new ListNode(1);
		arrList[1] = new ListNode(2);
		arrList[2] = new ListNode(3);
		arrList[3] = new ListNode(4);
		arrList[4] = new ListNode(5, null);
		arrList[0].next = arrList[1];
		arrList[1].next = arrList[2];
		arrList[2].next = arrList[3];
		arrList[3].next = arrList[4];

		역방향연결목록 sol = new 역방향연결목록();
		ListNode p = sol.reverseList(arrList[0]);
		
		for(int i=0;i<arrList.length;i++) { 
			System.out.print(p.val + " "); 
		}
		 

	}

}
