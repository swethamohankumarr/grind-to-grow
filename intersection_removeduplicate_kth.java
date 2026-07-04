import java.util.*;
class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        HashSet<Integer> hash = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hash.add(arr[i]);
        }
        
        ArrayList<Integer> arr_list = new ArrayList<>(hash);
        Collections.sort(arr_list);
        
        return arr_list;
    }
}


class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        ArrayList<Integer> finall = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            finall.add(a[i]);
        }
        
        for(int j=0;j<b.length;j++){
            finall.add(b[j]);
        }
        
        Collections.sort(finall);
        
        return finall.get(k-1);
    }
}