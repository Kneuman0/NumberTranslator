package biz.personalAcademics.translationClasses;

public class Millions {
	private String partialNumber;
	private String[] baseNumberArray;

	public Millions (String partialNumber, String[] baseNumberArray){
		this.partialNumber = partialNumber;
		this.baseNumberArray = baseNumberArray;

		}
	
	// Millions will never be more than 9 for baseNumberArray can handle it alone
	protected String getMillions() {

		int numMillion = Integer.parseInt(partialNumber);
		String millions = " ";
		
		// ensures the number entered is in the millions
		if(numMillion >= 1){
		millions = baseNumberArray[numMillion] + " Million";
		}

		return millions;
	}
}
