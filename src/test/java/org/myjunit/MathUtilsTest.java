package org.myjunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MathUtilsTest extends MathUtils {
	
	private MathUtils mathUtils;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to run before all");
	}
	
	@BeforeEach
	void initEach() {
		System.out.println("This needs to run before each test method");
		mathUtils = new MathUtils();
	}
	
	@AfterEach
	void afterEachmethod() {
		System.out.println("Cleaning up.....");
	}
	
	@AfterAll
	static void afterAllMethods() {
		System.out.println("This needs to run after all");
	}


	@Test
	@DisplayName("Testing add method")
	void testAddingTwoPositives() {
		assertEquals(2, mathUtils.add(1, 1), 
				"Add method should return the sum of two numbers");
	}
	
	@Test
	@DisplayName("Testing adding two negative numbers method")
	void testAddingTwoNegatives() {
		assertEquals(-2, mathUtils.add(-1, -1), 
				"Add method should return the sum of two numbers");
	}
	
	@Test
	void testAddingAPositiveAndANegative() {
		assertEquals(0, mathUtils.add(-1, 1), 
				"Add method should return the sum of two numbers");
	}
	
	@Test 
	void computeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), 
				"Should return right circle area");
	}
	
	@Test
	@DisplayName("Testing divide method")
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), 
				"Divide should throw ArithmeticException when denominator is zero");
	}
	
	@Test
	@Disabled
	@DisplayName("Failed test must not run")
	void testDisabled() {
		fail("this test should not run");
	}

}
