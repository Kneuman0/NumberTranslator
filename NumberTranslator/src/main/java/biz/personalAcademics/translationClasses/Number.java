package biz.personalAcademics.translationClasses;

public class Number {
	String[] baseNumArray;
	String partialNumber;
	
	public Number(){
		// array used throughout program for translation of numbers or 
				// partial numbers 15 for less. Most other numbers are combinations of these
				baseNumArray = new String[] { "", "One", "Two ", "Three", "Four",
						"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
						"Twelve", "Thirteen", "fourteen", "fifteen" };
	}
}
