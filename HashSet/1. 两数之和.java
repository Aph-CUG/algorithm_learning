class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>hashmap=new HashMap<Integer,Integer>();
        int[]res=new int[2];
        int length = nums.length;
        for(int i = 0 ; i < length ; i++){
            if(hashmap.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = hashmap.get(target - nums[i]);
            }
            hashmap.put(nums[i] , i); 
        }
        return res;
    }
}