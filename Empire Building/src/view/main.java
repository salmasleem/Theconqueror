package view;

import java.io.IOException;
import java.util.ArrayList;

import buildings.Barracks;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.Stable;
import engine.City;
import engine.Game;
import engine.Player;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;
import exceptions.*;

public class main extends Application   
{

	Game game;
	Button startButton ;
	Button startGame  ;
	Button Conquer ;
	ToggleButton cairo ;
	ToggleButton rome ;
	ToggleButton sparta ;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception 
	{
		
		window.setTitle("Let's Play");
		startingScenes(window);
		window.setResizable(false);
		window.show();

	}
	
	public void startGame(String n, String c) throws IOException {
		game  = new Game(n,c);
	}
	
	public void startingScenes (Stage window) {
		startButton= new Button();
		startButton.setText("Start Game");
		startButton.setPrefSize(100, 100); // change size of button 
		startButton.setStyle("-fx-font-size:15"); // change size of text in button 
		startButton.setEffect(new DropShadow());
		
		startGame = new Button();
		startGame.setText("Next ");
		startGame.setPrefSize(200, 50); // change size of button 
		startGame.setStyle("-fx-font-size:15"); // change size of text in button 
		
		cairo = new ToggleButton ();
		cairo.setText("CAIRO");
		cairo.setPrefSize(300, 50); // change size of button 
		cairo.setStyle("-fx-font-size:15"); // change size of text in button 
		
		rome = new ToggleButton ();
		rome.setText("ROME");
		rome.setPrefSize(300, 50); // change size of button 
		rome.setStyle("-fx-font-size:15"); // change size of text in button 
		
		sparta = new ToggleButton ();
		sparta.setText("SPARTA");
		sparta.setPrefSize(300, 50); // change size of button 
		sparta.setStyle("-fx-font-size:15"); // change size of text in button 
		
		Conquer = new Button();
		Conquer.setText("LET'S CONQUER !");
		Conquer.setPrefSize(200, 50); // change size of button 
		Conquer.setStyle("-fx-font-size:15"); // change size of text in button 
		Conquer.setEffect(new DropShadow());
		
		ToggleGroup cities = new ToggleGroup();
		cairo.setToggleGroup(cities);
		rome.setToggleGroup(cities);
		sparta.setToggleGroup(cities);
		

		Label nameLabel = new Label("Player Name :");
		nameLabel.setStyle("-fx-font-size:24");
		TextField playerName = new TextField ("");
		playerName.setPromptText("Player Name ");
	
		Label cityLabel = new Label(" Player City   :");

		Image startImage = new Image("file:visuals/Opening.jpeg");
		ImageView startview = new ImageView(startImage);
		Group startg = new Group();
		startg.getChildren().addAll(startview);
        final DoubleProperty width = startview.fitWidthProperty();
        final DoubleProperty height = startview.fitHeightProperty();
        width.bind(Bindings.selectDouble(startview.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(startview.sceneProperty(), "height"));
        

		Image playername = new Image("file:visuals/sahab.jpeg");
		ImageView playernameview = new ImageView(playername);
		Group playernameg = new Group();
		playernameg.getChildren().addAll(playernameview);
		final DoubleProperty width1 = playernameview.fitWidthProperty();
	    final DoubleProperty height1 = playernameview.fitHeightProperty();
	    width1.bind(Bindings.selectDouble(playernameview.sceneProperty(), "width"));
	    height1.bind(Bindings.selectDouble(playernameview.sceneProperty(), "height"));
	    
	    Image cairoicon = new Image("file:visuals/cairo icon.jpeg");
		ImageView cairoview = new ImageView(cairoicon);
		cairoview.setFitHeight(300);
		cairoview.setFitWidth(300);
		
		Image romeicon = new Image("file:visuals/rome icon.jpeg");
		ImageView romeview = new ImageView(romeicon);
		romeview.setFitHeight(300);
		romeview.setFitWidth(300);
		
		Image spartaicon = new Image("file:visuals/sparta icon.jpeg");
		ImageView spartaview = new ImageView(spartaicon);
		spartaview.setFitHeight(300);
		spartaview.setFitWidth(300);
	   
	    Image map = new Image("file:visuals/black.jpeg");
		ImageView mapview = new ImageView(map);
		Group mapg = new Group();
		mapg.getChildren().addAll(mapview);
		final DoubleProperty width2 = mapview.fitWidthProperty();
	    final DoubleProperty height2 = mapview.fitHeightProperty();
	    width2.bind(Bindings.selectDouble(mapview.sceneProperty(), "width"));
	    height2.bind(Bindings.selectDouble(mapview.sceneProperty(), "height"));
	    
	    HBox icons = new HBox(50);
		icons.getChildren().addAll(cairoview,romeview,spartaview);
		icons.setAlignment(Pos.CENTER);

		HBox name = new HBox (15);
		name.getChildren().addAll(nameLabel ,playerName);
		name.setAlignment(Pos.CENTER);
	//	
		VBox input = new VBox(15);
		input.getChildren().addAll(name,startGame);
		input.setAlignment(Pos.CENTER);
		
	//	
		HBox city = new HBox (50);
		city.getChildren().addAll(cairo, rome, sparta);
		city.setAlignment(Pos.CENTER);
	//diff
		VBox beforeFinal = new VBox(0);
		beforeFinal.getChildren().addAll(icons,city);
		beforeFinal.setAlignment(Pos.CENTER);
		
		VBox cityName = new VBox(50);
		cityName.getChildren().addAll(cityLabel,beforeFinal,Conquer);
		cityName.setAlignment(Pos.CENTER);
		
		//
		StackPane startGameViewlayout = new StackPane();
		startGameViewlayout.getChildren().addAll(startg, startButton);
		//diff
		BorderPane userInput = new BorderPane();
		userInput.setCenter(input);
		
		StackPane userInputlayout = new StackPane();
		userInputlayout.getChildren().addAll(playernameg,userInput);
		// 
		StackPane finalcityname = new StackPane();
		finalcityname.getChildren().addAll(mapg,cityName);
		
		Scene startGameView = new Scene(startGameViewlayout,1366,710);
		Scene ChooseName = new Scene(userInputlayout, 1366, 710);
		Scene ChooseCity = new Scene(finalcityname, 1366, 710);
	
		
		window.setScene(startGameView);
		startButton.setOnAction(e -> {
			window.setScene(ChooseName);
		});
		//alert box done
		startGame.setOnAction(e -> {
			Label message = new Label("Hello  " + playerName.getText());
			if(playerName.getText().equals("")) {
				AlertBoxes.noName("Alert!","Please enter your name!");
				window.setScene(ChooseName);
				
			}
			else 
			{
				cityName.getChildren().add(message);
				window.setScene(ChooseCity);	
			}
			
		});
		
		Conquer.setOnAction(e -> { 
			String n = playerName.getText();
			String c = null;
			if(cairo.isSelected()) {
				c = "Cairo";
				
				try {
					startGame(n , c);
					mapScene(window);
				} 
				catch (IOException e1) {
					
					
				}
			}	
			else if(rome.isSelected()) {
				c = "Rome";
				
				try {
					startGame(n , c);
					mapScene(window);
				} 
				catch (IOException e1) {
					
					
				}
	            }
			else if (sparta.isSelected()) {
				c = "Sparta";
				
				try {
					startGame(n , c);
					mapScene(window);
				} 
				catch (IOException e1) {
					
					
				}
			}	
			else 
			{
				AlertBoxes.noCity("Alert!", "Please choose a city!");
				window.setScene(ChooseCity);
			}
			
		});
	}
	
	public void mapScene(Stage window) {
		
		if(game.isGameOver()) {
			gameOverScene(window);
		}
		else {
			Image startImage = new Image("file:visuals/World Map.jpeg");
			ImageView startview = new ImageView(startImage);
			Group startg = new Group();
			startg.getChildren().addAll(startview);
	        final DoubleProperty width = startview.fitWidthProperty();
	        final DoubleProperty height = startview.fitHeightProperty();
	        width.bind(Bindings.selectDouble(startview.sceneProperty(), "width"));
	        height.bind(Bindings.selectDouble(startview.sceneProperty(), "height"));
	        
			Button cairo = new Button();
			cairo.setDisable(true);
			cairo.setText("Cairo");
			cairo.setOnAction(e -> 
			{
				cairoScene(window);
			});
			cairo.setPrefSize(150, 150);
			cairo.setStyle("-fx-font-size:15");
			Button sparta = new Button();
			sparta.setDisable(true);
			sparta.setPrefSize(150, 150);
			sparta.setStyle("-fx-font-size:15");
			sparta.setText("Sparta");
			sparta.setOnAction(e -> 
			{
				spartaScene(window);
			});
			Button rome = new Button();
			rome.setDisable(true);
			rome.setPrefSize(150, 150);
			rome.setStyle("-fx-font-size:15");
			rome.setText("Rome");
			rome.setOnAction(e -> 
			{
				romeScene(window);
			});
			
			ArrayList<City> c = game.getPlayer().getControlledCities();
			for(int i=0;i<c.size();i++) {
				if(c.get(i).getName().equals("Rome")) {
					rome.setDisable(false);
				}
				if(c.get(i).getName().equals("Cairo")) {
					cairo.setDisable(false);
				}
				
				if(c.get(i).getName().equals("Sparta")) {
					sparta.setDisable(false);
				}
			}
			
			StackPane finalView = new StackPane();
			
			HBox world = new HBox(200);
			world.getChildren().addAll(cairo,rome,sparta, displayArmy());
			
			world.setAlignment(Pos.CENTER);
			VBox viewF = new VBox(300);
			viewF.getChildren().add(this.fixedSlides(window));
			viewF.getChildren().add(world);
			
			finalView.getChildren().addAll(startg,viewF);
			Scene worldMap = new Scene(finalView, 1366, 710);
			window.setScene(worldMap);
		}
		
			
	}
	
	public HBox fixedSlides(Stage window) {
		Label t1 = new Label("Player Name: ");
		Label t2 = new Label(game.getPlayer().getName() + "");
		
		Label t3 = new Label("Available Gold ");
		Label t4 = new Label(game.getPlayer().getTreasury() + "");
		
		Label t5 = new Label("Available Food ");
		Label t6 = new Label(game.getPlayer().getFood() + "");
		
		Label t7 = new Label("Current Turn ");
		Label t8 = new Label(game.getCurrentTurnCount() + "");
		
		Button EndTurn = new Button();
		EndTurn.setText("End Turn");
		
		Button MapView = new Button();
		MapView.setText("Map View");
		
		Button Attack = new Button("Attack");
		Attack.setVisible(false);
		for(int s=0; s<game.getAvailableCities().size();s++) {
			if(game.getAvailableCities().get(s).isUnderSiege() && game.getAvailableCities().get(s).getTurnsUnderSiege() < 2) {
				//System.out.println("Hello");
				for(int j=0; j<game.getPlayer().getControlledArmies().size();j++) {
					if(game.getPlayer().getControlledArmies().get(s).getCurrentLocation().equals(game.getAvailableCities().get(s).getName())){
//						System.out.println("Hello");
							Attack.setVisible(true);
							Army myArmy = game.getPlayer().getControlledArmies().get(j);
							Army defArmy = game.getAvailableCities().get(s).getDefendingArmy();
					Attack.setOnAction(f-> 
					{
						battleView(window,myArmy,defArmy);
					});
				}
		
				}
			}
		}
		MapView.setOnAction(e -> 
		{
			mapScene(window);
		});
		
		HBox top = new HBox(30);
		top.getChildren().addAll(t1,t2,t3,t4,t5,t6,t7,t8,EndTurn,MapView,Attack);
		top.scaleShapeProperty();
		
		EndTurn.setOnAction(e -> 
		{
		if(game.getCurrentTurnCount() < 50 && !(game.getPlayer().getControlledCities().size()==game.getAvailableCities().size())) {
			game.endTurn();
			t8.setText(game.getCurrentTurnCount() + "");
				
			ArrayList<String> cCities = new ArrayList<String>();
			for(int i=0; i < game.getPlayer().getControlledCities().size();i++)
				cCities.add(game.getPlayer().getControlledCities().get(i).getName());
			
			for(int i=0; i<game.getPlayer().getControlledArmies().size();i++) {
				if(!(cCities.contains(game.getPlayer().getControlledArmies().get(i).getCurrentLocation())) && game.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.IDLE)) {
						choose(game.getPlayer().getControlledArmies().get(i));
						Attack.setVisible(true);
					}
						
				
			}
			for(int i=0; i<game.getAvailableCities().size();i++) {
				for(int j=0; j<game.getPlayer().getControlledArmies().size();j++) {
					if(game.getAvailableCities().get(i).getTurnsUnderSiege() == 2) {
							for(int s=0; s<game.getPlayer().getControlledArmies().size();s++) {
									if(game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equals(game.getAvailableCities().get(i).getName())){
										shouldAttack(game.getPlayer().getControlledArmies().get(j),game.getAvailableCities().get(i));
									}
							}
						}
			}	
					
			}
			
			mapScene(window);
		}
			else {
				//alert box to be poped when turn count reaches 50
				//AlertBoxes.turnsExceeded("Alert!","Turn count can't exceed 50");
				gameOverScene(window);
		}
		});
		
		return top;
		
	}
	
	public void shouldAttack(Army a,City c) {
		c.setTurnsUnderSiege(-1);
		Stage window = new Stage();
	
		Button attack = new Button();
		attack.setText("Attack");
		
		
		
		ChoiceBox<String> cities = new ChoiceBox<>();
		cities.setVisible(false);
		Label labelCity = new Label("  Please choose the City: ");
		
		for(int i=0; i < game.getAvailableCities().size();i++) {
			if(a.getCurrentLocation().equals(game.getAvailableCities().get(i).getName()));
			else
				cities.getItems().add(game.getAvailableCities().get(i).getName());
		}
		Button go = new Button("Go and target!");
		go.setVisible(false);
		
		VBox choices = new VBox(50);
		choices.getChildren().addAll(cities,go);
		Button exit = new Button("Set another Target!");
		exit.setOnAction(e->{
			cities.setVisible(true);
			go.setVisible(true);
			
		});
		go.setOnAction(e->{
			if(cities.getValue().equals("Rome"))
				game.targetCity(a, "Rome");
		
			else if(cities.getValue().equals("Cairo"))
				game.targetCity(a, "Cairo");
		
			else if(cities.getValue().equals("Sparta"))
				game.targetCity(a, "Sparta");
			else 
				AlertBoxes.EmptyChoiceBox("Alert!","Please Choose a city to target!");
			
			window.close();
		});
		HBox choice = new HBox(100);
		choice.getChildren().addAll(attack,exit,choices);
		Label ins = new Label();
		HBox text = new HBox();
		text.setAlignment(Pos.CENTER);
		ins.setText("You should attack " + c.getName() + "Or Leave");
		text.getChildren().addAll(ins);
		
			attack.setOnAction(e -> {
				battleView(window,a,c.getDefendingArmy());
				
			});
			
		
		VBox screen = new VBox(50);
		screen.getChildren().addAll(text,choice);
		Scene shouldAttack = new Scene(screen, 500, 500);
		window.setScene(shouldAttack);
		window.showAndWait();
	}
	
	public void choose(Army a) {
		Stage window = new Stage();
		Button LaySeige = new Button();
		LaySeige.setText("Lay Seige");
		
		Button attack = new Button();
		attack.setText("Attack");
		Button exit = new Button("Set another Target!");
		
		HBox choices = new HBox();
		choices.getChildren().addAll(LaySeige,attack,exit);
		choices.setAlignment(Pos.CENTER);
		Label ins = new Label();
		Label ins1 = new Label();
		HBox text = new HBox();
		text.setAlignment(Pos.CENTER);
		ins.setText("You have arrived to     " + a.getCurrentLocation());
		ins1.setText("   You have to choose whether to lay seige or attack  ");
		text.getChildren().addAll(ins,ins1);
			LaySeige.setOnAction(e -> {
				for(int j=0; j < game.getAvailableCities().size();j++) {
				  if(game.getAvailableCities().get(j).getName().equals(a.getCurrentLocation()))
				try {
					game.getPlayer().laySiege(a, game.getAvailableCities().get(j));
					mapScene(window);
					window.close();
				} catch (TargetNotReachedException  e1) {
					AlertBoxes.TargetNotReachedException("Alert!","The army didn't arrive to the desired destination.");
					
				} catch (FriendlyCityException e1) {
					AlertBoxes.FriendlyCityException("Alert!","You can't lay siege on your own city.");
				
				}
					}
						});
			
			attack.setOnAction(e -> {
				for(int j=0; j < game.getAvailableCities().size();j++) {
					if(game.getAvailableCities().get(j).getName().equals(a.getCurrentLocation())) {
						battleView(window,a,game.getAvailableCities().get(j).getDefendingArmy());

					}
						
				}
			});
			

			
			ChoiceBox<String> cities = new ChoiceBox<>();
			cities.setVisible(false);
			Label labelCity = new Label("  Please choose the City: ");
			
			for(int i=0; i < game.getAvailableCities().size();i++) {
				if(a.getCurrentLocation().equals(game.getAvailableCities().get(i).getName()));
				else
					cities.getItems().add(game.getAvailableCities().get(i).getName());
			}
			Button go = new Button("Go and target!");
			go.setVisible(false);
			
			VBox choicess = new VBox(50);
			choicess.getChildren().addAll(cities,go);
			
			exit.setOnAction(e->{
				cities.setVisible(true);
				go.setVisible(true);
				
			});
			go.setOnAction(e->{
				if(cities.getValue().equals("Rome"))
					game.targetCity(a, "Rome");
			
				else if(cities.getValue().equals("Cairo"))
					game.targetCity(a, "Cairo");
			
				else if(cities.getValue().equals("Sparta"))
					game.targetCity(a, "Sparta");
				else 
					AlertBoxes.EmptyChoiceBox("Alert!","Please Choose a city to target!");
				
				window.close();
			});
		VBox screen = new VBox(50);
		screen.getChildren().addAll(text,choices,exit,choicess);
		Scene arrived = new Scene(screen,window.getWidth(), window.getHeight());
		window.setScene(arrived);
		window.showAndWait();
				}

	public void gameOverScene(Stage window) {
		
		if(game.isGameOver())
		{	
			VBox last = new VBox(70);
			last.setAlignment(Pos.CENTER);
			Button byeB = new Button();
			byeB.setText("See You Soon my friend");
			byeB.setOnAction(e -> window.close());
			
			Label bye;
			if(game.getPlayer().getControlledCities().size() == game.getAvailableCities().size())
				bye = new Label("YOU WON!!");
			else
				bye = new Label("YOU LOST!!");
			
			last.getChildren().addAll(byeB , bye);
			Scene lastScene = new Scene(last, 1366, 710);
			window.setScene(lastScene);
			window.show();
		}
		else
			mapScene(window);
		
	}
	
	public void cairoScene(Stage window) {
		
		Image cairoBackground = new Image("file:visuals/egypt old.jpg");
		ImageView startview = new ImageView(cairoBackground);
		Group startg = new Group();
		startg.getChildren().addAll(startview);
        final DoubleProperty width = startview.fitWidthProperty();
        final DoubleProperty height = startview.fitHeightProperty();
        width.bind(Bindings.selectDouble(startview.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(startview.sceneProperty(), "height"));

		HBox ebuilldings = new HBox(200);
		ebuilldings.getChildren().addAll(farm("Cairo", window), market("Cairo", window));
		ebuilldings.setAlignment(Pos.CENTER);
		
		
		HBox mbuilldings = new HBox(200);
		mbuilldings.getChildren().addAll(ArcheryRange("Cairo", window), barracks("Cairo", window),stable("Cairo", window));
		mbuilldings.setAlignment(Pos.CENTER);
		
		VBox buildings = new VBox(50);
		buildings.getChildren().addAll(ebuilldings,mbuilldings);
		buildings.setAlignment(Pos.CENTER);
		
		BorderPane view = new BorderPane();
		view.setCenter(buildings);
		view.setTop(fixedSlides(window));
		
		Label DfArmy = new Label("");
		for(int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
			if(game.getPlayer().getControlledCities().get(i).getName().equals("Cairo")) {
				DfArmy.setText("Cairo's Defending Army Current Location: "  + game.getPlayer().getControlledCities().get(i).getDefendingArmy().getCurrentLocation() + " Current Status: " + game.getPlayer().getControlledCities().get(i).getDefendingArmy().getCurrentStatus() + "\n");
			}
		}
		view.setRight(IDLEarmies("Cairo"));
		VBox armies = new VBox(40);
		armies.getChildren().add(DfArmy);
		
		
		VBox CCarmies = new VBox();
		armies.getChildren().addAll(createArmy("Cairo",window),Relocate("Cairo",window),setTarget("Cairo",window),CCarmies);
		view.setRight(armies);
		CCarmies.getChildren().add(new Label("Controlled armies and their Units"));
		for(int i = 0; i < game.getPlayer().getControlledArmies().size();i++) {
			if(game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equals("Cairo")) {
				String temp = "";
				for(int j=0; j < game.getPlayer().getControlledArmies().get(i).getUnits().size();j++) {
				CCarmies.getChildren().add(new Label((i+1) + "Controlled Army: " +  game.getPlayer().getControlledArmies().get(i).getCurrentStatus()));
				temp+= "Unit Type: "+ game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getClass().getSimpleName() + "Level: " + game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()  + "Current Soldier Count: " +game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount() + "\n";
			}
				CCarmies.getChildren().add(new Label(temp));
			}	
		}
		
		StackPane cairoFinalView = new StackPane();
		cairoFinalView.getChildren().addAll(startg,view);
        
		Scene cairo = new Scene(cairoFinalView, 1366, 710);
		window.setScene(cairo);
		
	}
	
	public void romeScene(Stage window) {
		
		Image romeBackground = new Image("file:visuals/rome.jpg");
		ImageView startview = new ImageView(romeBackground);
		Group startg = new Group();
		startg.getChildren().addAll(startview);
        final DoubleProperty width = startview.fitWidthProperty();
        final DoubleProperty height = startview.fitHeightProperty();
        width.bind(Bindings.selectDouble(startview.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(startview.sceneProperty(), "height"));
        
        
		
		HBox ebuilldings = new HBox(200);
		ebuilldings.getChildren().addAll(farm("Rome", window), market("Rome", window));
		ebuilldings.setAlignment(Pos.CENTER);
		
		
		HBox mbuilldings = new HBox(200);
		mbuilldings.getChildren().addAll(ArcheryRange("Rome", window), barracks("Rome", window),stable("Rome", window));
		mbuilldings.setAlignment(Pos.CENTER);
		
		VBox buildings = new VBox(50);
		buildings.getChildren().addAll(ebuilldings,mbuilldings);
		buildings.setAlignment(Pos.CENTER);
		
		BorderPane view = new BorderPane();
		view.setCenter(buildings);
		view.setTop(fixedSlides(window));
		
		Label DfArmy = new Label("");
		for(int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
			if(game.getPlayer().getControlledCities().get(i).getName().equals("Rome")) {
				DfArmy.setText("Rome's Defending Army Current Location: "  + game.getPlayer().getControlledCities().get(i).getDefendingArmy().getCurrentLocation() + " Current Status: " + game.getPlayer().getControlledCities().get(i).getDefendingArmy().getCurrentStatus());
			}
		}
		view.setRight(IDLEarmies("Rome"));
		
		VBox armies = new VBox(10);
		VBox CCarmies = new VBox();
		armies.getChildren().add(DfArmy);
		armies.getChildren().addAll(createArmy("Rome",window),Relocate("Rome",window),setTarget("Rome",window),CCarmies);
		view.setRight(armies);
		CCarmies.getChildren().add(new Label("Controlled armies and their Units"));
		for(int i = 0; i < game.getPlayer().getControlledArmies().size();i++) {
			if(game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equals("Rome")) {
				String temp = "";
				for(int j=0; j < game.getPlayer().getControlledArmies().get(i).getUnits().size();j++) {
				CCarmies.getChildren().add(new Label((i+1) + "Controlled Army: " +  game.getPlayer().getControlledArmies().get(i).getCurrentStatus()));
				temp+= "Unit Type: "+ game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getClass().getSimpleName() + "Level: " + game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()  + "Current Soldier Count: " +game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount() + "\n";
			}
				CCarmies.getChildren().add(new Label(temp));
			}	
		}
		
		StackPane romeFinalView = new StackPane();
        romeFinalView.getChildren().addAll(startg,view);
		Scene rome = new Scene(romeFinalView, 1366, 710);
		
		window.setScene(rome);
	}
	
	public void spartaScene(Stage window) {
		
		Image spartaBackground = new Image("file:visuals/sparta.jpg");
		ImageView startview = new ImageView(spartaBackground);
		Group startg = new Group();
		startg.getChildren().addAll(startview);
        final DoubleProperty width = startview.fitWidthProperty();
        final DoubleProperty height = startview.fitHeightProperty();
        width.bind(Bindings.selectDouble(startview.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(startview.sceneProperty(), "height"));
		
		HBox ebuilldings = new HBox(200);
		ebuilldings.getChildren().addAll(farm("Sparta", window), market("Sparta", window));
		ebuilldings.setAlignment(Pos.CENTER);
		
		
		HBox mbuilldings = new HBox(200);
		mbuilldings.getChildren().addAll(ArcheryRange("Sparta", window), barracks("Sparta", window),stable("Sparta", window));
		mbuilldings.setAlignment(Pos.CENTER);
		
		VBox buildings = new VBox(50);
		buildings.getChildren().addAll(ebuilldings,mbuilldings);
		buildings.setAlignment(Pos.CENTER);
		
		BorderPane view = new BorderPane();
		view.setCenter(buildings);
		view.setTop(fixedSlides(window));
		
		Label DfArmy = new Label("");
		for(int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
			if(game.getPlayer().getControlledCities().get(i).getName().equals("Sparta")) {
				DfArmy.setText("Sparta's Defending Army Current Location: "  + game.getPlayer().getControlledCities().get(i).getDefendingArmy().getCurrentLocation() + " Current Status: " + game.getPlayer().getControlledCities().get(i).getDefendingArmy().getCurrentStatus());
			}
		}
		view.setRight(IDLEarmies("Sparta"));
		VBox armies = new VBox(10);
		VBox CCarmies = new VBox();
		armies.getChildren().add(DfArmy);
		armies.getChildren().addAll(createArmy("Sparta",window),Relocate("Sparta",window),setTarget("Sparta",window),CCarmies);
		view.setRight(armies);
		CCarmies.getChildren().add(new Label("Controlled armies and their Units"));
		for(int i = 0; i < game.getPlayer().getControlledArmies().size();i++) {
			if(game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equals("Sparta")) {
				String temp = "";
				for(int j=0; j < game.getPlayer().getControlledArmies().get(i).getUnits().size();j++) {
				CCarmies.getChildren().add(new Label((i+1) + "Controlled Army: " +  game.getPlayer().getControlledArmies().get(i).getCurrentStatus()));
				temp+= "Unit Type: "+ game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getClass().getSimpleName() + "Level: " + game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()  + "Current Soldier Count: " +game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount() + "\n";
			}
				CCarmies.getChildren().add(new Label(temp));
			}	
		}
		
		
		StackPane spartaFinalView = new StackPane();
        spartaFinalView.getChildren().addAll(startg,view);
	
		Scene sparta = new Scene(spartaFinalView, 1366, 710);
		window.setScene(sparta);
		
		
		
	}
	
	public VBox farm(String cityName, Stage window) 
	{
			VBox allFarm = new VBox(50);
			
			Button farm = new Button();
			farm.setText("Farm");
			allFarm.getChildren().add(farm);
			Button action = new Button();
			action.setText(""); 
			
			for(int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if(game.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
					
					
					for(int j=0; j< game.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {
						if(game.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j) instanceof Farm) {
							action.setText("Upgrade");
							Label farmDetails = new Label("");
							Building c = (Building)  game.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j);
							farmDetails.setText("Upgrade Cost: " + c.getUpgradeCost() + "Current Level: " + c.getLevel());
							action.setOnAction(e -> {
								try {
									game.getPlayer().upgradeBuilding(c);
									farmDetails.setText("Upgrade Cost: " + c.getUpgradeCost() + "Current Level: " + c.getLevel());
									} catch (NotEnoughGoldException e1) 
									{
										AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
										
									} 
									catch (BuildingInCoolDownException e1) 
									{
										AlertBoxes.BuildingInCoolDownException("Alert!", "Building needs to cool down , try again next turn");

									} 
									catch (MaxLevelException e1)
									{
										AlertBoxes.MaxLevelException("Alert!", "You have reached the maximum level , cant upgrade further.");
									} 
								 
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);
									
							});
							
							allFarm.getChildren().add(farmDetails);
						}
					} 
						if(action.getText().equals("")) {
							City f = game.getPlayer().getControlledCities().get(i);
							action.setText("Build Farm");
							Label farmDetails = new Label("");
							action.setOnAction(e ->{
								try {
									game.getPlayer().build("Farm", cityName);
									if(f.getName().equals(cityName)) {
										for(int j=0; j< f.getEconomicalBuildings().size();j++) {
											if(f.getEconomicalBuildings().get(j) instanceof Farm) {
								farmDetails.setText("Upgrade Cost: " + f.getEconomicalBuildings().get(j).getUpgradeCost() + "Current Level: " + f.getEconomicalBuildings().get(j).getLevel());
											}
										}
								}
								} catch (NotEnoughGoldException e1)
								{
									AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
									
								}
								farm.setVisible(true);
								action.setText("Upgrade");
								allFarm.getChildren().add(farmDetails);
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);
							});

						}
					
				}
			}
			
			allFarm.getChildren().add(action);
			allFarm.setAlignment(Pos.CENTER);
			return allFarm;
		}
		
	public VBox market(String cityName, Stage window) {
			VBox allMarket = new VBox(50);
			
			Button market = new Button();
			market.setText("Market");
			allMarket.getChildren().add(market);
			Button action = new Button();
			action.setText("");
			for(int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if(game.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
					for(int j=0; j< game.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {
						if(game.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j) instanceof Market) {
							action.setText("Upgrade");
							Label marketDetails = new Label("");
							Market c = (Market) game.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j);
							marketDetails.setText("Upgrade Cost: " + c.getUpgradeCost() + "Current Level: " + c.getLevel());
							action.setOnAction(e -> {
								try {
									game.getPlayer().upgradeBuilding(c);
									marketDetails.setText("Upgrade Cost: " + c.getUpgradeCost() + "Current Level: " + c.getLevel());
									} catch (NotEnoughGoldException e1) {
										AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
									} catch (BuildingInCoolDownException e1) {
										AlertBoxes.BuildingInCoolDownException("Alert!", "Building needs to cool down , try again next turn");
									
									} catch (MaxLevelException e1) {
										AlertBoxes.MaxLevelException("Alert!", "You have reached the maximum level , cant upgrade further.");
									} 
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);	
							});
							
							
							allMarket.getChildren().add(marketDetails);
						}
					} 
						if(action.getText().equals("")) {
							City f = game.getPlayer().getControlledCities().get(i);
							action.setText("Build Market");
							Label marketDetails = new Label("");
							action.setOnAction(e ->{
								try {
									game.getPlayer().build("Market", cityName);
									if(f.getName().equals(cityName)) {
										for(int j=0; j< f.getEconomicalBuildings().size();j++) {
											if(f.getEconomicalBuildings().get(j) instanceof Farm) {
									marketDetails.setText("Upgrade Cost: " + f.getEconomicalBuildings().get(j).getUpgradeCost() + "Current Level: " + f.getEconomicalBuildings().get(j).getLevel());
											}
										}
								}
								} catch (NotEnoughGoldException e1) {
									AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
								}
								market.setVisible(true);
								action.setText("Upgrade");
								allMarket.getChildren().add(marketDetails);
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);
							});

						}
					
				}
			}
			
			allMarket.getChildren().add(action);
			allMarket.setAlignment(Pos.CENTER);
			return allMarket;
		}
		
	public VBox ArcheryRange(String cityName, Stage window) {
			VBox allArcheryRange = new VBox(50);
			
			Button ArcheryRange = new Button();
			ArcheryRange.setText("ArcheryRange");
			allArcheryRange.getChildren().add(ArcheryRange);
			Button action = new Button();
			Button rec = new Button();
			action.setText("");
			VBox units = new VBox();
			units.setAlignment(Pos.CENTER);
			for(int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if(game.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
					for(int j=0; j< game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
						if(game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof buildings.ArcheryRange) {
							action.setText("Upgrade");
							Label archeryDetails = new Label("");
							buildings.ArcheryRange c = (buildings.ArcheryRange) game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j);
							archeryDetails.setText("   Upgrade Cost:   " + c.getUpgradeCost() + "   Recruitment Cost: " + c.getRecruitmentCost() + "   Current Level: " + c.getLevel());
							action.setOnAction(e -> {
								try {
									game.getPlayer().upgradeBuilding(c);
									archeryDetails.setText("Upgrade Cost:   " + c.getUpgradeCost() + "  Recruitment Cost: " + c.getRecruitmentCost() + "   Current Level: " + c.getLevel());
									} catch (NotEnoughGoldException e1) {
										AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
									} catch (BuildingInCoolDownException e1) {
										AlertBoxes.BuildingInCoolDownException("Alert!", "Building needs to cool down , try again next turn");
									
									} catch (MaxLevelException e1) {
										AlertBoxes.MaxLevelException("Alert!", "You have reached the maximum level , cant upgrade further.");
									} 
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);	
							});
							rec.setText("Recruit");
							Army t = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
							for(int s=0; s<t.getUnits().size();s++) {
								if(t.getUnits().get(s) instanceof Archer) {
									Label l = new Label("Def Army Unit" + (s+1) + "Current Soldier Count: " + t.getUnits().get(s).getCurrentSoldierCount() + "  Current Level: " + t.getUnits().get(s).getLevel() + "  Max Soldier Count:  "+ t.getUnits().get(s).getMaxSoldierCount());
									units.getChildren().add(l);
								}
								
							}
							rec.setOnAction(e -> {
								
								try {
									game.getPlayer().recruitUnit("Archer", cityName);
									for(int s=0; s<t.getUnits().size();s++) {
										Label l = new Label("Current Soldier Count: " + t.getUnits().get(s).getCurrentSoldierCount() + "  Current Level: " + t.getUnits().get(s).getLevel() + "  Max Soldier Count:  "+ t.getUnits().get(s).getMaxSoldierCount());
										units.getChildren().add(l);
										
									}
									
									
								} catch (BuildingInCoolDownException e1) {
									AlertBoxes.BuildingInCoolDownException("Alert!", "Building needs to cool down , try again next turn");
								} catch (MaxRecruitedException e1) {
									AlertBoxes.MaxRecruitedException("Alert!", "You can't recruit more than 3 units per turn!");
								} catch (NotEnoughGoldException e1) {
									AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
								}
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);
							});
							
							allArcheryRange.getChildren().addAll(rec, units);
							allArcheryRange.getChildren().add(archeryDetails);
						}
					} 
						if(action.getText().equals("")) {
							City f = game.getPlayer().getControlledCities().get(i);
							action.setText("Build Archery Range");
							Label archeryDetails = new Label("");
							action.setOnAction(e ->{
								try {
									game.getPlayer().build("ArcheryRange", cityName);
									if(f.getName().equals(cityName)) {
										for(int j=0; j< f.getMilitaryBuildings().size();j++) {
											if(f.getMilitaryBuildings().get(j) instanceof buildings.ArcheryRange) {
										archeryDetails.setText("Upgrade Cost:   " + f.getMilitaryBuildings().get(j).getUpgradeCost() + "  Recruitment Cost: " + f.getMilitaryBuildings().get(j).getRecruitmentCost() + "  Current Level: " + f.getMilitaryBuildings().get(j).getLevel());
											}
										}
								}
								} catch (NotEnoughGoldException e1) {
									AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
								}
								ArcheryRange.setVisible(true);
								action.setText("Upgrade");
								allArcheryRange.getChildren().add(archeryDetails);
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);
							});

						}
					
				}
			}
			
			allArcheryRange.getChildren().add(action);
			allArcheryRange.setAlignment(Pos.CENTER);
			return allArcheryRange;
		}
		
	public VBox barracks(String cityName, Stage window) {
			VBox allBarracks = new VBox(50);
			
			Button barracksB = new Button();
			barracksB.setText("Barracks");
			allBarracks.getChildren().add(barracksB);
			Button action = new Button();
			Button rec = new Button();
			action.setText("");
			VBox units = new VBox();
			units.setAlignment(Pos.CENTER);
			for(int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if(game.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
					for(int j=0; j< game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
						if(game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Barracks) {
							action.setText("Upgrade");
							Label barracksDetails = new Label("");
							Barracks c = (Barracks) game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j);
							barracksDetails.setText("   Upgrade Cost:   " + c.getUpgradeCost() + "   Recruitment Cost: " + c.getRecruitmentCost() + "   Current Level: " + c.getLevel());
							action.setOnAction(e -> {
								try {
									game.getPlayer().upgradeBuilding(c);
									barracksDetails.setText("Upgrade Cost:   " + c.getUpgradeCost() + "  Recruitment Cost: " + c.getRecruitmentCost() + "   Current Level: " + c.getLevel());
								} catch (NotEnoughGoldException e1) {
									AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
								} catch (BuildingInCoolDownException e1) {
									AlertBoxes.BuildingInCoolDownException("Alert!", "Building needs to cool down , try again next turn");
								
								} catch (MaxLevelException e1) {
									AlertBoxes.MaxLevelException("Alert!", "You have reached the maximum level , cant upgrade further.");
								} 
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);		
							});
							
							rec.setText("Recruit");
							Army t = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
							for(int s=0; s<t.getUnits().size();s++) {
								if(t.getUnits().get(s) instanceof Infantry) {
								units.getChildren().add(new Label("Def Army Unit" + (s+1) + "Current Soldier Count: " + t.getUnits().get(s).getCurrentSoldierCount() + "  Current Level: " + t.getUnits().get(s).getLevel() + "  Max Soldier Count:  "+ t.getUnits().get(s).getMaxSoldierCount()));
								}
							}
							
							rec.setOnAction(e -> {
								
								try {
									game.getPlayer().recruitUnit("Infantry", cityName);
									for(int s=0; s<t.getUnits().size();s++) {
										units.getChildren().add(new Label("Current Soldier Count: " + t.getUnits().get(s).getCurrentSoldierCount() + "  Current Level: " + t.getUnits().get(s).getLevel() + "  Max Soldier Count:  "+ t.getUnits().get(s).getMaxSoldierCount()));
										
									}
									
								} catch (BuildingInCoolDownException e1) {
									AlertBoxes.BuildingInCoolDownException("Alert!", "Building needs to cool down , try again next turn");
								} catch (MaxRecruitedException e1) {
									AlertBoxes.MaxRecruitedException("Alert!", "You can't recruit more than 3 units per turn!");
								} catch (NotEnoughGoldException e1) {
									AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
								}
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);
							});
							
							allBarracks.getChildren().addAll(rec, units);
							allBarracks.getChildren().add(barracksDetails);
						}
					} 
						if(action.getText().equals("")) {
							City f = game.getPlayer().getControlledCities().get(i);
							action.setText("Build Barracks");
							Label barracksDetails = new Label("");
							action.setOnAction(e ->{
								try {
									game.getPlayer().build("Barracks", cityName);
									if(f.getName().equals(cityName)) {
										for(int j=0; j< f.getMilitaryBuildings().size();j++) {
											if(f.getMilitaryBuildings().get(j) instanceof Barracks) {
												barracksDetails.setText("Upgrade Cost:   " + f.getMilitaryBuildings().get(j).getUpgradeCost() + "  Recruitment Cost: " + f.getMilitaryBuildings().get(j).getRecruitmentCost() + "  Current Level: " + f.getMilitaryBuildings().get(j).getLevel());
											}
										}
								}
								} catch (NotEnoughGoldException e1) {
									AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
								}
								barracksB.setVisible(true);
								action.setText("Upgrade");
								allBarracks.getChildren().add(barracksDetails);
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);
							});

						}
					
				}
			}
			
			allBarracks.getChildren().add(action);
			allBarracks.setAlignment(Pos.CENTER);
			return allBarracks;
		}
		
	public VBox stable(String cityName, Stage window) {
			VBox allStable = new VBox(50);
			
			Button stableB = new Button();
			stableB.setText("Stable");
			allStable.getChildren().add(stableB);
			Button action = new Button();
			action.setText("");
			Button rec = new Button();
			VBox units = new VBox();
			units.setAlignment(Pos.CENTER);
			for(int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if(game.getPlayer().getControlledCities().get(i).getName().equals(cityName)) {
					for(int j=0; j< game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
						if(game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Stable) {
							action.setText("Upgrade");
							Label stableDetails = new Label("");
							Stable c = (Stable) game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j);
							stableDetails.setText("   Upgrade Cost:   " + c.getUpgradeCost() + "   Recruitment Cost: " + c.getRecruitmentCost() + "   Current Level: " + c.getLevel());
							action.setOnAction(e -> {
								try {
									game.getPlayer().upgradeBuilding(c);
									stableDetails.setText( "Upgrade Cost:   " + c.getUpgradeCost() + "  Recruitment Cost: " + c.getRecruitmentCost() + "   Current Level: " + c.getLevel());
								} catch (NotEnoughGoldException e1) {
									AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
								} catch (BuildingInCoolDownException e1) {
									AlertBoxes.BuildingInCoolDownException("Alert!", "Building needs to cool down , try again next turn");
								
								} catch (MaxLevelException e1) {
									AlertBoxes.MaxLevelException("Alert!", "You have reached the maximum level , cant upgrade further.");
								} 
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);
								
							});
							rec.setText("Recruit");
							Army t = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
							
							for(int s=0; s<t.getUnits().size();s++) {
								if(t.getUnits().get(s) instanceof Cavalry)
								{
								units.getChildren().add(new Label("Def Army Unit: " + (s+1) +"Current Soldier Count: " + t.getUnits().get(s).getCurrentSoldierCount() + "  Current Level: " + t.getUnits().get(s).getLevel() + "  Max Soldier Count:  "+ t.getUnits().get(s).getMaxSoldierCount()));
								}
							}
							rec.setOnAction(e -> {
								
								try {
									game.getPlayer().recruitUnit("Cavalry", cityName);
									for(int s=0; s<t.getUnits().size();s++) {
										units.getChildren().add(new Label("Current Soldier Count: " + t.getUnits().get(s).getCurrentSoldierCount() + "  Current Level: " + t.getUnits().get(s).getLevel() + "  Max Soldier Count:  "+ t.getUnits().get(s).getMaxSoldierCount()));
										
									}
									
									
								} catch (BuildingInCoolDownException e1) {
									AlertBoxes.BuildingInCoolDownException("Alert!", "Building needs to cool down , try again next turn");
								} catch (MaxRecruitedException e1) {
									AlertBoxes.MaxRecruitedException("Alert!", "You can't recruit more than 3 units per turn!");
								} catch (NotEnoughGoldException e1) {
									AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
								}
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);
							});
							
							allStable.getChildren().addAll(rec, units);
							allStable.getChildren().add(stableDetails);
						}
					} 
						if(action.getText().equals("")) {
							City f = game.getPlayer().getControlledCities().get(i);
							action.setText("Build Stable");
							Label stableDetails = new Label("");
							action.setOnAction(e ->{
								try {
									game.getPlayer().build("Stable", cityName);
									if(f.getName().equals(cityName)) {
										for(int j=0; j< f.getMilitaryBuildings().size();j++) {
											if(f.getMilitaryBuildings().get(j) instanceof Stable) {
												stableDetails.setText("Upgrade Cost:   " + f.getMilitaryBuildings().get(j).getUpgradeCost() + "  Recruitment Cost: " + f.getMilitaryBuildings().get(j).getRecruitmentCost() + "  Current Level: " + f.getMilitaryBuildings().get(j).getLevel());
											}
										}
								}
								} catch (NotEnoughGoldException e1) {
									AlertBoxes.NotEnoughGoldException("Alert!", "You don't have enough gold!");
								}
								stableB.setVisible(true);
								action.setText("Upgrade");
								allStable.getChildren().add(stableDetails);
								
								if (cityName.equals("Rome"))
									romeScene(window);
								else if (cityName.equals("Cairo"))
									cairoScene(window);
								else 
									spartaScene(window);
							});

						}
					
				}
			}
			
			allStable.getChildren().add(action);
			allStable.setAlignment(Pos.CENTER);
			return allStable;
		}
	
	public VBox IDLEarmies(String cityName) {
		VBox s = new VBox();
		for(int i=0; i<game.getPlayer().getControlledArmies().size();i++) {
			if(game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equals(cityName)) {
	
				Label ll = new Label("Army no." + (i+1));
				Label l = new Label("Army Max to Hold: " + game.getPlayer().getControlledArmies().get(i).getMaxToHold());
				Label lll = new Label("" + "Current status: " + game.getPlayer().getControlledArmies().get(i).getCurrentStatus());
				
				s.getChildren().addAll(ll,l,lll);
			}	
		}
		return s;
	
	}

	public VBox displayArmy() {
//		game.getPlayer().getControlledArmies().add(new Army("Sparta"));
//		game.targetCity(game.getPlayer().getControlledArmies().get(0), "Rome");
		VBox armies = new VBox(5);
		armies.setAlignment(Pos.CENTER);
		Label two = null;
		Label three = null;
		armies.getChildren().add(new Label("Controlled Armies and Units"));
		ArrayList<Army> c = game.getPlayer().getControlledArmies();
		for(int i=0; i<c.size();i++) {			
			VBox temp = new VBox();
			two = new Label(" Army status:" + c.get(i).getCurrentStatus());
			three = new Label("Army Location:" + c.get(i).getCurrentLocation());
			temp.getChildren().addAll(three,two);
			if(c.get(i).getCurrentStatus().equals(Status.MARCHING)) {
				Label targetL = new Label("Target City:" + c.get(i).getTarget());
				Label distanceL = new Label("Turns Left:" + c.get(i).getDistancetoTarget() + "");
				temp.getChildren().addAll(targetL,distanceL);
			}
			if(c.get(i).getCurrentStatus().equals(Status.BESIEGING)) {
				ArrayList<City> g = game.getAvailableCities();
				for(int j = 0; j<g.size(); j++)
					if(c.get(i).getCurrentLocation().equals(g.get(j).getName())) {
						Label turnsT = new Label("Turns UnderSerige:");
						Label turns = new Label(g.get(j).getTurnsUnderSiege() + "");
						temp.getChildren().addAll(turnsT,turns);
					}
			}
			armies.getChildren().add(temp);
			VBox tempUnit = new VBox();
			for(int j = 0;j<c.get(i).getUnits().size(); j++) {
				Label type = new Label("Unit Type: " + c.get(i).getUnits().get(j).getClass().getSimpleName());
				Label csc = new Label("Unit's Current Soldier Count: " + c.get(i).getUnits().get(j).getCurrentSoldierCount() + "");
				Label msc = new Label("Unit's Max Soldier Count: " + c.get(i).getUnits().get(j).getMaxSoldierCount() + "");
				Label level = new Label("Unit's level: " + c.get(i).getUnits().get(j).getLevel()+ "");
				
				tempUnit.getChildren().addAll(type, csc, msc, level);
			}
			armies.getChildren().add(tempUnit);
		}
		return armies;
	}
	
	public VBox setTarget(String currCity, Stage window) {
		VBox x = new VBox();
		if(game.getPlayer().getControlledArmies().size() == 0)
			x.setVisible(false);
		
		ChoiceBox<String> myArmies = new ChoiceBox<>();
		Label label = new Label("Please choose the Army: ");
		
		for(int i = 0; i <game.getPlayer().getControlledArmies().size();i++) {
			if(game.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.IDLE))
			myArmies.getItems().add((i+1) + ". " + game.getPlayer().getControlledArmies().get(i).getClass().getSimpleName() + (i+1));
		}
		
		
		ChoiceBox<String> cities = new ChoiceBox<>();
		Label labelCity = new Label("  Please choose the City: ");
		
		for(int i=0; i < game.getAvailableCities().size();i++) {
			if(game.getPlayer().getControlledCities().contains(game.getAvailableCities().get(i)));
			else
				cities.getItems().add(game.getAvailableCities().get(i).getName());
		}
		Button setTarget = new Button("Target another city");
		setTarget.setOnAction(e ->{
			String index1 = "";
			for(int s = 0; !(myArmies.getValue().charAt(s) + "").equals(".") ;s++) {
				index1 += myArmies.getValue().charAt(s) +  "";
			}
			int index = Integer.parseInt(index1);
			game.targetCity(game.getPlayer().getControlledArmies().get(index -1), cities.getValue());

			
			if(currCity.equals("Rome"))
				romeScene(window);
			else if(currCity.equals("Cairo"))
				cairoScene(window);
			else
				spartaScene(window);
			mapScene(window);
		});
		
		HBox y = new HBox();
		y.getChildren().addAll(label,myArmies,labelCity,cities);
		
		x.getChildren().addAll(y,setTarget);
		x.setAlignment(Pos.TOP_RIGHT);
		return x;
	}
	
//set button attack to this
//Don't forget to create my army and def in endTurn

	public void battleView(Stage window, Army myArmy, Army defArmy) {

			Image battleBackground = new Image("file:visuals/battle.jpg");
			ImageView startview = new ImageView(battleBackground);
			Group startg = new Group();
			startg.getChildren().addAll(startview);
	        final DoubleProperty width = startview.fitWidthProperty();
	        final DoubleProperty height = startview.fitHeightProperty();
	        width.bind(Bindings.selectDouble(startview.sceneProperty(), "width"));
	        height.bind(Bindings.selectDouble(startview.sceneProperty(), "height"));
	        
			Button manual = new Button("fight Manually");
			Button autoResolve = new Button("fight Automatically");
			autoResolve.setOnAction(e->{
				try {
					int before = game.getPlayer().getControlledCities().size();
					game.autoResolve(myArmy, defArmy);
					int after = game.getPlayer().getControlledCities().size();
					if(after > before) {
						AlertBoxes.youWon("Alert!", "You won this battle !!");
						gameOverScene(window);//testtt
						window.close();
					}
					else {
						AlertBoxes.youLost("Alert!", "You lost this battle :( ");
						window.close();
					}
					
				} catch (FriendlyFireException e1) {
					AlertBoxes.FriendlyFireException("Alert!", "You can't attack your own army!");
				}
			});
			manual.setOnAction(e->{
				manualAttackView(window, myArmy, defArmy);
			});
			HBox view = new HBox(100);
			view.getChildren().addAll(manual,autoResolve);
			view.setAlignment(Pos.CENTER);
			Label text = new Label("Choose Battle Mode");
			VBox finalLay = new VBox(50);
			finalLay.getChildren().addAll(text,view);
			finalLay.setAlignment(Pos.CENTER);
			StackPane battleFinalView = new StackPane();
			battleFinalView.getChildren().addAll(startg,finalLay);
			Scene battle = new Scene(battleFinalView, 1366,710);
			window.setScene(battle);
//			window.showAndWait();

		}
		//must test and trace after intialization 
	public void manualAttackView(Stage window, Army attacker, Army defender) { 
		
			if(defender.getUnits().size() == 0){
			 game.occupy(attacker,attacker.getCurrentLocation());
			 mapScene(window);
			 window.close();
			 AlertBoxes.youWon("Alert!", "You won this battle !!");
			 //Test..after Initalize
			
		 }
			VBox left = new VBox(50);
			left.setAlignment(Pos.BASELINE_LEFT);
			ChoiceBox<String> myArmy = new ChoiceBox<>();
			Label Units = new Label("Please choose from the defender's units");
			Label myUnitLL = new Label("Please choose from your units to attack");
			
			left.getChildren().addAll(myUnitLL,myArmy);
			left.setAlignment(Pos.CENTER_LEFT);
			VBox right = new VBox(50);
			ChoiceBox<String> defArmy = new ChoiceBox<>();
			right.getChildren().addAll(Units,defArmy);
			right.setAlignment(Pos.CENTER_RIGHT);
			
			HBox view = new HBox(200);
			view.getChildren().addAll(left,right);
			view.setAlignment(Pos.CENTER);
			
			Button attack = new Button("Attack");
			attack.setVisible(false);
			
			for(int i =0; i<attacker.getUnits().size();i++) {
				 String attackUnits = ((i+1) + ". Type: " + attacker.getUnits().get(i).getClass().getSimpleName() + "Level: " + attacker.getUnits().get(i).getLevel());
				 myArmy.getItems().add(attackUnits);
			 }
			 for(int i =0; i<defender.getUnits().size();i++) {
				 String defendUnits = ((i+1) +". Type: " + defender.getUnits().get(i).getClass().getName() + "Level: " + defender.getUnits().get(i).getLevel());
				 defArmy.getItems().add(defendUnits);
			 }
			
			
			Label turn = new Label("Let's battle");
			turn.setVisible(false);
			Button startYourTurn = new Button("Start Fight!");
			Button nextTurn = new Button(" Defender's Turn");
			nextTurn.setVisible(false);
			
			HBox buttons = new HBox(50);
			buttons.getChildren().addAll(attack,startYourTurn,nextTurn);
			buttons.setAlignment(Pos.CENTER);
			
			Label updates = new Label("The battle didn't start yet!");
			VBox finall = new VBox(100);
			finall.getChildren().addAll(view,buttons,turn,updates);
			finall.setAlignment(Pos.CENTER);

			startYourTurn.setOnAction(f ->{
				attack.setVisible(true);
				startYourTurn.setVisible(false);
				
			});
			Scene manual = new Scene(finall,1366,710);
			
						 	attack.setOnAction(f ->{
							try {
								String index1 = "";
								for(int s = 0; !(myArmy.getValue().charAt(s) + "").equals(".") ;s++) {
									index1 += myArmy.getValue().charAt(s) +  "";
								}
								int index = Integer.parseInt(index1);
								
								String index2 = "";
								for(int s = 0; !(defArmy.getValue().charAt(s) + "").equals(".") ;s++) {
									index2 += defArmy.getValue().charAt(s) +  "";
								}
								int indexDef = Integer.parseInt(index2);
								int bef = 0;
								int after = 0;
								try {
									bef = defender.getUnits().get(indexDef-1).getCurrentSoldierCount();
									attacker.getUnits().get(index-1).attack(defender.getUnits().get(indexDef-1));
									after = defender.getUnits().get(indexDef-1).getCurrentSoldierCount();
									int diff = (bef - after);
									String diss = "";
									if(diff <= 0) {
										diss = "this unit";
								
									}
									else
										diss = "" + diff;
									
									updates.setText(defender.getCurrentLocation() + "'s Army lost " + diss + " soldier");
									System.out.println(updates.getText());
									startYourTurn.setVisible(false);
									nextTurn.setVisible(true);
									defender.handleAttackedUnit(defender.getUnits().get(indexDef-1));
									defArmy.getItems().clear();
									for(int i =0; i<defender.getUnits().size();i++) {
										 String defendUnits = ((i+1) +". Type: " + defender.getUnits().get(i).getClass().getName() + "Level: " + defender.getUnits().get(i).getLevel());
										 defArmy.getItems().add(defendUnits);
									 }
									
									if(defender.getUnits().size() == 0){
										 game.occupy(attacker,defender.getCurrentLocation());
										 AlertBoxes.youWon("Alert!", "You won this battle !!");
										 gameOverScene(window); //Test..after Initalize
										 window.close();
									 }
									
									
								} catch (FriendlyFireException e1) {
									AlertBoxes.FriendlyFireException("Alert!","You can't attack your own army!");
								}
								
								turn.setText("Not Your Turn");
							}
							
							catch(NullPointerException e1) {
								AlertBoxes.EmptyChoiceBox("Alert!","Please Choose a unit!");
								manualAttackView(window, attacker, defender);
							}
							
						 });
						 	
			
			nextTurn.setOnAction(e->{
				
					
					 int du = (int) Math.random()*attacker.getUnits().size();
					 int au = (int) Math.random()*defender.getUnits().size();
					
						     try {
						    	 int bef = attacker.getUnits().get(au).getCurrentSoldierCount();
						    	 defender.getUnits().get(du).attack(attacker.getUnits().get(au));
						    	 if(attacker.getUnits().size() != 0) {
						    	 int after = attacker.getUnits().get(au).getCurrentSoldierCount();
						    	 int diff = (bef - after);
						    	 String diss = "";
						    	 if(diff <= 0) {
						    		 	diss = "this unit"; 	
						    	 }
										
								else
									diss = "" + diff;
						    	 
						    	 updates.setText("You lost" + diss);
						    	 System.out.println(updates.getText());
						    	 attack.setVisible(true);
								 nextTurn.setVisible(false);
								 
								 attacker.handleAttackedUnit(attacker.getUnits().get(au));
								 myArmy.getItems().clear();
					    		 	for(int i =0; i<attacker.getUnits().size();i++) {
					   				 String attackUnits = ((i+1) + ". Type: " + attacker.getUnits().get(i).getClass().getSimpleName() + "Level: " + attacker.getUnits().get(i).getLevel());
					   				 myArmy.getItems().add(attackUnits);
					   			 }
						    	 } 
					    		else {
					    			
					    			AlertBoxes.youLost("Alert!", "You lost this battle :( ");
									 for(int i=0; i<game.getAvailableCities().size();i++) {
										 if(game.getAvailableCities().get(i).getName().equals(defender.getCurrentLocation())) {
											 game.getAvailableCities().get(i).setTurnsUnderSiege(-1);
											 game.getAvailableCities().get(i).setUnderSiege(false);
										 }
									 }
									 
									 window.close();
								 }
								 
							} 
						     catch (FriendlyFireException f) {
								AlertBoxes.FriendlyFireException("Alert!","You can't attack your own army!");
							}
						     
							 turn.setText("It's your Turn");
			});
				
			 window.setScene(manual);
			
		}
	
	public HBox createArmy(String homeCity,Stage window) {
		
		City city = null;
		for(int j=0; j<game.getPlayer().getControlledCities().size();j++) {
			if(game.getPlayer().getControlledCities().get(j).getName().equals(homeCity)) {
				city = game.getPlayer().getControlledCities().get(j);
			}
		}
		HBox view = new HBox(50);
		if(city.getDefendingArmy().getUnits().size() == 0 && game.getPlayer().getControlledArmies().size() == 0)
			view.setVisible(false);
		VBox units = new VBox();
		units.setAlignment(Pos.CENTER);
		ChoiceBox<String> myArmy = new ChoiceBox<>();
		Label label = new Label("Please choose a unit: ");
		
		for(int i = 0; i<city.getDefendingArmy().getUnits().size();i++) {
			String s = (i+1) + "." + city.getDefendingArmy().getUnits().get(i).getClass().getSimpleName();
			myArmy.getItems().add(s);
		}
		Button create = new Button("Initiate Army");
		create.setOnAction(e -> {
			for(int j=0; j<game.getPlayer().getControlledCities().size();j++) {
				if(game.getPlayer().getControlledCities().get(j).getName().equals(homeCity)) {
				String index1 = "";
				try {
					for(int s = 0; !(myArmy.getValue().charAt(s) + "").equals(".") ;s++) {
						index1 += myArmy.getValue().charAt(s) +  "";
					}
					int index = Integer.parseInt(index1);
					Unit unit = game.getPlayer().getControlledCities().get(j).getDefendingArmy().getUnits().get(index-1);
					game.getPlayer().initiateArmy(game.getPlayer().getControlledCities().get(j), unit);
					
				
				if(homeCity.equals("Rome"))
					romeScene(window);
				else if(homeCity.equals("Cairo"))
					cairoScene(window);
				else
					spartaScene(window);
				}
		
			catch(NullPointerException e1) {
				AlertBoxes.EmptyChoiceBox("Alert!","Please Choose!");
				if(homeCity.equals("Rome"))
					romeScene(window);
				else if(homeCity.equals("Cairo"))
					cairoScene(window);
				else
					spartaScene(window);
			}	
				}
			}
		});	
		
		view.getChildren().addAll(label,myArmy,create);
		view.setAlignment(Pos.CENTER);
		
		return view;
	}
	
	
	public HBox Relocate(String currCity, Stage window) {
		HBox Relocate = new HBox();
		if(game.getPlayer().getControlledArmies().size() == 0)
			Relocate.setVisible(false);
		ChoiceBox<String> myArmies = new ChoiceBox<>();
		Label label = new Label("Please choose the Army: ");
		
		for(int i=0; i < game.getPlayer().getControlledArmies().size();i++) {
			if(game.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.IDLE))
					myArmies.getItems().add((i+1) + "." + game.getPlayer().getControlledArmies().get(i).getClass().getSimpleName() + (i+1));
		}
		
		
		ChoiceBox<String> myUnits = new ChoiceBox<>();
		Label labelUnits = new Label("Please choose a unit: ");
		ArrayList<Unit> avUnits = new ArrayList<>();
		
		for(int i=0; i < game.getPlayer().getControlledArmies().size();i++) {
			if(game.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.IDLE)) {
				for(int j=0; j < game.getPlayer().getControlledArmies().get(i).getUnits().size();j++)
					avUnits.add(game.getPlayer().getControlledArmies().get(i).getUnits().get(j));
					
			}
		}
		
		for(int i = 0; i < game.getPlayer().getControlledCities().size();i++) {
			for(int j=0; j < game.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().size();j++) {
				avUnits.add(game.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(j));
			}
		}
			
			
		for(int i = 0; i<avUnits.size();i++) {
			myUnits.getItems().add((i+1) + "." + avUnits.get(i).getClass().getSimpleName());
		}
		
		Button rell = new Button("Relocate Unit");
		rell.setOnAction(e -> {
			try {
				String index1 = "";
				String index2 = "";
				try{
					for(int s = 0; !(myArmies.getValue().charAt(s) + "").equals(".") ;s++) {
						index1 += myArmies.getValue().charAt(s) +  "";
					}	
					for(int j = 0; !(myUnits.getValue().charAt(j) + "").equals(".") ;j++) {
							index2 += myUnits.getValue().charAt(j) +  "";
					}
							
							
							int index = Integer.parseInt(index1);

							int indexU = Integer.parseInt(index2);
							if(game.getPlayer().getControlledArmies().get(index - 1).equals(avUnits.get(indexU - 1).getParentArmy()))
								AlertBoxes.MaxCapacityException("Alert!","You can't relocate in the same Army!");
							
							else
								game.getPlayer().getControlledArmies().get(index - 1).relocateUnit(avUnits.get(indexU - 1));
							
							if(currCity.equals("Rome"))
								romeScene(window);
							else if(currCity.equals("Cairo"))
								cairoScene(window);
							else
								spartaScene(window);
				
				}
				catch(NullPointerException e1) {
					AlertBoxes.EmptyChoiceBox("Alert!","Please Choose!");
					if(currCity.equals("Rome"))
						romeScene(window);
					else if(currCity.equals("Cairo"))
						cairoScene(window);
					else
						spartaScene(window);
					
				}
				
			} catch (MaxCapacityException e1) {
				AlertBoxes.MaxCapacityException("Alert!","The maximum capacity of adding units to an army is reached.");
			}

			});	
		Relocate.getChildren().addAll(labelUnits,myUnits,label,myArmies,rell);
		
		return Relocate;
	}
	
	
	}

