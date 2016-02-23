package biz.personalAcademics.translationClasses;

public class Millions {
	int partialNumberInt;
	String partialNumber;
	String[] baseNumberArray;
	int intValue;

	public Millions (String partialNumber, String[] baseNumberArray){
		partialNumberInt = Integer.parseInt(partialNumber);
		this.partialNumber = partialNumber;
		this.baseNumberArray = baseNumberArray;

		}
	
	// Millions will never be more than 9 for baseNumberArray can handle it alone
	public String getMillions() {

		int numMillion = Integer.parseInt(partialNumber);
		String millions = " ";
		intValue = numMillion;
		
		// ensures the number entered is in the millions
		if(numMillion >= 1){
		millions = baseNumberArray[numMillion] + " Million";
		}

		return millions;
	}
}
