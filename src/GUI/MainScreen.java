package GUI;

import RooMe.Database;
import RooMe.ListOfCriteria;
import RooMe.RoomCriteria;
import RooMe.SearchForRoom;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainScreen extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	/*
	//must make database outside functions to avoid duplicates
	static Database database = new Database("Test");
	*/
	
	//this runs when program starts
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("RooME");

		Scene scene = new Scene(Controller.loadScreenOne(), 800, 400);
		scene.getStylesheets().add("file:stylesheet.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

/*	
	//first page in program, our menu
	public static GridPane loadScreenOne() {
		//start grid
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(30, 30, 30, 30));
				
		//add labels
		Text fag = new Text("Choose what you want to do");			
		fag.getStyleClass().add("description");
		grid.add(fag, 0, 0);
		
		//add a button that goes into room booking
		Button bookButton = new Button("Book a room");
		bookButton.getStyleClass().add("button");
		grid.add(bookButton, 0, 3);

		bookButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//opening book room window
				bookButton.getScene().setRoot(Controller.loadScreenTwo());
				
			}
		});
		
		//add a button that goes into criteria saving
		Button saveButton = new Button("Add your lecture criteria");
		saveButton.getStyleClass().add("button");
		grid.add(saveButton, 0, 4);

		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//starting a new site to add criteria
				saveButton.getScene().setRoot(Controller.loadScreenThree());
			
			}
		});
		
		//add a button that goes into criteria saving
		Button editButton = new Button("Edit a previous request");
		editButton.getStyleClass().add("button");
		grid.add(editButton, 0, 5);

		editButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//going into the edit request view
				editButton.getScene().setRoot(Controller.loadScreenFour());
						
			}
		});
		
		final Button button = new Button("Back");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				button.getScene().setRoot(loadScreenOne());             
			}
		});
		
		//testbutton
		Button testButton = new Button("Test");
		testButton.getStyleClass().add("button");
		grid.add(testButton, 0, 6);

		testButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//opening book room window
				bookButton.getScene().setRoot(Controller.loadScreenFive());
				
			}
		});
		
		return grid;
	}
	*/
	/*
	//this page is the book room page
	public static GridPane loadScreenTwo() {
        
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(30, 30, 30, 30));

		//add labels
		Text name = new Text("What is your name?");
		name.getStyleClass().add("description");
		grid.add(name, 0, 0);
		*/
	/*			
		Text fag = new Text("What do you need?");
		fag.getStyleClass().add("description");
		grid.add(fag, 0, 1);
*/
	/*
		Text projector = new Text("Do you need a projector?");
		projector.getStyleClass().add("description");
		grid.add(projector, 0, 2);

		Text whiteboard = new Text("Do you need a blackboard?");
		whiteboard.getStyleClass().add("description");
		grid.add(whiteboard, 0, 3);
				
		Text blackboard = new Text("Do you need a whiteboard?");
		blackboard.getStyleClass().add("description");
		grid.add(blackboard, 0, 4);

		Text experimentable = new Text("TBA?");
		experimentable.getStyleClass().add("description");
		grid.add(experimentable, 0, 5);
				
		Text studentCount = new Text("How many students do you need space for?");
		studentCount.getStyleClass().add("description");
		grid.add(studentCount, 0, 6);

		Text ny2 = new Text("TBA");
		ny2.getStyleClass().add("description");
		grid.add(ny2, 0, 7);


		//add labels
		Text warnings = new Text("");
		warnings.getStyleClass().add("description");
		grid.add(warnings, 1, 8);
		
		//add labels
		Text resultRooms = new Text("");
		resultRooms.getStyleClass().add("description");
		grid.add(resultRooms, 1, 9);

		//add inputs
		TextField nameField = new TextField();
		nameField.setMaxSize(150.0, 30.0);
		nameField.setMinSize(150.0, 30.0);
		grid.add(nameField,1,0);
		
		//A checkbox without a caption
		CheckBox cb1 = new CheckBox();
		grid.add(cb1,1,1);
		
		CheckBox cb2 = new CheckBox();
		grid.add(cb2,1,2);
		
		CheckBox cb3 = new CheckBox();
		grid.add(cb3,1,3);
		
		CheckBox cb4 = new CheckBox();
		grid.add(cb4,1,4);
		
		CheckBox cb5 = new CheckBox();
		grid.add(cb5,1,5);
		
		TextField amount = new TextField();
		amount.setMaxSize(150.0, 30.0);
		amount.setMinSize(150.0, 30.0);
		grid.add(amount, 1, 6);

		//make all unchecked at start
		cb1.setSelected(false);
		cb2.setSelected(false);
		cb3.setSelected(false);
		cb4.setSelected(false);
		
		//add search button that triggers function when clicked
		Button myButton = new Button("Search for rooms");
		myButton.getStyleClass().add("button");
		grid.add(myButton, 1, 7);

		myButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				//warningstring and room result
				String warningText = "";
				String roomText = ""; //must show the accepted rooms in another way
				
				if ((amount.getText()).equals("")) {
					amount.setText("0");
						
					warningText = warningText + "You have to select how many students you need space for\n";
					warnings.setText(warningText);
				}

				//validates name
				if (Controller.validateName(nameField.getText())) {
					nameField.getStyleClass().add("valid");
				}
				else {
					name.getStyleClass().add("notvalid");
					warningText = warningText + "You must write your name\n";
				}
	
				warnings.setText(warningText);
				
				if ((amount.getText()).equals("")) {
					amount.setText("0");
					
					warningText = warningText + "You must choose how many people you need space for\n";
					warnings.setText(warningText);
				}
				
				//searching with text inputs
				SearchForRoom test = new SearchForRoom(database, Integer.parseInt((amount.getText())), Controller.checkValue(cb1.isSelected()), Controller.checkValue(cb2.isSelected()), Controller.checkValue(cb3.isSelected()));//, Controller.checkValue(cb4.isSelected()))
	//have to make a better result view		
	//			roomText = test.acceptedRooms.toString();
				System.out.println("Det er så mange godkjente rom: " + test.acceptedRooms.size());
				
				//Have to stop this from being to wide
				//resultRooms.setMaxSize(100.0,100.0)
				resultRooms.setText(roomText);
			}

		});
		
		Button backButton = new Button("Go back");
		backButton.getStyleClass().add("button");
		grid.add(backButton, 0, 7);
        backButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                backButton.getScene().setRoot(loadScreenOne());             
            }
        });
		return grid;
    }
*/
/*	
	//this page is the page to save criteria
	public static GridPane loadScreenThree() {
        
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(30, 30, 30, 30));

		//add labels
		Text name = new Text("What is your name?");
		name.getStyleClass().add("description");
		grid.add(name, 0, 0);
				
		Text fag = new Text("Which subject are you teaching?");
		fag.getStyleClass().add("description");
		grid.add(fag, 0, 1);

		Text projector = new Text("Do you need a projector?");
		projector.getStyleClass().add("description");
		grid.add(projector, 0, 2);

		Text whiteboard = new Text("Do you need a blackboard?");
		whiteboard.getStyleClass().add("description");
		grid.add(whiteboard, 0, 3);
				
		Text blackboard = new Text("Do you need a whiteboard?");
		blackboard.getStyleClass().add("description");
		grid.add(blackboard, 0, 4);

		Text experimentable = new Text("TBA?");
		experimentable.getStyleClass().add("description");
		grid.add(experimentable, 0, 5);
				
		Text studentCount = new Text("How many students do you need space for?");
		studentCount.getStyleClass().add("description");
		grid.add(studentCount, 0, 6);

		Text ny2 = new Text("TBA");
		ny2.getStyleClass().add("description");
		grid.add(ny2, 0, 7);


		//add labels
		Text warnings = new Text("");
		fag.getStyleClass().add("description");
		grid.add(warnings, 1, 8);
				
		//add labels
		Text resultRooms = new Text("");
		fag.getStyleClass().add("description");
		grid.add(resultRooms, 1, 9);

		//add inputs
		TextField nameField = new TextField();
		nameField.setMaxSize(150.0, 30.0);
		nameField.setMinSize(150.0, 30.0);
		grid.add(nameField,1,0);
				
		TextField subjectField = new TextField();
		subjectField.setMaxSize(150.0, 30.0);
		subjectField.setMinSize(150.0, 30.0);
		grid.add(subjectField,1,1);
				
		//A checkbox without a caption
		CheckBox cb1 = new CheckBox();
		grid.add(cb1,1,2);
				
		CheckBox cb2 = new CheckBox();
		grid.add(cb2,1,3);
		
		CheckBox cb3 = new CheckBox();
		grid.add(cb3,1,4);
				
		CheckBox cb4 = new CheckBox();
		grid.add(cb4,1,5);
				
		TextField amount = new TextField();
		amount.setMaxSize(200.0, 30.0);
		amount.setMinSize(200.0, 30.0);
		grid.add(amount, 1, 6);

		//make all unchecked at start
		cb1.setSelected(false);
		cb2.setSelected(false);
		cb3.setSelected(false);
		cb4.setSelected(false);

		ListOfCriteria criteriaList = new ListOfCriteria();
				
		//add search button that triggers function when clicked
		Button saveButton = new Button("Save your criteria");
		saveButton.getStyleClass().add("button");
		grid.add(saveButton, 1, 7);
				
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			//feilhåndtering før funksjoner
				String warningText = "";
						
				warnings.setText(warningText);
						
				if ((amount.getText()).equals("")) {
					amount.setText("0");
						
					warningText = warningText + "You have to select how many students you need space for\n";
					warnings.setText(warningText);
				}
				
				//validates name
				if (Controller.validateName(nameField.getText())) {
					nameField.getStyleClass().add("valid");
		//			System.out.println("whyText is valid");
				}
				else {
		//			System.out.println("whytext is not valid");
					name.getStyleClass().add("notvalid");
					warningText = warningText + "You must write your name\n";
				}
				
				//validates subject
				if (Controller.validateName(subjectField.getText())) {
					subjectField.getStyleClass().add("valid");
		//			System.out.println("whyText is valid");
				}
				else {
		//			System.out.println("whytext is not valid");
					subjectField.getStyleClass().add("notvalid");
					warningText = warningText + "You must write which subject you're lecturing\n";
				}
									
			
				RoomCriteria crit = new RoomCriteria(Integer.parseInt((amount.getText())), Controller.checkValue(cb1.isSelected()), Controller.checkValue(cb2.isSelected()), Controller.checkValue(cb3.isSelected()), Controller.checkValue(cb2.isSelected()));
				criteriaList.addCriteria(crit);
						
				//iterate through all criterias}
				System.out.println(criteriaList.getCriteria(0));
						
			}
		});

		
		Button backButton = new Button("Go back");
		backButton.getStyleClass().add("button");
		grid.add(backButton, 0, 7);
        backButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                backButton.getScene().setRoot(loadScreenOne());             
            }
        });
		return grid;
    }
	*/
	/* //this page is the edit a previous request //currently not in use
	public static GridPane loadScreenFour() {
        
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(30, 30, 30, 30));

		//add labels
		Text name = new Text("What is your name?");
		name.getStyleClass().add("description");
		grid.add(name, 0, 0);
				
		Text fag = new Text("Which subject are you teaching?");
		fag.getStyleClass().add("description");
		grid.add(fag, 0, 1);

		Text projector = new Text("Trenger du projector?");
		projector.getStyleClass().add("description");
		grid.add(projector, 0, 2);

		Text whiteboard = new Text("Trenger du blackboard?");
		whiteboard.getStyleClass().add("description");
		grid.add(whiteboard, 0, 3);
				
		Text blackboard = new Text("Trenger du whiteboard?");
		blackboard.getStyleClass().add("description");
		grid.add(blackboard, 0, 4);

		Text experimentable = new Text("Trenger du å gjøre eksperiment?");
		experimentable.getStyleClass().add("description");
		grid.add(experimentable, 0, 5);
				
		Text studentCount = new Text("Hvor mange elever har du?");
		studentCount.getStyleClass().add("description");
		grid.add(studentCount, 0, 6);

		Text ny2 = new Text("TBA");
		ny2.getStyleClass().add("description");
		grid.add(ny2, 0, 7);


		//add labels
		Text warnings = new Text("");
		fag.getStyleClass().add("description");
		grid.add(warnings, 1, 8);
				
		//add labels
		Text resultRooms = new Text("");
		fag.getStyleClass().add("description");
		grid.add(resultRooms, 1, 9);

		//add inputs
		TextField nameField = new TextField();
		nameField.setMaxSize(200.0, 30.0);
		nameField.setMinSize(200.0, 30.0);
		grid.add(nameField,1,0);
				
		TextField subjectField = new TextField();
		subjectField.setMaxSize(200.0, 30.0);
		subjectField.setMinSize(200.0, 30.0);
		grid.add(subjectField,1,1);
				
		//A checkbox without a caption
		CheckBox cb1 = new CheckBox();
		grid.add(cb1,1,2);
				
		CheckBox cb2 = new CheckBox();
		grid.add(cb2,1,3);
		
		CheckBox cb3 = new CheckBox();
		grid.add(cb3,1,4);
				
		CheckBox cb4 = new CheckBox();
		grid.add(cb4,1,5);
				
		TextField amount = new TextField();
		amount.setMaxSize(200.0, 30.0);
		amount.setMinSize(200.0, 30.0);
		grid.add(amount, 1, 6);

		//make all unchecked at start
		cb1.setSelected(false);
		cb2.setSelected(false);
		cb3.setSelected(false);
		cb4.setSelected(false);

		ListOfCriteria criteriaList = new ListOfCriteria();
				
		//add search button that triggers function when clicked
		Button saveButton = new Button("Save your criteria");
		saveButton.getStyleClass().add("button");
		grid.add(saveButton, 1, 7);
				
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			//feilhåndtering før funksjoner
				String warningText = "";
						
				warnings.setText(warningText);
						
				if ((amount.getText()).equals("")) {
					amount.setText("0");
						
					warningText = warningText + "You have to select how many students you need space for\n";
					warnings.setText(warningText);
				}
									
			
				RoomCriteria crit = new RoomCriteria(Integer.parseInt((amount.getText())), Controller.checkValue(cb1.isSelected()), Controller.checkValue(cb2.isSelected()), Controller.checkValue(cb3.isSelected()), Controller.checkValue(cb2.isSelected()));
				criteriaList.addCriteria(crit);
						
				//iterate through all criterias}
				System.out.println(criteriaList.getCriteria(0));
						
			}
		});

		
		Button backButton = new Button("Go back");
		backButton.getStyleClass().add("button");
		grid.add(backButton, 0, 7);
        backButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                backButton.getScene().setRoot(loadScreenOne());             
            }
        });
		return grid;
    }
    */
}