package translationClasses;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class NumberTranslatorTest {

	@Test
	public void testForCorrectFormat() {
		NumberTranslator num = new NumberTranslator("28392.4");
		assertFalse(num.getCorrectFormat());
	}
	
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
			assertTrue(false);
		} catch (NumberFormatException e) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testThousandsPlaceForCentsNotZero(){
		try {
			NumberTranslator num = new NumberTranslator("343.003");
			assertTrue(false);
		} catch (NumberFormatException e) {
			assertTrue(true);
		}
		
	}

}
