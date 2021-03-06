# TDT4140-Programvareutvikling
https://changelog.com/posts/a-beginners-guide-to-creating-a-readme
https://help.github.com/articles/basic-writing-and-formatting-syntax/
If you are just starting out with open source one of the most important things to include,
is good documentation. This starts with a solid README file. At its core a README should include:

# RooME

## Project information:
//What does your project do? Share the vision of the need that your project is trying to meet.

The project RooME is a school project at NTNU Gløshaugen, Norway, in the subject TDT4140 Programvareutvikling.
What we are trying to produce is a software system that gathers information from different people, intended to be lecturers at the university. With these criteria we attempt to produce a timetable that corresponds between the criteria from lecturers and the rooms in the institute.

The goal is to automate the process of planning a semester for every student and lecturer, 
reducing both time and cost of the process. Additional functionality is intended to be booking rooms for students.

   
## Setup:
//How is it set up? 
//If someone were to pick up your codebase today how would they get everything running in their local environment.

To have the program running as intended, 
you will first have to be connected to a NTNU-VPN so you can connect to our database.

Step 1: Connect to NTNU VPN.
Step 2: Run the RooME.jar file in terminal/cmd. Eventually import project into IDE of choice and run there.
Step 3: ?
Step 4: ?
Step 5: ?


## Usage:
//How is it used? Once it's up and running provide some very descriptive examples of usage.

When you run the program you will see the start page with 
certain buttons telling you which functions you can choose between.

The first button would provide the ability to search for an book a room within the database we have provided.

The second button is where to click if you want to fill in and save your criteria for lectures in a coming semester,
this is also the main functionality of our program. This is because these criteria is used for the timetables generated.

The third button is where you have to go to generate e timetable with every criteria in the database. This is secured by a password but there is no security hiding this.

The fourth button is used to check the timetable for a single person or for a room.

## Project shape:
//Is it in good shape? Do you have code climate, codeship,
//or other tools running to indicate the health of the project? Include information on dependencies as well.

As the three of us implementing the system are considered beginners in software engineering with ongoing studies, 
the project itself reflects this. Meaning both code climate, codeship and others aspects of our code should be considered
primitive and eventually full of errors or other faults. We have som basic automatic testing, we have reviewed most of the code manually and have some fault proofing, however there is a lot to be done on the project to reach a certain standard.

However the program works as intended, with minor to none errors.

## How to help
//How can others help? Collaboration yields amazing software. 
//Make it easy for others to get involved by letting them know how to submit new features, 
//report issues, or offer other assistance.

People outside our project group should not participate in the project until our deadline 27th of April 2017.
After this date those who want can contribute in different ways.

Our lack of experience is greatly impacting the visual design of our program, so there is a lot to be done in the actual graphics design. The design done in JavaFX isn't optimal for anything but user-testing in our development process. This could of course be improved, with both online web-connections and better local software as a solution.

We do not use any APIs at the moment, so the program could be better integrated with rooms in institutions that would like to use it. The rooms for our database is made manually by us.

The algorithm for both searching for rooms and producing a timetable for every room/Subject could be improved and optimized quite a lot. There is neither any way to find a room if the available rooms cannot cover all the criteria that is stored. The program only knows it cannot fulfill everything.

## Licenes Information
//License information Don't forget to let others know what license your project is released under. 
//Not sure? Oreilly has an open book on understanding licensing.

The project is not released under any licenses.
