package exp6;

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        Boolean dp[][] = new Boolean[arr.length][sum+1];
        
        return isPossible(arr, 0, sum, dp);
    }
    public static boolean isPossible(int arr[], int i, int sum, Boolean dp[][]){
        if(i==arr.length || sum==0) return sum==0;
        
        if(dp[i][sum]!=null){
            return dp[i][sum];
        }
        
        if(sum>=arr[i]){
            return dp[i][sum] = isPossible(arr, i+1, sum-arr[i], dp) || isPossible(arr, i+1, sum, dp);
        }
        return dp[i][sum] = isPossible(arr, i+1, sum, dp);
    }
}