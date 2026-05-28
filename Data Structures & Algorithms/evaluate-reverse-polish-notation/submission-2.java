class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> intStack = new Stack<>();
        String checkStrings = "+-/*";

        for (String str : tokens) {
            if (checkStrings.contains(str)) {
                int first = intStack.pop();
                int second = intStack.pop();
            
                switch (str) {
                    case "+":
                        intStack.push(first + second);
                        break;
                    case "-":
                        intStack.push(second - first);
                        break;
                    case "*":
                        intStack.push(first * second);
                        break;
                    case "/":
                        intStack.push(second / first);
                        break;
                }
            } else {
                intStack.push(Integer.valueOf(str));
            }
        }

        return intStack.pop();
    }
}
