package biz.personalAcademics.numTranslator;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NumberTranslatorMain extends Application {

	public void start(Stage stage) {
		Parent parent = null;
		try {
			parent = FXMLLoader.load(getClass().getResource("/resources/numberTranslatorGUI.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error in parent declaration");
		}
		Scene scene = new Scene(parent);

		// window title
		stage.setTitle("Number Translator");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * creates application in memory
	 * 
	 * @param args
	 */
		public static void main(String[] args) {
			launch(args);

		}



}
