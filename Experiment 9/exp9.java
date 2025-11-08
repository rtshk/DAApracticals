// User Function Template for Java
class Solution {
    public ArrayList<Integer> search(String pat, String txt) {
        // your code here
        int n = txt.length();
        int m = pat.length();
        
        int[] lps = new int[m];
        construct(lps, pat, txt);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0; // i is text index, j is pattern index
        
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            
            if (j == m) {
                // Match found, add starting index (i - j)
                ans.add(i - j); 
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1]; // Fallback using LPS array
                } else {
                    i++; // No previous match, move to next text character
                }
            }
        }
        return ans;
    }
    
    // Helper function to construct the LPS array (failure function)
    public void construct(int[] lps, String pat, String txt) {
        int len = 0;
        lps[0] = 0; // lps[0] is always 0
        int i = 1;
        
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Fallback len
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}