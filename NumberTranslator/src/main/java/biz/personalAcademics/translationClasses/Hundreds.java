package biz.personalAcademics.translationClasses;

public class Hundreds extends Number{
	private Tens tensForHund;

	public Hundreds(String partialNumber) {
		super.partialNumber = partialNumber;
		
		// passes the partial number used for hundreds to tens
		tensForHund = new Tens(partialNumber);
	}

	/**
	 * calls on the lower level tens and ones classes to translate the partial
	 * number in the hundreds position
	 * 
	 * @return
	 */
	protected String getHundreds() {
		int hundredsPosition = Integer.parseInt(Character
				.toString(partialNumber.charAt(0)));
		String hundreds = " ";

		// handles the 1st digit in the partial number (hundreds position);
		// checks that there is a hundreds position
		if (hundredsPosition > 0) {
			// uses BaseNumberArray for first digit and called tens class 
			// to finish the rest
			hundreds = super.baseNumArray[hundredsPosition] + " Hundred "
					+ tensForHund.getTens();
			// if there is no hundreds position, tens class it called out right
		} else {
			hundreds = tensForHund.getTens();
		}
		return hundreds;
	}
}
