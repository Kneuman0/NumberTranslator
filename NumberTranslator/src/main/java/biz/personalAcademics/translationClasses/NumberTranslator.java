package biz.personalAcademics.translationClasses;

import java.text.DecimalFormat;

public class NumberTranslator {

	
	double number;
	DecimalFormat standardForm;
	DecimalFormat checkForm;
	Millions million;
	Thousands thousand;
	Hundreds hundred;
	Tens ten;
	Ones one;
	Cents cent;
	String[] partialNumbersArray;
	String[] baseNumArray;
	String centsNumber;

	public NumberTranslator(String rawNumber) throws NumberFormatException, 
	ThousandsPlaceException, NotTranslatableNumberException{
		
		String numberFixed = rawNumber.replaceAll("[,_ ]", "");
		
		this.number = Double.parseDouble(numberFixed);
		// format used to .split entered number into 4 partial numbers
		standardForm = new DecimalFormat("0,000,000.00");
		// format used to check the entered number for correct format
		checkForm = new DecimalFormat("#.###");
		this.centsNumber = numberFixed;
		
		// Throws NotTranslatableNumberException if the whole number is not translatable
		checkWholeNumberFormat();
		
		// splits the entered number into a 4 element array containing millions, 
		// thousands, hundreds and cents respectively
		partialNumbersArray = standardForm.format(this.number).split("[,.]");
		
		// array used throughout program for translation of numbers or 
		// partial numbers 15 for less. Most other numbers are combinations of these
		baseNumArray = new String[] { "", "One", "Two ", "Three", "Four",
				"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
				"Twelve", "Thirteen", "fourteen", "fifteen" };
		
		// handles partial numbers in the millions position
		million = new Millions(partialNumbersArray[0], baseNumArray);
		// handles partial numbers in the thousands positions
		thousand = new Thousands(partialNumbersArray[1], baseNumArray);
		// handles partial numbers in the hundreds positions
		hundred = new Hundreds(partialNumbersArray[2], baseNumArray);
		// handles the partial number for cents
		cent = new Cents(partialNumbersArray[3], numberFixed);
		
		//Throws ThousandPlaceException if cents are not translatable
		cent.getCheckCentsFormat();
		
	}
		
	/**
	 * User error catching method for use in GUI apps
	 * @return
	 */
	public void checkWholeNumberFormat() throws NotTranslatableNumberException{
		String stringNumber = checkForm.format(number);
		// splits entered number into a 2 element array (dollars and cents)
		String[] numToken = stringNumber.split("[.]");
		// checks for cents format, size of number, non zero or negative and that 
		//it is in fact a number
		if (numToken[0].length() >= 8  || number <= 0) {
			
			throw new NotTranslatableNumberException(centsNumber);
		}
	}

	/**
	 * Formats number after initial assembly. Deletes extra spaces, 
	 * extra dashes, and capitals
	 * @return
	 */
	public String getFormattedTranslatedNumber(){
		String formattedTransNum = "";
		if(number < 1){
			formattedTransNum = getNoCaps(cent.getCents() + " cent" + getPluralCents());
		}else{
			formattedTransNum = getNoCaps(getTranslatedNumber().trim().replaceAll("- ", " ").
					replace("   ", " ").replace("  ", " ") + getPluralCents());
		}
		return formattedTransNum;
	}
	
	/**
	 * Assembles all parts of the translated number. This methods returns an unformatted string
	 * @return
	 */
	public String getTranslatedNumber(){
		return million.getMillions() + " " + thousand.getThousands()
				+ " " + hundred.getHundreds() + " and " + cent.getCents()
				+ " cent";
	}
	

	/**
	 * Returns a number with all caps replaced with lowercase except the first character
	 * @param s
	 * @return
	 */
	public String getNoCaps(String s){
		String transString = "";
		for(int i = 0; i < s.length(); i++){
			char position = s.charAt(i);
			char positionFix = position;
			if(Character.isUpperCase(position) && i != 0){
				position = Character.toLowerCase(positionFix);
			}
			transString += position;
		}
		
		return transString;
	}
	
	/**
	 * returns a string containing the letter "s" if cents is greater than 1 or = 0
	 * @return
	 */
	public String getPluralCents(){
		String plural = "s";
		if(cent.getCents() < 2 && cent.getCents() > 0){
			plural = "";
		}

		return plural;
	}
}

	