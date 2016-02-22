 package translationClasses;

@SuppressWarnings("serial")
public class NotTranslatableNumberException extends RuntimeException {
	
	public NotTranslatableNumberException(String number){
		super(String.format("%s is not a translatable entry. "
					+ "Number must be greater than zero and less than 10 million", number));
	}

}
