//leetcode 912
//Time complexity O(nlogn)

class Solution {
    public int[] sortArray(int[] nums) {
        Msort(nums, 0, nums.length - 1);
        return nums;
    }
    public void Msort(int[] nums, int low, int high){
        if(low == high){
            return;
        }
        int mid = (low + high) / 2;
        Msort(nums, low, mid);
        Msort(nums, mid + 1, high);
        Merge(nums, low, high, mid);
    }
    public void Merge(int nums[], int low, int high, int mid){
        List<Integer> data = new ArrayList<>();
        int i = low;
        int j = mid + 1;
        while(i <= mid && j <= high){
            if(nums[j] < nums[i]){
                data.add(nums[j]);
                j++;
            }
            else{
                data.add(nums[i]);
                i++;
            }
        }
        while(i <= mid){
            data.add(nums[i]);
            i++;
        }
        while(j <= high){
            data.add(nums[j]);
            j++;
        }

        for(i = low; i <= high; i++){
            nums[i] = data.get(i - low);
        }
    }
}