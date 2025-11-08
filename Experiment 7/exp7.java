import java.util.*;

class Solution {

    // Function to search pattern in text using KMP
    ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        // LPS array
        int lps[] = new int[m];
        computeLPSArray(pat, lps);

        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0; // i -> txt, j -> pat

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                ans.add(i - j); // pattern found
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return ans;
    }

    // Function to compute LPS array
    void computeLPSArray(String pat, int lps[]) {
        int length = 0;
        int i = 1;
        lps[0] = 0;

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    // Driver method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String txt = "geeksforgeeks";
        String pat = "geek";

        ArrayList<Integer> result = sol.search(pat, txt);
        System.out.println(result); // Output: [0, 8]
    }
}
