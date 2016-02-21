package numTranslator;

import translationClasses.NotTranslatableNumberException;
import translationClasses.NumberTranslator;
import translationClasses.ThousandsPlaceException;
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
		
		try {
			num = new NumberTranslator(numberRaw.getText());
		} catch(NumberFormatException e1) {
			userWarningLabel.setText(String.format("'%s' is not a recognizable number", numberRaw.getText()));
			return;
		} catch(ThousandsPlaceException e){
			userWarningLabel.setText(e.getMessage());
		} catch(NotTranslatableNumberException e2){
			userWarningLabel.setText(e2.getMessage());
		}
		
		
			
		translatedNumberLetter.setText(num.getFormattedTranslatedNumber());
//		numberRaw.setText("");
		
	}

}
