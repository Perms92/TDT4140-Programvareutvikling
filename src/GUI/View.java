package GUI;

import java.util.ArrayList;

import RooMe.Database;
import RooMe.ListOfCriteria;
import RooMe.Room;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	static Database database = Controller.database;
	public static ArrayList<Room> roomlist = new ArrayList<Room>();
	
	//this runs when program starts
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("RooME");

		Scene scene = new Scene(loadScreenOne(), 800, 400);
		scene.getStylesheets().add("file:stylesheet.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	//first page in program, our menu
	public static GridPane loadScreenOne() {
		//start grid
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(30, 30, 30, 30));
				
		//add labels
		Text headline = new Text("Choose what you want to do");	
		headline.setId("headline");
		headline.getStyleClass().add("description");
		grid.add(headline, 0, 0);
		
		//add a button that goes into room booking
		Button bookButton = new Button("Book a room");
		bookButton.getStyleClass().add("button");
		bookButton.setMinSize(200.0,30.0);
		bookButton.setMaxSize(200.0,30.0);
		grid.add(bookButton, 0, 3);

		bookButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//opening book room window
				bookButton.getScene().setRoot(loadScreenTwo());
				
			}
		});
		
		//add a button that goes into criteria saving
		Button saveButton = new Button("Add your lecture criteria");
		saveButton.getStyleClass().add("button");
		saveButton.setMinSize(200.0,30.0);
		saveButton.setMaxSize(200.0,30.0);
		grid.add(saveButton, 0, 4);

		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//starting a new site to add criteria
				saveButton.getScene().setRoot(loadScreenThree());
			
			}
		});
		
		//add a button that goes into criteria saving
		Button editButton = new Button("Edit a previous request");
		editButton.getStyleClass().add("button");
		editButton.setMinSize(200.0,30.0);
		editButton.setMaxSize(200.0,30.0);
		grid.add(editButton, 0, 5);

		editButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//going into the edit request view
				editButton.getScene().setRoot(loadScreenFour());
						
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
		Button testButton = new Button("Help!");
		testButton.getStyleClass().add("button");
		testButton.setMinSize(200.0,30.0);
		testButton.setMaxSize(200.0,30.0);
		grid.add(testButton, 0, 6);

		testButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//opening book room window
				bookButton.getScene().setRoot(loadScreenFive());
				
			}
		});
		
		return grid;
	}
	
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
		
				
		Text fag = new Text("What is your email-adress?");
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

		Text experimentable = new Text("Do you need hearing aid?");
		experimentable.getStyleClass().add("description");
		grid.add(experimentable, 0, 5);
				
		Text studentCount = new Text("How many students do you need space for?");
		studentCount.getStyleClass().add("description");
		grid.add(studentCount, 0, 6);

		//add labels
		Text warnings = new Text("");
		warnings.getStyleClass().add("description");
		grid.add(warnings, 1, 8);
	
		//add inputs
		TextField nameField = new TextField();
		nameField.setMaxSize(150.0, 30.0);
		nameField.setMinSize(150.0, 30.0);
		grid.add(nameField,1,0);
		
		
		TextField mailField = new TextField();
		mailField.setMaxSize(150.0, 30.0);
		mailField.setMinSize(150.0, 30.0);
		grid.add(mailField,1,1);
		
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
		amount.setMaxSize(150.0, 30.0);
		amount.setMinSize(150.0, 30.0);
		grid.add(amount, 1, 6);

		//make all unchecked at start
		cb1.setSelected(false);
		cb2.setSelected(false);
		cb3.setSelected(false);
		cb4.setSelected(false);
		
		//add search button that triggers function when clicked
		Button searchButton = new Button("Search for rooms");
		searchButton.getStyleClass().add("button");
		grid.add(searchButton, 1, 7);

		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String warningText = "";
			
				if (Controller.validateName(mailField.getText()) == true) {
					if ((Controller.validateAmount(amount.getText())) == true) {
						System.out.println(Controller.validateAmount(amount.getText()));
						
						//values saved to be used in database search in the making
						int capacity = Integer.parseInt(amount.getText());
						boolean button1 = cb1.isSelected(); //projector
						boolean button2 = cb2.isSelected(); //blackboard
						boolean button3 = cb3.isSelected(); //whiteboard
						boolean button4 = cb4.isSelected(); //hearingaid
						
						//checking what we have
						System.out.println(button1);
						System.out.println(button2);
						System.out.println(button3);
						System.out.println(button4);
						
						//searching with text inputs when everything is valid
						SearchForRoom search = Controller.Search(database, capacity, button2, button3, button4); //, Controller.checkValue(cb4.isSelected()))
	
						roomlist = SearchForRoom.acceptedRooms;
						
						//loading result page
						searchButton.getScene().setRoot(loadScreenSix());
					}
					else {
						warningText += "You must choose how many you students you need capacity for";
						warnings.setText(warningText);
					}
				}
				//when every field is okay we can continue
				else {
					if (Controller.validateName(mailField.getText()) == false) {
						warningText += "You must write your name \n";
					}
					if (Controller.validateAmount(amount.getText()) == false) {
						warningText += "You must choose how many you students you need capacity for"; 
					}
					warnings.setText(warningText);
				}
			}	

		});
		
		//button to go back to first page
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
	//			System.out.println(criteriaList.getCriteria(0));
						
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
	
	//this page is the edit a previous request //currently not in use
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
 
	//this page is a test page
	public static GridPane loadScreenFive() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(30, 30, 30, 30));
		
		
		Text projector = new Text("Under construction?");
		projector.getStyleClass().add("description");
		grid.add(projector, 0, 2);
		
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

	// showing rooms result from search
	public static GridPane loadScreenSix() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(30, 30, 30, 30));
		
		//trying to write every acceptable room in GUI
		for (int i = 0; i < roomlist.size(); i++) {
			
			Text room = new Text(roomlist.get(i).toString());
			room.getStyleClass().add("description"); //find out what this does
			grid.add(room, 0, i);
			
			RadioButton rb = new RadioButton("");
			grid.add(rb,1,i);
		}
		
		//add labels
				Text warnings = new Text("");
				warnings.getStyleClass().add("description");
				grid.add(warnings, 1, 8);
				
		//button to select room
				Button selectButton = new Button("Select");
				selectButton.getStyleClass().add("button");
				grid.add(selectButton, 1, 7);
		        selectButton.setOnAction(new EventHandler<ActionEvent>() {

		            @Override
		            public void handle(ActionEvent arg0) {
		            	//warningstring and room result
						
		            	System.out.println("Your room has been booked");
		            	
		            	String warningText = "Your room has been booked";
		            	warnings.setText(warningText);
		            }
		        });
		
		//button to go back into serach
		Button backButton = new Button("Go back");
		backButton.getStyleClass().add("button");
		grid.add(backButton, 0, 7);
        backButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                backButton.getScene().setRoot(loadScreenTwo());             
            }
        });
		return grid;
	}


//end tag
}