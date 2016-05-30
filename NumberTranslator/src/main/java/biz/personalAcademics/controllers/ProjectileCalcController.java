package biz.personalAcademics.controllers;

import java.text.DecimalFormat;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import biz.personalAcademics.projectile.InvalidMeasureException;
import biz.personalAcademics.projectile.MeasureTooBigException;
import biz.personalAcademics.projectile.ProjectileCalcMain;
import biz.personalAcademics.projectile.ProjectileUtility;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class ProjectileCalcController {

    @FXML
    private RadioButton zeroYrdsTog;

    @FXML
    private RadioButton muzzleMtrsPSecTog;

    @FXML
    private Label userWarningLabel;

    @FXML
    private RadioButton calcDistYrdsTog;

    @FXML
    private Button calculateButton;

    @FXML
    private Label answerLabel;

    @FXML
    private TextField muzzleVelocText;

    @FXML
    private TextField zeroDistText;

    @FXML
    private ToggleGroup zeroDistance;

    @FXML
    private ToggleGroup calcDistance;

    @FXML
    private RadioButton muzzleFtPSecTog;

    @FXML
    private RadioButton calcDistMtrsTog;

    @FXML
    private TextField calcDistText;

    @FXML
    private RadioButton zeroMtrsTog;

    @FXML
    private ToggleGroup muzzleVelocity;

    @FXML
    private Label timeLabel;
    
    @FXML
    private AnchorPane anchorPane;
    
    DecimalFormat inches;
    
    public void initialize(){
    	inches = new DecimalFormat("0.000");
    	setBackgroundImage();
    	playSound();
    }
    
    
    
    public void calcButtonListener(){
    	playSound();
    	answerLabel.setText("");
    	timeLabel.setText("");
    	userWarningLabel.setText("");
    	if(ensureAllEntriesLogged()){
    		return;
    	}
    	
    	// convert user's specified distance to meters
		double calcDistanceM = 0;
		// time it takes for bullet to reach zeroed distance
		double timeElapsed = 0;
		// height of bullet at user's 
		double bulletHeight = 0;
		try {
			// convert shooters zero distance to meters
			double zeroDistanceM = ProjectileUtility.convertYardsToMeters(zeroMtrsTog.isSelected(), zeroDistText.getText());
			// convert muzzle velocity to meters per second
			double muzzleVelocityM = ProjectileUtility.convertFeetToMeters(muzzleMtrsPSecTog.isSelected(), muzzleVelocText.getText());
			calcDistanceM = ProjectileUtility.convertYardsToMeters(calcDistMtrsTog.isSelected(), calcDistText.getText());
			// angle of muzzle
			double theta = ProjectileUtility.getThetaUsingZero(zeroDistanceM, muzzleVelocityM);
			timeElapsed = ProjectileUtility.getTime(calcDistanceM, muzzleVelocityM, theta);
			bulletHeight = ProjectileUtility.getHeightOfBulletInInches(calcDistanceM, muzzleVelocityM, theta);
		} catch (InvalidMeasureException e) {
			userWarningLabel.setText(e.getMessage());
			return;
		}
		
		// Checks to see if user number is too big to avoid double overflow
		try {
			CheckIfMeaurementSizeIsTooBig();
		} catch (MeasureTooBigException e) {
			userWarningLabel.setText(e.getMessage());
			return;
		}
		
		try {
			checkForImpossibleSituations(timeElapsed, bulletHeight);
		} catch (ArithmeticException e) {
			userWarningLabel.setText("You have entered impossible parameters");
			return;
		}
		
    	// sets the label indicating the time it takes the bullet to travel the user specified distance
    	timeLabel.setText(String.format("It will take %.2f miliseconds to travel %.1f %s", timeElapsed, 
    	ProjectileUtility.convertMetersToYards(calcDistYrdsTog.isSelected(), calcDistanceM), 
    	ProjectileUtility.getUnitsInMetersOrYards(calcDistMtrsTog.isSelected())));
    	// sets the label telling the user the height of the specified distance
    	answerLabel.setText(String.format("%.2f inches relative to zeroed distance", bulletHeight));
    	
//    	playSound();
    	
    }
    
    private boolean ensureAllEntriesLogged(){
    	boolean incompleteForm = false;
    	if(muzzleVelocText.getText().equals("")){
    		userWarningLabel.setText("Please enter a muzzle velocity");
    		incompleteForm = true;
    	}
    	
    	if(zeroDistText.getText().equals("")){
    		userWarningLabel.setText("Please enter a zero distance");
    		incompleteForm = true;
    	}
    	
    	if(calcDistText.getText().equals("")){
    		userWarningLabel.setText("Please enter a distance to calculate for");
    		incompleteForm = true;
    	}
    	
    	return incompleteForm;
    }
    
    private void CheckIfMeaurementSizeIsTooBig() throws MeasureTooBigException{
    	if(muzzleVelocText.getText().length() > 6){
    		throw new MeasureTooBigException(muzzleVelocText.getText());
    	}
    	
    	if(zeroDistText.getText().length() > 6){
    		throw new MeasureTooBigException(zeroDistText.getText());
    	}
    	
    	if(calcDistText.getText().length() > 6){
    		throw new MeasureTooBigException(calcDistText.getText());
    	}
    }
    
    private void checkForImpossibleSituations(double time, double height) throws ArithmeticException{
    	if(Double.isNaN(time) || Double.isInfinite(time)){
    		throw new ArithmeticException();
    	}
    	
    	if(Double.isNaN(height) || Double.isInfinite(height)){
    		throw new ArithmeticException();
    	}
    }
    
    private void setBackgroundImage(){
    	Image logo = new Image(ProjectileCalcMain.class.getResourceAsStream("/resources/diamondPlate.jpg"));
    	BackgroundSize logoSize = new BackgroundSize(600, 400, false, false, true, true);
		 BackgroundImage image = new BackgroundImage(logo, BackgroundRepeat.NO_REPEAT, 
				 BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, logoSize);
		 Background background = new Background(image);
		 anchorPane.setBackground(background);
    }
    
    private void playSound(){
    	
    	Clip clip = null;
    	
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(ProjectileCalcController.class.getResourceAsStream(
					"/resources/TacobellEruption.mp3")));
			clip.start();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    

}
