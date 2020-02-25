/*
 * Ramon E Almonte 
 * CIS 166 - Java Programming 
 * This program create a Graphical User Interface
 * that simulate a slot machine. In this GUI the user have option 
 * to input a money amount they want to bet. If two images showed on the 
 * slot machine match the money inputed will multiply times 2 and if all
 * three images match the money inputed will be multiple times 3.
 * 
 */



import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SlotMachine extends Application 
{
	private Image[] ImageArray;
	private double spinPoints;
	private double totalPoints;
	private Random randInt;
	private int randImage1;
	private int randImage2;
	private int randImage3;
	private ImageView image1;
	private ImageView image2;
	private ImageView image3;
	HBox imagesBox;
	VBox pointsBox;
	TextField inputField;
	private Label spinPointsLabel;
	private Label totalPointsLabel;
	

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		launch (args);

	}
	
	
	/**
	 * The method start is an abstract method from the Application class
	 * and must be Overridden. 
	 * This method takes an Stage value as the argument.
	 * This method handle all of the controls, containers and the 
	 * "Scene" of the application. 
	 * 
	 */
	
	
	public void start(Stage machine)
	{
		// 1. setting up the controls
		String inputMessage;
		
		 // the fields spintPoints manage the points system of the game
		 spinPoints = 0;
		 totalPoints = 0;
		
		 // messages to be constantly shown on the input label.
		 // the fields for the points are going to update everyrun.
		String showSpinPoints = "Amount won this spin: " + spinPoints;
		String showTotalPoints = "Total Amount won: " + totalPoints;
		
		inputMessage = "Enter a money amount: $";
		Label moneyInput = new Label(inputMessage);
		spinPointsLabel = new Label(showSpinPoints);
		totalPointsLabel = new Label (showTotalPoints);
		
		// the object input field manage the input
		inputField = new TextField();
		
		// creating the button object.
		Button spinBotton = new Button ("Spin");
		spinBotton.setOnAction(new spinButtonHandler());
		
		
		// Creating an Array of image of size ten;
		final int ArraySize = 10;
		////Image[] ImageArray = new Image[ArraySize];
		ImageArray = new Image[ArraySize];
		ImageArray[0] = new Image ("File:Apple.png");
		ImageArray[1] = new Image ("File:Banana.png");
		ImageArray[2] = new Image ("File:Cherries.png");
		ImageArray[3] = new Image ("File:Grapes.png");
		ImageArray[4] = new Image ("File:Lemon.png");
		ImageArray[5] = new Image ("File:Lime.png");
		ImageArray[6] = new Image ("File:Orange.png");
		ImageArray[7] = new Image ("File:Strawberry.png");
		ImageArray[8] = new Image ("File:Pear.png");
		ImageArray[9] = new Image ("File:Watermelon.png");
		
		
		
		randInt = new Random();
		
		// These variables temporary the picture to be shown 
		// on the application. All three pictures are randomly
		// selected from the array of images 
		randImage1 = randInt.nextInt(ArraySize);
		randImage2 = randInt.nextInt(ArraySize);
		randImage3 = randInt.nextInt(ArraySize); 
		
		
		// the imageView objects takes the randomly selected images as the parameters
		// the pictures will be update on every spin.
		image1 = new ImageView (ImageArray[randImage1]);
		
		image2 = new ImageView (ImageArray[randImage2]);
		
		image3 = new ImageView (ImageArray[randImage3]);
		
		// 2. Container 
		
		// The layout of this application consists on three boxes placed
		// inside a Grid pane creating a 3 X 3 matrix.
		// the top row contain the three randomly selected pictures
		// on the left the input session
		// on the bottom center the spin bottom is located
		// on the right display the score.
		
		
		imagesBox = new HBox(15); // 15 represent the spacing 
		
		imagesBox.getChildren().addAll(image1, image2, image3);
		imagesBox.setPadding(new Insets(25));
		
	
		HBox inputBox = new HBox(moneyInput, inputField);
		
		inputBox.setAlignment(Pos.CENTER_RIGHT);
		inputBox.setPadding(new Insets(10));
		
		pointsBox = new VBox(spinPointsLabel,  totalPointsLabel );
		pointsBox.setAlignment(Pos.CENTER_RIGHT);
		pointsBox.setPadding(new Insets(10));
		
		
		
		HBox button = new HBox (spinBotton);
		button.setAlignment(Pos.CENTER);
		
		
		
		GridPane layout = new GridPane();
		GridPane.setConstraints(imagesBox, 1, 0);
		GridPane.setConstraints(pointsBox, 2, 1);
		GridPane.setConstraints(button, 1, 2); 
		GridPane.setConstraints(inputBox, 0, 1);
		
		layout.getChildren().addAll(imagesBox,inputBox, pointsBox, button);
		
		
		
		// 3. setting up the scene
		
		// the imageSene contain the grid Pane
		// display the application layout
		Scene imageScene = new Scene (layout, 1000, 285);
		
		// 4. Setting up the stage
		
		// the machine stage shows the app 
		
		machine.setScene(imageScene);
		
		machine.setTitle("Slot Machine");
		machine.show();

	}
	
	
	/**
	 * This class handle the spin button. 
	 * When the spin is press the method handle from the 
	 * abstract class EventHandler will choose three different images
	 * from the array of images and update the imageBox HBox. 
	 * Also this method will update the labels spinPoints and total points.
	 * 
	 * This class also handle the points system of the game. 
	 * if two image are the same the program will multiply
	 * the input times two as the points for that spin,
	 *  and if all images are the same the program will multiply the input times 3
	 *  as the points value. 
	 * 
	 * @author ramonalmonte03
	 *
	 */
	class spinButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			int size = 10;
			String input;
			double moneyInputed;
			String showSpinPoints;
			String showTotalPoints;
			
			
			
			
			randImage1 = randInt.nextInt(size);
			randImage2 = randInt.nextInt(size);
			randImage3 = randInt.nextInt(size);
			
			// the data obtain from the input needed to be
			// a double before any calculate can be done
			
			input = inputField.getText();
			moneyInputed = Double.parseDouble(input);
			
			// the maximum points the user can obtain if all images are the same
			
			
			if (randImage1 == randImage2 && randImage2 == randImage3 )
			{
				spinPoints = moneyInputed * 3;
				totalPoints += spinPoints;
				
			}
			
			// This condition check is two images are the same
			
			
			else if ( (randImage1 == randImage2) || (randImage2 == randImage3) ||  (randImage1 == randImage3))
			{
				spinPoints = moneyInputed * 2;
				totalPoints += spinPoints;
			}
			
			// else the spinPoints for that spin is zero.
			else
			{
				spinPoints = 0;
				totalPoints += spinPoints;
			}
			
			showSpinPoints = "Amount won this spin: " + spinPoints;
			showTotalPoints = "Total Amount won: " + totalPoints;
			
			// pass the new selected images to the imageView to be 
			// display on the scene.
			
			image1 = new ImageView (ImageArray[randImage1]);
			image2 = new ImageView (ImageArray[randImage2]);
			image3 = new ImageView (ImageArray[randImage3]);
			
			// updating the containers and labels
			imagesBox.getChildren().clear();
			imagesBox.getChildren().addAll(image1,image2,image3);
			
			spinPointsLabel = new Label(showSpinPoints);
			totalPointsLabel = new Label (showTotalPoints);
			
			pointsBox.getChildren().clear();
			pointsBox.getChildren().addAll(spinPointsLabel,totalPointsLabel );
		
		}
	}

}
