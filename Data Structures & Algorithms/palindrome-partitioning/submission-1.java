class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, new ArrayList<>(), 0);
        return result;
    }

    // BackTrack method
    // Partition index is nothing but the index where our string is partitioned in each step.
    // So, it will start from 0
    public void backTrack(String s, List<String> tempSet, int partitionIndex) {
        // Base case
        // When our backtracking will stop
        int n = s.length();

        if (partitionIndex == n) {
            result.add(new ArrayList<>(tempSet));
            return;
        }

        // We'll start the loop starting from the partitionIndex (base starting from 0)
        for (int end = partitionIndex; end < n; end++) {

            // Our start point of string will be the partitionIndex 
            // The end will be looping variable ("end" in our case)
            if (isPalindrome(s, partitionIndex, end)) {
                
                // We'll add the string to the list if its palindrome
                // substring method is exclusive of upperbound, so we do "+1"
                tempSet.add(s.substring(partitionIndex, end + 1));

                // we increase the starting point for loop (which is the partitionIndex in our case);
                backTrack(s, tempSet, end + 1);
                tempSet.remove(tempSet.size() - 1);
            }
        }
    }

    // Helper method to check if the string is palindrome
    public boolean isPalindrome(String s, int start, int end) {
        // We do start < end, because a single character is always palindrome
        while (start < end) {
            // return false as soon as the characters mismatch.
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
