package numTranslator;

import translationClasses.NumberTranslator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NumberTranslatorController {
	  	
	
	@FXML
	private Label translatedNumberLetter;

	@FXML
	private Button translateButton;

	@FXML
	private TextField numberRaw;
	
	@FXML
    private Label userWarningLabel;
	
	NumberTranslator num;
	
	public void initialize(){
		
	}
	
	public void calculateButtonListener(){
		userWarningLabel.setText("");
		translatedNumberLetter.setText("");
		String numberFixed = numberRaw.getText().replaceAll("[,_ ]", "");
		try {
			num = new NumberTranslator(numberFixed);
		} catch (NumberFormatException e1) {
			userWarningLabel.setText(String.format("'%s' is not a recognizable number", numberRaw.getText()));
			return;
		}
		
		if(num.getCorrectFormat()){
			userWarningLabel.setText(String.format("%s is not a translatable entry. "
					+ "Number must be greater than zero and less than 10 million", numberRaw.getText()));
			return;
		}
			
		translatedNumberLetter.setText(num.getFormattedTranslatedNumber());
//		numberRaw.setText("");
		
	}

}
