package GUI;

import RooMe.Database;
import RooMe.SearchForRoom;
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

		Text whiteboard = new Text("Trenger du blackboard?");
		whiteboard.getStyleClass().add("description");
		grid.add(whiteboard, 0, 2);

		Text blackboard = new Text("Trenger du whiteboard?");
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
		
		//add labels
		Text resultRooms = new Text("");
		fag.getStyleClass().add("description");
		grid.add(resultRooms, 1, 9);

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

		//make all unchecked at start
		cb1.setSelected(false);
		cb2.setSelected(false);
		cb3.setSelected(false);
		cb4.setSelected(false);
		
		Database database = new Database("Test");
		
		//add search button that triggers function when clicked
		Button myButton = new Button("Søk etter rom");
		myButton.getStyleClass().add("button");
		grid.add(myButton, 1, 7);

		myButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				//warningstring and room result
				String warningText = "";
				String roomText = "";

				//clear all css //not in use
				fag.getStyleClass().removeAll("valid,", "notvalid");
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
			/*	
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
				*/

				warnings.setText(warningText);
				
				if ((amount.getText()).equals("")) {
					amount.setText("0");
					
					warningText = warningText + "Du må velge et antall elever du trenger rom til\n";
					warnings.setText(warningText);
				}
				
				//searching with text inputs
				SearchForRoom test = new SearchForRoom(database, Integer.parseInt((amount.getText())), Controller.checkValue(cb1.isSelected()), Controller.checkValue(cb2.isSelected()), Controller.checkValue(cb3.isSelected()));//, Controller.checkValue(cb4.isSelected()));
				//Database database, int space, boolean projector, boolean blackboard, boolean whiteboard
				//test.IterateList();
				roomText = test.acceptedRooms.toString();
				resultRooms.setText(roomText);

			}

		});


		Scene scene = new Scene(grid, 600, 400, Color.rgb(227,201,176));
		scene.getStylesheets().add("file:stylesheet.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}


}
