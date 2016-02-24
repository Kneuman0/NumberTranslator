package biz.personalAcademics.translationClasses;

@SuppressWarnings("serial")
public class ThousandsPlaceException extends RuntimeException {
	ThousandsPlaceException(String number){
		super(String.format("You entered: %s\nNumbers containing 10ths of a cent or smaller will not be translated", number));
	}
}
