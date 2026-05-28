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

        Stack<Double> tempStack =  new Stack<>();

        for (int[] pair: pairArray) {
            tempStack.push((double) (target - pair[0]) / pair[1]);

            if (tempStack.size() >= 2 && tempStack.peek() <= tempStack.get(tempStack.size() - 2)) {
                tempStack.pop();
            }
        }

        return tempStack.size();
    }
}
