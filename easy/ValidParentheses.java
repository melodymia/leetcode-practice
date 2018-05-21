//valid parentheses solution 1
/* 经典解法：栈
   此处使用了Stack类（未使用peek方法）
   需了解其常用方法push(item),pop(),empty(),peek(),search(object o)
   其中search方法返回的是：离栈顶最近的object的位置到栈顶的距离
*/

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i = 0;i <s.length(); i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                char topChar = stack.pop();      //pop()是将栈顶元素出栈，而peek()只是获取栈顶元素并未出栈
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}


//solution 2
/* 经典解法：栈
   此处使用了Stack类（使用peek方法）
   注意：peek()函数在Stack为空时会报出EmptyStackException异常！！！
   
   &复习HashMap的用法
*/

class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}


//solution 2
//未使用stack类，但本质仍是stack

public class Solution {
	public boolean isValid(String s) {
		if(s == null || s.isEmpty())
			return true;
		int len = s.length();
		char[] chars = new char[len];
		int charsNum = 0;
		char temp;
		for (int i = 0; i < len; i++) {
			temp = s.charAt(i);
			if (temp == ')' && charsNum > 0) {
				if (chars[charsNum - 1] == '(') {
					charsNum--;
					continue;
				}
			} 
			else if (temp == ']' && charsNum > 0) {
				if (chars[charsNum - 1] == '[') {
					charsNum--;
					continue;
				}
			} 
			else if (temp == '}' && charsNum > 0) {
				if (chars[charsNum - 1] == '{') {
					charsNum--;
					continue;
				}
			}
			chars[charsNum] = temp;
			charsNum++;
		}
		if(charsNum == 0)
			return true;
		else
			return false;
	}
}


//solution 3 新颖思路
//以数学形式表现stack，三位数分别代表三类括号
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 > 0)
    		return false;
    	
    	int sum = 0;
    	int num = 0; // 系数
    	for (int i = 0; i < s.length(); i++) {
    		switch (s.charAt(i)) {
			case '(':
				num = num + 1;
				sum = sum + (1 * num);
				break;
			case '[':
				num = num + 1;
				sum = sum + (10 * num);
				break;
			case '{':
				num = num + 1;
				sum = sum + (100 * num);
				break;
			case ')':
                if (num == 0)
                    return false;
				sum = sum - (1 * num);
				num = num - 1;
				break;
			case ']':
                if (num == 0)
                    return false;
				sum = sum - (10 * num);
				num = num - 1;
				break;
			case '}':
                if (num == 0)
                    return false;
				sum = sum - (100 * num);
				num = num - 1;
				break;

			default:
				return false;
			}
    	}
    	
    	return sum == 0;
    }
}
