class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect = new ListNode(0,head);
        ListNode last = protect;

        while(head !=null){
            ListNode end = getEnd(head,k);
            if(end == null) break;

            ListNode nextGroupHead = end.next;

            reverseList(head,nextGroupHead);

            last.next = end;
            head.next = nextGroupHead;

            last = head;
            head = nextGroupHead;
        }
        return protect.next;


    }

    private ListNode getEnd(ListNode head,int k){
        while(head != null){
            k--;
            if(k == 0){
                return head;
            }
            head=head.next;
        }
        return null;
    }

    private void reverseList(ListNode head, ListNode stop){
        ListNode last = head;
        head =head.next;
        while(head != stop){
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
    }
}