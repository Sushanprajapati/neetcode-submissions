class Solution {
    public boolean isValid(String s) {
        Stack<Character> tempStack = new Stack<>();

        for (Character ch: s.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') tempStack.push(ch);

            if (tempStack.isEmpty()) return false;

            switch(ch) {
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
