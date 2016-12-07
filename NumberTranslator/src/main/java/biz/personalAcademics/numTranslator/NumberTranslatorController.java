package biz.personalAcademics.numTranslator;

import java.io.IOException;

import biz.personalAcademics.controllers.ProjectileCalcController;
import biz.personalAcademics.translationClasses.*;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NumberTranslatorController {
	  	
	
    @FXML
    private Label userWarningLabel;

    @FXML
    private Label translatedNumberLetter;

    @FXML
    private Button translateButton;

    @FXML
    private Button lunchBulletButton;

    @FXML
    private TextField numberRaw;

    @FXML
    private Button launchEllipButton;

	
	NumberTranslator num;
	HostServices host;
	
	public void initialize(){
		// Deliberately left blank
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
	
	public void lauchEllipsoidButtonListener(){
		Stage stage = new Stage();
		Parent parent = null;
		try {
			parent = FXMLLoader.load(getClass().getResource("/resources/EllipsoidVolumeGUI.fxml"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(parent);

		// window title
		stage.setTitle("Ellipsoid Calculator");
		stage.setScene(scene);
		stage.show();
	}
	
	public void launchBulletButtonListener(){
		Stage stage = new Stage();
		FXMLLoader loader = null;
		Parent parent = null;
		try {
			loader = new FXMLLoader(getClass().getResource("/resources/ProjectileGUI.fxml"));
			parent = (Parent)loader.load();
		} catch (IOException | NullPointerException e) {
			System.out.println(parent);
//			e.printStackTrace();
		}
		
		ProjectileCalcController control = (ProjectileCalcController)loader.getController();
		control.setApp(host);
		Scene scene = new Scene(parent);

		// window title
		stage.setTitle("Ellipsoid Calculator");
		stage.setScene(scene);
		stage.show();
	}
	
	public void setHostService(HostServices host){
		this.host = host;
	}

}
