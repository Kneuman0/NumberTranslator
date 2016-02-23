package biz.personalAcademics.translationClasses;

@SuppressWarnings("serial")
public class ThousandsPlaceException extends RuntimeException {
	ThousandsPlaceException(){
		super("numbers containging 10ths of a cent or smaller will not be translated");
	}
}
