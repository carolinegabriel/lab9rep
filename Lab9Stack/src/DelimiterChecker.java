
import java.util.Scanner;

public class DelimiterChecker {

	public boolean check(String s) {

		StackX stack = new StackX(100);

		int index = 0;
		char c;
		DelimiterChecker dc = new DelimiterChecker();

		while (index != s.length()) {

			c = s.charAt(index);
			if (c == '{' || c == '[' || c == '(') {// opening delimiter
				stack.push(c);
			}
			if (c == '}' || c == ']' || c == ')') {// closing delimiter
				if (stack.isEmpty()) {// if the stack is empty when you hit a closing delimiter
					return false;
				} else if (!dc.match(stack.pop(), c)) {// if the delimiters do not match
					return false;
				}
			}

			index++;
		} // end while

		if (stack.isEmpty())
			return true;
		else
			return false;

	}

	public boolean match(char first, char second) {
		if (first == '{' && second == '}' || first == '[' && second == ']' || first == '(' && second == ')') {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String args[]) {
		DelimiterChecker dc = new DelimiterChecker();
		Scanner reader = new Scanner(System.in);
		String s;

		System.out.println("Enter a string to check if it has matching delimiters.");
		s = reader.nextLine();

		if (dc.check(s)) {
			System.out.println("The delimiters match.");
		} else {
			System.out.println("The delimiters do not match.");
		}

		reader.close();

	}

}
