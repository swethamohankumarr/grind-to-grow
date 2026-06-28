/*Given an array arr[] of integers and another integer target.
 Determine if there exist two distinct indices such that the sum 
 of their elements is equal to the target.

Examples:

Input: arr[] = [0, -1, 2, -3, 1], target = -2
Output: true
Explanation: arr[3] + arr[4] = -3 + 1 = -2
Input: arr[] = [1, -2, 1, 0, 5], target = 0
Output: false
Explanation: None of the pair makes a sum of 0
Input: arr[] = [11], target = 11
Output: false
Explanation: No pair is possible as only one element is present in arr[]
Constraints:
1 ≤ arr.size ≤ 105
-105 ≤ arr[i] ≤ 105
-2*105 ≤ target ≤ 2*105
*/


/*Time complexity - O(n)
Space - O(1) 
concept - two pointers */






class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        
        int left=0;
        int right=arr.length-1;
        boolean ans=false;
        Arrays.sort(arr);
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==target){
                ans=true;
                break;
            }
            
            else if(sum<target){
                left=left+1;
                
            }
            else if(sum>target){
                right=right-1;
            }
            
            
            
            
        }
        return ans;
        
    }
}