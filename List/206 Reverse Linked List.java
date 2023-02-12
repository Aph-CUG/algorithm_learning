class Solution {
    public ListNode reverseList(ListNode head) {
        //模板:在遍历整个数组基础上进行
        ListNode last = null;
        while(head!=null){
            ListNode nextHead = head.next;
            head.next = last;
            last = head;
            head = nextHead;
        }
        return last;
    }
}