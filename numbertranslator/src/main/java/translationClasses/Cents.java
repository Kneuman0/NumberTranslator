package translationClasses;

public class Cents {
	int partialNumberInt;
	String number;
	String partialNumber;
	String[] centsArray;

	public Cents(String partialNumber, String[] baseNumberArray, String num) {
		partialNumberInt = Integer.parseInt(partialNumber);
		this.partialNumber = partialNumber;
		// number entered by user
		this.number = num;
		// splits number entered by user into dollars and cents (two element array)
		centsArray = num.split("[.]");
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
	public boolean getCheckCentsFormat() {
		boolean falseFormat = false;
		
		String partialCents2 = "";
		String zero = "0";

		// checks in any cents are present in entered number
		if (centsArray.length > 1) {
			StringBuilder cents = new StringBuilder();
			cents.append(centsArray[1]);

			if (centsArray[1].length() > 1) {
				// deletes the first two characters in the cents string
				partialCents2 = cents.deleteCharAt(0).deleteCharAt(0)
						.toString();
			}
			// verifies that the following characters after the first two are all zeros
			// if any character other than zero is found, method returns true
			for (int i = 0; i < partialCents2.length(); i++) {
				if (!zero.equals(Character.toString(partialCents2.charAt(i)))) {
					falseFormat = true;
				}
			}
		}

		return falseFormat;

	}
}
