class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> tempStack = new Stack<>(); // tempStack will store value like [tmp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];

            while (!tempStack.isEmpty() && currentTemp > tempStack.peek()[0]) {
                int[] currentTempInStack = tempStack.pop();
                result[currentTempInStack[1]] = i - currentTempInStack[1];
            }

            tempStack.push(new int[]{temperatures[i], i});
        }

        return result;
    }
}
