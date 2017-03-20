package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("RooME");

		GridPane grid = new GridPane();
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(30, 30, 30, 30));

		//add labels
		Text fag = new Text("Hvilket fag underviser du i?");
		fag.getStyleClass().add("description");
		grid.add(fag, 0, 0);

		Text projector = new Text("Trenger du projector?");
		projector.getStyleClass().add("description");
		grid.add(projector, 0, 1);

		Text whiteboard = new Text("Trenger du whiteboard?");
		whiteboard.getStyleClass().add("description");
		grid.add(whiteboard, 0, 2);

		Text blackboard = new Text("Trenger du blackboard?");
		blackboard.getStyleClass().add("description");
		grid.add(blackboard, 0, 3);

		Text experimentable = new Text("Trenger du å gjøre eksperiment?");
		experimentable.getStyleClass().add("description");
		grid.add(experimentable, 0, 4);
		
		Text studentCount = new Text("Hvor mange elever har du?");
		studentCount.getStyleClass().add("description");
		grid.add(studentCount, 0, 5);

		Text ny2 = new Text("TBA");
		ny2.getStyleClass().add("description");
		grid.add(ny2, 0, 6);


		//add labels
		Text warnings = new Text("");
		fag.getStyleClass().add("description");
		grid.add(warnings, 1, 8);

		//add inputs
		TextField textField = new TextField();
		grid.add(textField,1,0);
		
		//A checkbox without a caption
		CheckBox cb1 = new CheckBox();
		grid.add(cb1,1,1);
		
		CheckBox cb2 = new CheckBox();
		grid.add(cb2,1,2);
		
		CheckBox cb3 = new CheckBox();
		grid.add(cb3,1,3);
		
		CheckBox cb4 = new CheckBox();
		grid.add(cb4,1,4);
		
		TextField amount = new TextField();
		grid.add(amount, 1, 5);

		//cb1.setText("First");
		cb1.setSelected(false);
		cb2.setSelected(false);
		cb3.setSelected(false);
		cb4.setSelected(false);
		
		Button myButton = new Button("Søk etter rom");
		myButton.getStyleClass().add("button");
		grid.add(myButton, 1, 7);

		myButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				//warningstring
				String warningText = "";

				//clear all css
				
				fag.getStyleClass().removeAll("valid,", "notvalid");
				/*
				roomText.getStyleClass().removeAll("valid,", "notvalid");
				dateField.getStyleClass().removeAll("valid,", "notvalid");
				timeStartField.getStyleClass().removeAll("valid,", "notvalid");
				timeEndField.getStyleClass().removeAll("valid,", "notvalid");
				repetitionField.getStyleClass().removeAll("valid,", "notvalid");
				dateEndField.getStyleClass().removeAll("valid,", "notvalid");*/
				myButton.getStyleClass().removeAll("valid,", "notvalid");

				//validates purpose
				if (Controller.validatePurpose(fag.getText())) {
					fag.getStyleClass().add("valid");
					System.out.println("whyText is valid");
				}
				else {
					System.out.println("whytext is not valid");
					fag.getStyleClass().add("notvalid");
					warningText = warningText + "Formål er ugyldig\n";
				}
				
				if (Controller.checkValue(cb1.isSelected())) {
					System.out.println("cb1 is checked");
				}
				
				if (Controller.checkValue(cb2.isSelected())) {
					System.out.println("cb2 is checked");
				}
				
				if (Controller.checkValue(cb3.isSelected())) {
					System.out.println("cb3 is checked");
				}
				
				if (Controller.checkValue(cb4.isSelected())) {
					System.out.println("cb4 is checked");
				}
/*
				//validates room
				if (Controller.validateRoom(roomText.getText())) {
					roomText.getStyleClass().add("valid");
					System.out.println("room is valid");
				}
				else {
					System.out.println("room is not valid");
					roomText.getStyleClass().add("notvalid");
					warningText = warningText + "Rom er ugyldig\n";
				}

				//validates Date
				if (Controller.validateDate(dateField.getValue())) {
					dateField.getStyleClass().add("valid");
					System.out.println("date is valid");
				}
				else {
					System.out.println("date is not valid");
					dateField.getStyleClass().add("notvalid");
					warningText = warningText + "Dato er ugyldig\n";
				}

				//validates time
				if (Controller.validateTime(timeStartField.getText(),timeEndField.getText())) {
					System.out.println("time is valid");
					timeStartField.getStyleClass().add("valid");
					timeEndField.getStyleClass().add("valid");
				}
				else {
					System.out.println("time is not valid");
					timeEndField.getStyleClass().add("notvalid");
					timeStartField.getStyleClass().add("notvalid");
					warningText = warningText + "fra klokkeslett eller til\nklokkeslett er ugyldig\n";
				}

				//validates repetition
				if (Controller.validateRepetition(repetitionField.getText())) {
					System.out.println("repetition is valid");
					repetitionField.getStyleClass().add("valid");
				}
				else {
					System.out.println("repetition is not valid");
					repetitionField.getStyleClass().add("notvalid");
					warningText = warningText + "repetisjon er ugyldig\n";
				}

				//validates EndDate
				if (Controller.validateEndDate(dateEndField.getValue())) {
					System.out.println("endDate is valid");
					dateEndField.getStyleClass().add("valid");
				}
				else {
					System.out.println("endDate is not valid");
					dateEndField.getStyleClass().add("notvalid");
					warningText = warningText + "Sluttdato er ugyldig\n";
				}
*/
				warnings.setText(warningText);

			}

		});


		Scene scene = new Scene(grid, 600, 400, Color.rgb(227,201,176));
		scene.getStylesheets().add("file:stylesheet.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}


}
