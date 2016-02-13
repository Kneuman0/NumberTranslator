package translationClasses;

public class Tens {
	int partialNumberInt;
	String partialNumber;
	Ones onesForTens;
	String[] baseNumberArray;

	public Tens(String partialNumber, String[] baseNumberArray) {
		partialNumberInt = Integer.parseInt(partialNumber);
		this.partialNumber = partialNumber;
		this.baseNumberArray = baseNumberArray;
		onesForTens = new Ones(partialNumber, baseNumberArray);

	}

	/**
	 * Translates numbers in the tens position
	 * @return
	 */
	public String getTens() {
		// stores the number in the 2nd and 3rd position of partial number (ones and tens)
		int twoDigits = Integer.parseInt(partialNumber.substring(1, 3));
		// stores the 2nd digit (tens)
		int secondDigit = Integer.parseInt(Character.toString(partialNumber
				.charAt(1)));
		String tens = "";
		
		// handles numbers 1 thru 15
		if (twoDigits <= 15 && twoDigits > 0) {
			tens = baseNumberArray[twoDigits];
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
				tens = baseNumberArray[secondDigit] + "ty-"
						+ onesForTens.getOnes(partialNumber);

			}
		}else{
			tens = "";
		}
		return tens;
	}

}
