Read me RooMe

Here is some information about the different classes
and how they work in the program


Person.java
This class creates a person as that person makes a profile
It takes a series of variables that makes the person
The variables are: name, proffesion (student/lecturer), person ID.

RoomCriteria.java
This class takes in the criterias a lecturer have for a room.
It takes in if the lecturer needs projector, white- and blackboard,
experiment table, and how many students he expects.

Database.java
This is a class that makes 5 rooms so we can use to test our functions in the program.
The plan is to exchange this class with SQL database.

SearchForRoom.java
This is a class where you can search for rooms with special criteria, 
or you can check which rooms has certain functions.

Room.java
This is the objects that our system should handle, searching for and comparing with each other

GetRoom.java
Denne klassen kombinerer input fra RoomCriteria med søkefunksjonen i SearchForRoom og henter ut passende rom fra Database.java

Classes not in use:
RoomList.java
sokRom.java
Subject.java
WeekplanTimetable.java
TimeTable.java
Main.java