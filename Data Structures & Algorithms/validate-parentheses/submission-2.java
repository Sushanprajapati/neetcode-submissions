class Solution {
    public boolean isValid(String s) {
        Stack<Character> tempChar = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') tempChar.push(c);

            if (tempChar.isEmpty()) return false;

            switch (c) {
                case ')':
                    if (tempChar.pop() != '(') return false;
                    break;
                case ']':
                    if (tempChar.pop() != '[') return false;
                    break;
                case '}':
                    if (tempChar.pop() != '{') return false;
                    break;
            }
        }
        return tempChar.isEmpty();
    }
}
