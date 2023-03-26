class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<> tokensArray =new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            while (!deque.isEmpty() && deque.getFirst() <= i - k){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]){
                deque.removeLast();
            }
            deque.add(i);
            if(i >= k - 1){
                 ans[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return ans;
        
    }
   Deque<Integer> deque = new LinkedList();

}