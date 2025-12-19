package maxJUnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MaximumTest {

	private static Maximum max;
	private int result;
	
	@BeforeAll
	public static void setUp() {
		max = new Maximum();
	}
	
	@Test
	public void testDifferent() {
		result = max.findMax(1, 2, 3);
		assertEquals(result,3);
		result=max.findMax(3, 2, 1);
		assertEquals(result, 3);
		result = max.findMax(2, 3, 1);
		assertEquals(result,3);
	}
	
	@Test
	public void testNegative() {
	result = max.findMax(-1, -2, -3);
	assertEquals(result, -1);
	result = max.findMax(-3, -2, -1);
	assertEquals(result,-1);
	result = max.findMax(-2, -3, -1);
	assertEquals(result,-1);
	}
	
	@Test
	public void sameNumbers() {
		result = max.findMax(2, 4, 4);
		assertEquals(4,result);
	}
	
	

}
