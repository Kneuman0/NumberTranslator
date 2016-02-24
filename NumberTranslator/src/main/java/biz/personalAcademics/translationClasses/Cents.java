package biz.personalAcademics.translationClasses;

public class Cents {
	private int partialNumberInt;
	private String[] centsArray;
	private String number;

	public Cents(String partialNumber, String num) throws ThousandsPlaceException {
		partialNumberInt = Integer.parseInt(partialNumber);
		// splits number entered by user into dollars and cents (two element array)
		centsArray = num.split("[.]");
		this.number = num;
		
		//Throws a ThousandsPlaceException if input is not translatable
		getCheckCentsFormat();
	}
/**
 * Returns cents *100 yielding a whole number
 * @return
 */
	public int getCents() {
		// returns int value passed to class constructor
		return partialNumberInt;
	}

	/**
	 * Verifies cents are in the right format. Returns true if any character other 
	 * than zero exists after the 100's place. True = fail
	 * @return
	 */
	public void getCheckCentsFormat() throws ThousandsPlaceException {
		String partialCents2 = "";
		
		// checks if any cents are present in entered number
		if (centsArray.length > 1) {
			StringBuilder cents = new StringBuilder();
			cents.append(centsArray[1]);

			if (centsArray[1].length() > 1) {
				// deletes the first two characters in the cents string and then all remaining zeros
				// if anything is left, ThousandsPlaceException is thrown
				partialCents2 = cents.deleteCharAt(0).deleteCharAt(0)
						.toString().replaceAll("[0]", "");
			}
			
			if(partialCents2.length() != 0){
				throw new ThousandsPlaceException(this.number);
			}
			
		}

		

	}
}
