package pl.looksok.test.logic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import junit.framework.TestCase;
import pl.looksok.logic.CcLogic;
import pl.looksok.logic.InputData;
import pl.looksok.logic.PeoplePays;
import pl.looksok.test.utils.Constants;
import pl.looksok.test.utils.TestScenarioBuilder;

public class CcLogicNotEqualPaysTest extends TestCase {

	private CcLogic calc;
	private List<InputData> inputPaysList;
	private boolean equalPayments = false;

	protected void setUp() throws Exception {
		calc = new CcLogic();
		inputPaysList = new ArrayList<InputData>();
		super.setUp();
	}
	
//	public CcLogicNotEqualPaysTest(String name) {
//		super(name);
//	}
//	
//	public void testZeroPayTwoPeople(){
//		inputPaysList = TestScenarioBuilder.buildTestCaseTwoPeopleVariousPays(0.0, 0.0, 
//				0.0, 0.0);
//		
//		Hashtable<String, PeoplePays> result = calc.calculate(inputPaysList, equalPayments);
//		assertEquals(Constants.INCORRECT_REFUND_UNEQUAL, 0.0, result.get(Constants.personAName).getTotalRefundForThisPerson());
//		assertEquals(Constants.INCORRECT_REFUND_UNEQUAL, 0.0, result.get(Constants.personBName).getTotalRefundForThisPerson());
//	}
//	
//	public void testEqualPayTwoPeople(){
//		inputPaysList = TestScenarioBuilder.buildTestCaseTwoPeopleVariousPays(10.0, 5.0, 
//				20.0, 25.0);
//		
//		Hashtable<String, PeoplePays> result = calc.calculate(inputPaysList, equalPayments);
//		assertEquals(Constants.INCORRECT_REFUND_UNEQUAL, 5.0, result.get(Constants.personAName).getTotalRefundForThisPerson());
//		assertEquals(Constants.INCORRECT_REFUND_UNEQUAL, 0.0, result.get(Constants.personBName).getTotalRefundForThisPerson());
//	}
//	
//	public void testEqualPayTwoPeopleV2(){
//		inputPaysList = TestScenarioBuilder.buildTestCaseTwoPeopleVariousPays(3.0, 8.0, 
//				7.0, 2.0);
//		
//		Hashtable<String, PeoplePays> result = calc.calculate(inputPaysList, equalPayments);
//		assertEquals(Constants.INCORRECT_REFUND_UNEQUAL, 0.0, result.get(Constants.personAName).getTotalRefundForThisPerson());
//		assertEquals(Constants.INCORRECT_REFUND_UNEQUAL, 5.0, result.get(Constants.personBName).getTotalRefundForThisPerson());
//	}

	public void testCalculationOfNonZeroPayTwoPeopleTwoPaid(){
		inputPaysList = TestScenarioBuilder.buildTestCaseTwoPeopleVariousPays(3.0, 8.0, 
				7.0, 2.0);
		
		calc.calculate(inputPaysList, equalPayments);
		assertEquals(Constants.INCORRECT_CALC_BETWEEN_TWO, 5.0, calc.howMuchPersonAGivesBackToPersonB(Constants.personAName, Constants.personBName));
		assertEquals(Constants.INCORRECT_CALC_BETWEEN_TWO, 0.0, calc.howMuchPersonAGivesBackToPersonB(Constants.personBName, Constants.personAName));
	}
}