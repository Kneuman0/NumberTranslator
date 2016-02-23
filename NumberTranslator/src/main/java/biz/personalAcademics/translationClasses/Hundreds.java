package biz.personalAcademics.translationClasses;

public class Hundreds {
	int partialNumberInt;
	String partialNumber;
	Tens tensForHund;
	String[] baseNumberArray;

	public Hundreds(String partialNumber, String[] baseNumberArray) {
		partialNumberInt = Integer.parseInt(partialNumber);
		this.partialNumber = partialNumber;
		
		// passes the partial number used for hundreds to tens
		tensForHund = new Tens(partialNumber, baseNumberArray);
		this.baseNumberArray = baseNumberArray;
	}

	/**
	 * calls on the lower level tens and ones classes to translate the partial
	 * number in the hundreds position
	 * 
	 * @return
	 */
	public String getHundreds() {
		int hundredsPosition = Integer.parseInt(Character
				.toString(partialNumber.charAt(0)));
		String hundreds = " ";

		// handles the 1st digit in the partial number (hundreds position);
		// checks that there is a hundreds position
		if (hundredsPosition > 0) {
			// uses BaseNumberArray for first digit and called tens class 
			// to finish the rest
			hundreds = baseNumberArray[hundredsPosition] + " Hundred "
					+ tensForHund.getTens();
			// if there is no hundreds position, tens class it called out right
		} else {
			hundreds = tensForHund.getTens();
		}
		return hundreds;
	}
}
