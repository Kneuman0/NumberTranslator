package translationClasses;

public class Thousands {
	int partialNumberInt;
	String partialNumber;
	Hundreds hundredsForThous;
	String[] baseNumberArray;

	public Thousands(String partialNumber, String[] baseNumArray) {
		partialNumberInt = Integer.parseInt(partialNumber);
		this.partialNumber = partialNumber;
		
		// passes the thousands partialNumber to hundreds for translation. Ensure there is
		// no mis-translation between hundreds and thousands
		hundredsForThous = new Hundreds(partialNumber, baseNumArray);
		this.baseNumberArray = baseNumArray;
	}

	/**
	 * calls lower level hundreds, tens and ones classes to translate the the partial number in
	 * the thousands position.
	 * @return
	 */
	public String getThousands() {
		int thousInt = Integer.parseInt(partialNumber);
		String thousand = " ";

		// ensures that one of the thousands positions needs to be translated
		if (thousInt != 0) {
			thousand = hundredsForThous.getHundreds() + " Thousand";
		}

		return thousand;
	}
}
