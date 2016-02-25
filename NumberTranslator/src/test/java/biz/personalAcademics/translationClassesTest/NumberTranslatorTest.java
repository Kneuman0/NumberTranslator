package biz.personalAcademics.translationClassesTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import biz.personalAcademics.translationClasses.*;

public class NumberTranslatorTest {

	@Rule
	public ExpectedException invalidInput = ExpectedException.none();
	
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
		invalidInput.expect(NumberFormatException.class);
		NumberTranslator num = new NumberTranslator("343h");
	}
	
	@Test
	public void testThousandsPlaceForCentsNotZero(){
		invalidInput.expect(ThousandsPlaceException.class);
		invalidInput.expectMessage(containsString("343.003"));
		NumberTranslator num = new NumberTranslator("343.003");
	}
	
	@Test
	public void testHyphenBetweenTens(){
		NumberTranslator num = new NumberTranslator("343.00");
		assertThat(num.getFormattedTranslatedNumber(), containsString("forty-three"));
	}
	
	@Test
	public void testNumberGreaterThanOrEqualto10Million(){
		invalidInput.expect(NotTranslatableNumberException.class);
		invalidInput.expectMessage(containsString("10000000"));
		NumberTranslator num = new NumberTranslator("10,000,000");
	}

}
