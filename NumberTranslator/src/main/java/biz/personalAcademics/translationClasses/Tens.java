package biz.personalAcademics.translationClasses;

public class Tens extends Number{
	private Ones onesForTens;

	public Tens(String partialNumber) {
		super.partialNumber = partialNumber;
		onesForTens = new Ones(partialNumber);

	}

	/**
	 * Translates numbers in the tens position
	 * @return
	 */
	protected String getTens() {
		// stores the number in the 2nd and 3rd position of partial number (ones and tens)
		int twoDigits = Integer.parseInt(partialNumber.substring(1, 3));
		// stores the 2nd digit (tens)
		int secondDigit = Integer.parseInt(Character.toString(partialNumber
				.charAt(1)));
		String tens = "";
		
		// handles numbers 1 thru 15
		if (twoDigits <= 15 && twoDigits > 0) {
			tens = super.baseNumArray[twoDigits];
			// handles numbers 16 thru 99
		} else if(twoDigits > 15){
			// switches on the tens position of the number and calls the ones class to finish
			switch (secondDigit) {
			
			case 2:
				tens = "Twenty-" + onesForTens.getOnes(partialNumber);
				break;
			case 3:
				tens = "Thirty-" + onesForTens.getOnes(partialNumber);
				break;
			case 4:
				tens = "Forty-" + onesForTens.getOnes(partialNumber);
				break;
			case 5:
				tens = "Fifty-" + onesForTens.getOnes(partialNumber);
				break;
			case 8:
				tens = "Eighty-" + onesForTens.getOnes(partialNumber);
				break;
			default:
				// uses baseNuberArray to all tens numbers that start with a number
				tens = super.baseNumArray[secondDigit] + "ty-"
						+ onesForTens.getOnes(partialNumber);

			}
		}else{
			tens = "";
		}
		return tens;
	}

}
