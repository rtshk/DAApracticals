package exp5;

class Solution {
    public void quickSort(int[] arr, int low, int high) {
        // code here
        if(low<high){
            int idx=partition(arr,low,high);
        
        quickSort(arr,low,idx-1);
        quickSort(arr,idx+1,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        
        // code here
        int idx=low-1;
        int pivot=arr[high];
        for(int j=low;j<high;j++){
            if(arr[j]<=pivot){
                idx++;
                swap(arr,idx,j);
            }
        }
        idx++;
        swap(arr,idx,high);
        return idx;
    }
    private void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}