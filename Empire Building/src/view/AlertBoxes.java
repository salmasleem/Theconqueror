package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBoxes {
	//method that pops an alert window if you don't enter a player name
     public static void noName(String title, String message) {
    	 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     
     
   //method that pops an alert window if the turn count reaches 50
     public static void turnsExceeded(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     
     //method that pops an alert window if the player did not choose a city 
     public static void noCity (String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     
   //NotEnoughGoldException
     public static void NotEnoughGoldException(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     
   //BuildingInCoolDownException
     public static void BuildingInCoolDownException(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     //MaxLevelException
     public static void MaxLevelException(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     
   //MaxRecruitedException
     public static void MaxRecruitedException(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     public static void youWon(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     
     public static void youLost(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     //MaxCapacityException
     public static void MaxCapacityException(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     //TargetNotReachedException
     public static void TargetNotReachedException(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     //FriendlyCityException
     public static void FriendlyCityException(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
     //FriendlyFireException
     public static void FriendlyFireException(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
   //EmptyChoiceBox
     public static void EmptyChoiceBox(String title, String message) {
 Stage window = new Stage();
    	 
    	 window.initModality(Modality.APPLICATION_MODAL);
    	 window.setTitle(title);
    	 window.setMinWidth(250);
    	 
    	 Label label = new Label();
    	 label.setText(message);
//    	 Button closeButton = new Button("Close the Window");
//    	 closeButton.setOnAction(e-> window.close());
//    	 
    	 VBox layout = new VBox(10);
    	 layout.getChildren().addAll(label);
    	 layout.setAlignment(Pos.CENTER);
    	 
    	 Scene scene = new Scene(layout);
    	 window.setScene(scene);
    	 window.showAndWait();
     }
}