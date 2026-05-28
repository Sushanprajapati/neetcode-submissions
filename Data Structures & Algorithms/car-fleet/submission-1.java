class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairArray = new int[position.length][2];

        // create a 2D array of position and speed
        for (int i = 0; i < position.length; i++) {
            pairArray[i][0] = position[i];
            pairArray[i][1] = speed[i];
        }

        // Sort the array in descending order of position.
        Arrays.sort(pairArray, (a,b) -> Integer.compare(b[0], a[0]));

        // Double to take care of the decimal value as well.
        Stack<Double> tempStack =  new Stack<>();

        // We calculate the time taken for each car to reach the target
        for (int[] pair: pairArray) {
            tempStack.push((double) (target - pair[0]) / pair[1]);

            // Stack must be of size 2 or more to be able to compare.
            // There'll be a conflict between the two cars if the incoming car's time is <= one that's in the stack.
            // That's why we sorted the array in descending order
            // We're making sure the base case (input size of 2) is taken care 
            if (tempStack.size() >= 2 && tempStack.peek() <= tempStack.get(tempStack.size() - 2)) {
                tempStack.pop();
            }
        }

        return tempStack.size();
    }
}
