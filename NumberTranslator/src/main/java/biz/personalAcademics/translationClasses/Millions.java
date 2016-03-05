package biz.personalAcademics.translationClasses;

public class Millions extends Number{

	public Millions (String partialNumber){
		super.partialNumber = partialNumber;

		}
	
	// Millions will never be more than 9 for baseNumberArray can handle it alone
	protected String getMillions() {

		int numMillion = Integer.parseInt(partialNumber);
		String millions = " ";
		
		// ensures the number entered is in the millions
		if(numMillion >= 1){
		millions = super.baseNumArray[numMillion] + " Million";
		}

		return millions;
	}
}
