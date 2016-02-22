package translationClasses;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class NumberTranslatorTest {

		
	@Test
	public void testPluralForCents(){
		NumberTranslator num = new NumberTranslator("28392.4");
		assertThat(num.getFormattedTranslatedNumber(), endsWith("s"));
	}
	
	@Test
	public void testSingularCent(){
		NumberTranslator num = new NumberTranslator("28392.01");
		assertThat(num.getFormattedTranslatedNumber(), endsWith("t"));
	}
	
	@Test
	public void testNonNumber(){
		
		try {
			NumberTranslator num = new NumberTranslator("343h");
			fail("Non number did not throw NumberFormatException");
		} catch (NumberFormatException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testThousandsPlaceForCentsNotZero(){
		try {
			NumberTranslator num = new NumberTranslator("343.003");
			fail("ThousandsPlaceException not throws when .003 was passed in");
		} catch (ThousandsPlaceException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testHyphenBetweenTens(){
		NumberTranslator num = new NumberTranslator("343.00");
		assertThat(num.getFormattedTranslatedNumber(), containsString("forty-three"));
	}
	
	@Test
	public void testNumberGreaterThanOrEqualto10Million(){
		try {
			NumberTranslator num = new NumberTranslator("10,000,000");
			fail("NotTranslatableNumberException not thrown when 10 million was passes in");
		} catch (NotTranslatableNumberException e) {
			assertTrue(true);
		} 
	}

}
