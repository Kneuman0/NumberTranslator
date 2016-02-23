package translationClasses;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.junit.matchers.JUnitMatchers.*;
import org.junit.Test;
import org.hamcrest.Matcher;
import org.junit.Test;

import biz.personalAcademics.translationClasses.Cents;

public class CentsTest {

	@Test
	public void test() {
		Cents cent = new Cents("20", "24.20");
		Integer cen = cent.getCents();
		Integer check = 20;
		assertThat(cent.getCents(), equalTo(20));
	}


}
