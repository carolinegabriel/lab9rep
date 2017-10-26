import static org.junit.Assert.*;

import org.junit.Test;

public class DelimiterTest {

	@Test
	public void testCheck() {

		DelimiterChecker dc = new DelimiterChecker();
		boolean value1 = dc.check("a{b[c]d}e");
		assertEquals(value1, true);
		boolean value2 = dc.check("a[b{c}d]e}");
		assertEquals(value2, false);
		boolean value3 = dc.check("[a[b{c}d]e");
		assertEquals(value3, false);
		boolean value4 = dc.check("[a]{b}");
		assertEquals(value4, true);
		boolean value5 = dc.check("[a}[b}");
		assertEquals(value5, false);
	}

}
