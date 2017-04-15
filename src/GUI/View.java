package GUI;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import OldCode.ListOfCriteria;
import RooMe.Room;
import RooMe.RoomCriteria;
import RooMe.SearchForRoomDB;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	

	//static OldDatabase database = Controller.database;

	public static ArrayList<Room> roomlist = new ArrayList<Room>();
	
	//this runs when program starts
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("RooME");

		Scene scene = new Scene(loadScreenOne(), 900, 500);
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

		Text experimentable = new Text("Do you need hearing aid?");
		experimentable.getStyleClass().add("description");
		grid.add(experimentable, 0, 4);
				
		Text studentCount = new Text("How many students do you need space for?");
		studentCount.getStyleClass().add("description");
		grid.add(studentCount, 0, 5);
		
		Text dateText = new Text("Which date do you need the room?");
		dateText.getStyleClass().add("description");
		grid.add(dateText, 0, 6);
		
		Text fromTimeText = new Text("From what time do you need the room?");
		fromTimeText.getStyleClass().add("description");
		grid.add(fromTimeText, 0, 7);
		
		Text toTimeText = new Text("To what time do you need the room?");
		toTimeText.getStyleClass().add("description");
		grid.add(toTimeText, 0, 8);

		//add labels
		Text warnings = new Text("");
		warnings.getStyleClass().add("description");
		warnings.setId("warning");
		grid.add(warnings, 0, 9);
	
		//add inputs
		TextField nameField = new TextField();
		nameField.setMaxSize(150.0, 25.0);
		nameField.setMinSize(150.0, 25.0);
		grid.add(nameField,1,0);
		
		
		TextField mailField = new TextField();
		mailField.setMaxSize(150.0, 25.0);
		mailField.setMinSize(150.0, 25.0);
		grid.add(mailField,1,1);
		
		//A checkbox without a caption
		CheckBox cb1 = new CheckBox();
		grid.add(cb1,1,2);
		
		CheckBox cb2 = new CheckBox();
		grid.add(cb2,1,3);
		
		CheckBox cb3 = new CheckBox();
		grid.add(cb3,1,4);
		
		TextField amount = new TextField();
		amount.setMaxSize(150.0, 25.0);
		amount.setMinSize(150.0, 25.0);
		grid.add(amount, 1, 5);
			
		DatePicker dateField = new DatePicker();
		dateField.setMaxSize(150.0, 25.0);
		dateField.setMinSize(150.0, 25.0);
		grid.add(dateField, 1, 6);
		
		TextField fromTime = new TextField();
		fromTime.setMaxSize(150.0, 25.0);
		fromTime.setMinSize(150.0, 25.0);
		grid.add(fromTime, 1, 7);
		
		TextField toTime = new TextField();
		toTime.setMaxSize(150.0, 25.0);
		toTime.setMinSize(150.0, 25.0);
		grid.add(toTime, 1, 8);
	

		//make all unchecked at start
		cb1.setSelected(false);
		cb2.setSelected(false);
		cb3.setSelected(false);
		
		//add search button that triggers function when clicked
		Button searchButton = new Button("Search for rooms");
		searchButton.getStyleClass().add("button");
		grid.add(searchButton, 2, 7);

		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String warningText = "";
				
				if (Controller.validateName(nameField.getText()) == true) {
					if (((Controller.validateAmount(amount.getText())) == true) 
							&& (Controller.validateAmount(amount.getText()) == true) 
							&& (Controller.validateDate(dateField.getValue()) == true)
							&& (Controller.validateTime(fromTime.getText(), toTime.getText())) == true) {
						System.out.println(Controller.validateAmount(amount.getText()));
						
						//values saved to be used in database search in the making
						int capacity = Integer.parseInt(amount.getText());
						boolean button1 = cb1.isSelected(); //projector
						boolean button2 = cb2.isSelected(); //blackboard
						boolean button3 = cb3.isSelected(); //hearingaid
						String ftime = fromTime.getText();
						String ttime = toTime.getText();
						LocalDate date = dateField.getValue();
						
	/*					//checking what we have
						System.out.println(button1);
						System.out.println(button2);
						System.out.println(button3);
						System.out.println(ftime);
						System.out.println(ttime);
						System.out.println(date);			*/
						
						//searching with text inputs when everything is valid
						//SearchForRoom search = Controller.Search(database, capacity, button2, button3, button4); //, Controller.checkValue(cb4.isSelected()))
						try {
							Controller.Search(capacity, button1, button2, button3);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
								
						roomlist = SearchForRoomDB.acceptedRooms;
						
						//loading result page
						searchButton.getScene().setRoot(loadScreenSix());
					}
					else {
						if (Controller.validateAmount(amount.getText()) == false) {
							warningText += "You must choose how many you students you need capacity for \n"; 
						}
						if (Controller.validateDate(dateField.getValue()) == false) {
							warningText += "You must choose a date in the future \n";
						}
						if (Controller.validateTime(fromTime.getText(), toTime.getText()) == false) {
							warningText += "You must choose a endtime later than starttime \n";
						}
						warnings.setText(warningText);
					}
				}
				else {
		//			System.out.println(fromTime.getText() + toTime.getText());
					if (Controller.validateName(nameField.getText()) == false) {
						warningText += "You must write your name \n";
					}
					if (Controller.validateAmount(amount.getText()) == false) {
						warningText += "You must choose how many you students you need capacity for \n"; 
					}
					if (Controller.validateDate(dateField.getValue()) == false) {
						warningText += "You must choose a date in the future \n";
					}
					if (Controller.validateTime(fromTime.getText(), toTime.getText()) == false) {
						warningText += "You must choose a endtime later than starttime \n";
					}
					warnings.setText(warningText);
				}
			}	

		});
		
		//button to go back to first page
		Button backButton = new Button("Go back");
		backButton.getStyleClass().add("button");
		grid.add(backButton, 2, 0);
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

		Text experimentable = new Text("Do you need hearing aid?");
		experimentable.getStyleClass().add("description");
		grid.add(experimentable, 0, 4);
				
		Text studentCount = new Text("How many students do you need space for?");
		studentCount.getStyleClass().add("description");
		grid.add(studentCount, 0, 5);

		//add labels
		Text warnings = new Text("");
		fag.getStyleClass().add("description");
		grid.add(warnings, 1, 8);
				
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
				
		TextField amount = new TextField();
		amount.setMaxSize(150.0, 30.0);
		amount.setMinSize(150.0, 30.0);
		grid.add(amount, 1, 5);

		//make all unchecked at start
		cb1.setSelected(false);
		cb2.setSelected(false);
		cb3.setSelected(false);

//		ListOfCriteria criteriaList = new ListOfCriteria();
				
		//add search button that triggers function when clicked
		Button saveButton = new Button("Save your criteria");
		saveButton.getStyleClass().add("button");
		grid.add(saveButton, 1, 7);
				
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String warningText = "";
				warnings.setText(warningText);
				if ((Controller.validateName(nameField.getText()) == true) && (Controller.validateSubject(subjectField.getText()) == true )) {
					
					if ((Controller.validateAmount(amount.getText())) == true) {
						//values saved to be used in database search in the making
						String name = nameField.getText();
						String subject = subjectField.getText();
						int capacity = Integer.parseInt(amount.getText());
						boolean button1 = cb1.isSelected(); //projector
						boolean button2 = cb2.isSelected(); //blackboard
						boolean button3 = cb3.isSelected(); //hearingaid
						
			/*			//checking what we have
						System.out.println(button1);
						System.out.println(button2);
						System.out.println(button3);
						System.out.println(button4);
				*/		
						//searching with text inputs when everything is valid
						try {
							RoomCriteria.addRoomCriteria(name, subject, capacity, button1, button2, button3);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//showing results while programming
						RoomCriteria.getRoomCriterias();
						
						warningText = "Your criteria has been saved";
						warnings.setText(warningText);
					}
					else {
						warningText += "You must choose how many you students you need capacity for";
						warnings.setText(warningText);
					}
				}
				//when every field is okay we can continue
				else {
					if (Controller.validateName(nameField.getText()) == false) {
						warningText += "You must write your name \n";
					}
					if (Controller.validateAmount(amount.getText()) == false) {
						warningText += "You must choose how many you students you need capacity for \n"; 
					}
					if (Controller.validateSubject(subjectField.getText()) == false ) {
						warningText += "You must write which subject your teaching \n";
					}
					warnings.setText(warningText);
				}
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
									
			
		//		RoomCriteria crit = new RoomCriteria(Integer.parseInt((amount.getText())), Controller.checkValue(cb1.isSelected()), Controller.checkValue(cb2.isSelected()), Controller.checkValue(cb3.isSelected()), Controller.checkValue(cb2.isSelected()));
		//		criteriaList.addCriteria(crit);
						
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
			grid.add(room, 0, (i)+1);
			
			RadioButton rb = new RadioButton("");
			grid.add(rb,1,(i)+1);
		}
		
		//add labels
				Text warnings = new Text("");
				warnings.getStyleClass().add("description");
				grid.add(warnings, 2, 8);
				
			
				Text infoField = new Text("");
				infoField.getStyleClass().add("description");
				grid.add(infoField, 0, 0);
				
				String infotext = "Name | Capacity	| Projector	| Whiteboard	| Blackboard";
            	infoField.setText(infotext);
				
		//button to select room
				Button selectButton = new Button("Select");
				selectButton.getStyleClass().add("button");
				grid.add(selectButton, 2, 7);
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
		grid.add(backButton, 2, 0);
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