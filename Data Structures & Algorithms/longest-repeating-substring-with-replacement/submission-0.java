class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqArray = new int[26];
        int left = 0, maxWindowLength = 0, maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update the freqArray
            freqArray[s.charAt(right) - 'A']++;

            // update MaxFrequency
            maxFrequency = Math.max(maxFrequency, freqArray[s.charAt(right) - 'A']);

            // Find the current WindowLength (add 1 because our array starts from index 0)
            int currentWindowLength = right - left + 1;

            // Check if the no_of_required_characters_to_be_exchanged exceeds k
            if (currentWindowLength - maxFrequency > k) {
                freqArray[s.charAt(left) - 'A']--;
                left++;
            }

            // update currentWindowLength since the window has changed
            currentWindowLength = right - left + 1;

            //update maxWindowLength (this will be our answer because the question doesnot ask which string.)
            maxWindowLength = Math.max(maxWindowLength, currentWindowLength);
        }

        return maxWindowLength;
    }
}
