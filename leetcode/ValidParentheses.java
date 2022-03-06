import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
        /*
        test: input - "{[]}"
        loop 1:
        c == '{' -> stack.push('}') -> stack: ([bottom]'}'[top])
        loop 2:
        c == '[' -> stack.push(']') -> stack: ([bottom]'}' ']'[top])
        loop 3:
        c == ']' -> stack.isEmpty() -> false || stack.pop() -> ']' != c -> false -> not executed
        */
        // my own solution, failed test case: input - "{[]}"
        // HashMap<Character, Character> pairs = new HashMap<Character, Character>();
        // pairs.put('(', ')');
        // pairs.put('{', '}');
        // pairs.put('[', ']');
        // pairs.put(')', ')');
        // pairs.put('}', '}');
        // pairs.put(']', ']');
        // for (int i=0; i<s.length(); i+=2) {
        //     boolean b = ((pairs.get(s.charAt(i))==s.charAt(i+1)));
        //     if (b==false) return b;
        // }
        // return true;
    }
}