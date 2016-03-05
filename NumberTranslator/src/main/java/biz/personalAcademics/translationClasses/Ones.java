package biz.personalAcademics.translationClasses;

public class Ones extends Number{

	public Ones(String partialNumber) {
		// distributed partial number 3 digits long padded with 0's if necessary
		super.partialNumber = partialNumber;
	}

	/**
	 * Returns numbers in the ones position based on the partial number passed
	 * to it during construction
	 * 
	 * @return
	 */
	protected String getOnes() {

		// picks number in the third position of the partial number and uses it
		// as an
		// index for the baseNumberArray for number 1 thru 9
		int numOnes = Integer.parseInt(Character.toString(partialNumber
				.charAt(2)));
		String ones = "";
		if (numOnes != 0) {
			ones = super.baseNumArray[numOnes];
		}

		return ones;
	}

	/**
	 * returns translated ones based on the number passed in. Method accepts a
	 * number String
	 * 
	 * @param index
	 * @return
	 */
	protected String getOnes(String index) {
		String ones = "";
		// Stores a 3 digit number. Anticipated usage: numbers <= to 15
		int allOnes = Integer.parseInt(index);
		// Stores a single number at the ones position. Can handle any number 0
		// to 9
		// Anticipated Usage: numbers greater than 15, other methods take care
		// of translation in the hundreds and tens places
		int singleOnes = Integer.parseInt(Character.toString(index.charAt(2)));

		// Handles small numbers (numbers <=15)
		if (allOnes <= 15) {
			ones = super.baseNumArray[allOnes];
		} else {
			// Supplements Tens class for numbers greater than 15. Only handles
			// numbers 1 thru 9
			ones = super.baseNumArray[singleOnes];
		}
		return ones;
	}
}
