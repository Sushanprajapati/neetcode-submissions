class Solution {
    public boolean isValid(String s) {
        Stack<Character> tempStack = new Stack<>();

        for (Character c: s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                tempStack.push(c);
            }

            if (tempStack.isEmpty()) return false;

            switch(c) {
                case '}':
                    if (tempStack.pop() != '{') return false;
                    break;
                case ']':
                    if (tempStack.pop() != '[') return false;
                    break;
                case ')':
                    if (tempStack.pop() != '(') return false;
                    break;
            }
        }

        return tempStack.isEmpty();
    }
}
