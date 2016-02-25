package biz.personalAcademics.translationClasses;

public class Thousands {
	private String partialNumber;
	private Hundreds hundredsForThous;

	public Thousands(String partialNumber, String[] baseNumArray) {
		this.partialNumber = partialNumber;
		
		// passes the thousands partialNumber to hundreds for translation. Ensure there is
		// no mis-translation between hundreds and thousands
		hundredsForThous = new Hundreds(partialNumber, baseNumArray);
	}

	/**
	 * calls lower level hundreds, tens and ones classes to translate the the partial number in
	 * the thousands position.
	 * @return
	 */
	protected String getThousands() {
		int thousInt = Integer.parseInt(partialNumber);
		String thousand = " ";

		// ensures that one of the thousands positions needs to be translated
		if (thousInt != 0) {
			thousand = hundredsForThous.getHundreds() + " Thousand";
		}

		return thousand;
	}
}
