class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode();
        ListNode first = newNode;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                newNode.next = list1;
                newNode = newNode.next;
                list1 = list1.next;
            }
            else{
                newNode.next = list2;
                newNode = newNode.next;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            newNode.next = list1;
        }
        if(list2 != null){
            newNode.next = list2;
        }
        return first.next;
    }
}