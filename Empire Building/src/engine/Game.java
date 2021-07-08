package engine;
import java.io.IOException;
import java.util.ArrayList;

import buildings.Farm;
import exceptions.FriendlyFireException;
import units.*;

public class Game {
	 private Player player;
	 private ArrayList<City> availableCities;
	 private ArrayList<Distance> distances;
	 final private int maxTurnCount=50;
	 private int currentTurnCount;
	 
	 
	 public Game(String playerName,String playerCity) throws IOException{
			player = new Player(playerName);
			availableCities = new ArrayList<City>();
			distances = new ArrayList<Distance>();
			currentTurnCount = 1;
			loadCitiesAndDistances();

		for(int i = 0; i<availableCities.size();i++){
			if(availableCities.get(i).getName().equals(playerCity)) {
				player.getControlledCities().add(availableCities.get(i));
				availableCities.get(i).setDefendingArmy(new Army(playerCity));
			}	
			else 
			{
				String name = availableCities.get(i).getName();
				String csv = name + "_army.csv";
				loadArmy(name,csv);	
			}
				
			}
	 }

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<City> getAvailableCities() {
		return availableCities;
	}

	public ArrayList<Distance> getDistances() {
		return distances;
	}


	public int getCurrentTurnCount() {
		return currentTurnCount;
	}

	public void setCurrentTurnCount(int currentTurnCount) {
		this.currentTurnCount = currentTurnCount;
	}

	public int getMaxTurnCount() {
		return maxTurnCount;
	}
	
	public void loadArmy(String cityName,String path) throws IOException{ 
		Unit a = null;
		Army homeArmy = new Army(cityName);
		ArrayList<String[]> armies = Read.readFile(path);
//		if(cityName.equals("Cairo"))
//			System.out.println(armies.size());
		ArrayList<Unit> u = new ArrayList<Unit>();
		for(int i = 0; i<armies.size();i++) {
			
			if(armies.get(i)[0].equals("Archer")) {
				if(Integer.parseInt(armies.get(i)[1]) == 3)
					a = new Archer(Integer.parseInt(armies.get(i)[1]),70,0.5,0.6,0.7);
				else //level 1 or 2
					a = new Archer(Integer.parseInt(armies.get(i)[1]),60,0.4,0.5,0.6);
			}
			else if(armies.get(i)[0].equals("Infantry")) {
				if(Integer.parseInt(armies.get(i)[1]) == 3)
					a = new Infantry(Integer.parseInt(armies.get(i)[1]),60,0.6,0.7,0.8);
				else
					a = new Infantry(Integer.parseInt(armies.get(i)[1]),50,0.5,0.6,0.7);
			}
			else if(armies.get(i)[0].equals("Cavalry")){
				if(Integer.parseInt(armies.get(i)[1]) == 3)
					a = new Cavalry(Integer.parseInt(armies.get(i)[1]),60,0.7,0.8,0.9);
				else
					a = new Cavalry(Integer.parseInt(armies.get(i)[1]),40,0.6,0.7,0.75);
			}
			
				u.add(a);
				a.setParentArmy(homeArmy);
			
				}	
		homeArmy.setUnits(u);
		for(int i = 0;i<availableCities.size();i++) {
				if(availableCities.get(i).getName().equals(cityName))
					availableCities.get(i).setDefendingArmy(homeArmy);
			}
		
					
	}	
		   
	//method that loads cities and distances 
	private void loadCitiesAndDistances() throws IOException{
		
		ArrayList<String[]> s = Read.readFile("distances.csv");
		for(int i = 0; i<s.size();i++)
		{
			Distance D = new Distance((s.get(i)[0]),s.get(i)[1],Integer.parseInt(s.get(i)[2]));
			distances.add(D);
		
		}
		ArrayList<String> cities = new ArrayList<String>();
		for(int i = 0; i<s.size();i++) {
			if(!(cities.contains(s.get(i)[0]))) {
				cities.add(s.get(i)[0]);
				availableCities.add(new City(s.get(i)[0]));
			}
			if(!(cities.contains(s.get(i)[1]))) {
				cities.add(s.get(i)[1]);
				availableCities.add(new City(s.get(i)[1]));
			}
				
		}
	}
	public void targetCity(Army army, String targetName)  {		
		if(army.getCurrentStatus()==Status.MARCHING) {
			return;
		}
		String currentCity = army.getCurrentLocation();
		
		int newDistance = 0;
		for(int i=0;i<this.distances.size();i++) {
			if(this.distances.get(i).getFrom().equals(currentCity) && this.distances.get(i).getTo().equals(targetName)) {
				newDistance= this.distances.get(i).getDistance();
			}
			else if(this.distances.get(i).getFrom().equals(targetName) && this.distances.get(i).getTo().equals(currentCity)) {
				newDistance= this.distances.get(i).getDistance();
			}
		}
		army.setCurrentLocation("onRoad");
		army.setTarget(targetName);
		army.setCurrentStatus(Status.MARCHING);
		army.setDistancetoTarget(newDistance);
	}
	public void endTurn() {
		int food = 0;
		int cash= 0;
		this.setCurrentTurnCount(this.getCurrentTurnCount() + 1);
//      for loop that does first 4 points
		for(int i=0; i<this.getPlayer().getControlledCities().size();i++) {
			for(int j=0; j<this.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {
				this.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).setCoolDown(false);
				if(this.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j) instanceof Farm)
				    food += this.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).harvest();
				else
					cash+= this.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).harvest();				
			}
			
		
			for(int j=0; j<this.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
				this.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).setCoolDown(false);
				this.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).setCurrentRecruit(0);
			}	
	}
		double foodRequired = 0;
		//for loop that calculates the food needed by the army
		for(int i=0; i < this.getPlayer().getControlledArmies().size(); i++) {
			foodRequired += this.getPlayer().getControlledArmies().get(i).foodNeeded();
			if( this.getPlayer().getControlledArmies().get(i).getTarget()!="") { 
				this.getPlayer().getControlledArmies().get(i).setDistancetoTarget(this.getPlayer().getControlledArmies().get(i).getDistancetoTarget() -1);
				if(this.getPlayer().getControlledArmies().get(i).getDistancetoTarget() == 0) {
					this.getPlayer().getControlledArmies().get(i).setCurrentLocation(this.getPlayer().getControlledArmies().get(i).getTarget());
					this.getPlayer().getControlledArmies().get(i).setTarget("");
					this.getPlayer().getControlledArmies().get(i).setCurrentStatus(Status.IDLE);
					this.getPlayer().getControlledArmies().get(i).setDistancetoTarget(-1);
				}
				}
		}
		for(int i=0; i < this.getPlayer().getControlledCities().size(); i++) {
			foodRequired+=this.getPlayer().getControlledCities().get(i).getDefendingArmy().foodNeeded();
		}
		
		this.getPlayer().setTreasury(this.getPlayer().getTreasury()+cash);
		this.getPlayer().setFood(this.getPlayer().getFood()+food);
		
		if(foodRequired < this.getPlayer().getFood())
		this.getPlayer().setFood(this.getPlayer().getFood()-foodRequired);
		else {
			for(int i=0; i < this.getPlayer().getControlledArmies().size(); i++) {
				for(int j = 0; j < this.getPlayer().getControlledArmies().get(i).getUnits().size(); j++) {
					this.getPlayer().getControlledArmies().get(i).getUnits().get(j).setCurrentSoldierCount((int) (this.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()*0.9));
		        }
	         }
			for(int i=0; i < this.getPlayer().getControlledCities().size(); i++) {
				for(int j = 0; j < this.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().size(); j++) {
				this.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(j).setCurrentSoldierCount((int) (this.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(j).getCurrentSoldierCount()*0.9));
			}
			}
			
			this.getPlayer().setFood(0);
		}
		for(int i=0; i < getAvailableCities().size();i++) {
			if(this.getAvailableCities().get(i).isUnderSiege() ) {
				if(this.getAvailableCities().get(i).getTurnsUnderSiege()!=3) {
				this.getAvailableCities().get(i).setTurnsUnderSiege(1 + this.getAvailableCities().get(i).getTurnsUnderSiege());
				for(int j =0; j < this.getAvailableCities().get(i).getDefendingArmy().getUnits().size(); j++)
					this.getAvailableCities().get(i).getDefendingArmy().getUnits().get(j).setCurrentSoldierCount((int) (this.getAvailableCities().get(i).getDefendingArmy().getUnits().get(j).getCurrentSoldierCount()*0.9));
			}
			else {
					this.getAvailableCities().get(i).setUnderSiege(false);
					this.getAvailableCities().get(i).setTurnsUnderSiege(-1);
					
				}
			}
		}
	}
	public void occupy(Army a,String cityName) {
		for(int i=0; i < getAvailableCities().size();i++) {
			if(this.getAvailableCities().get(i).getName().equals(cityName)){				
				this.getPlayer().getControlledCities().add(this.getAvailableCities().get(i));
				this.getAvailableCities().get(i).setDefendingArmy(a);
				this.getAvailableCities().get(i).setUnderSiege(false);
				this.getAvailableCities().get(i).setTurnsUnderSiege(-1);	
		   }
		}
	}
	 public void autoResolve(Army attacker, Army defender) throws
	 FriendlyFireException{
		 if(this.getPlayer().getControlledArmies().contains(defender)) {
			 throw new FriendlyFireException();
		 }
		 for(int round=0;attacker.getUnits().size()!=0 && defender.getUnits().size()!=0; round++) {
			 int au = (int) Math.random()*attacker.getUnits().size();
			 int du = (int) Math.random()*attacker.getUnits().size();
			 if(round%2==0) { 
				     attacker.getUnits().get(au).attack(defender.getUnits().get(du));
				 }
				 else {
					 defender.getUnits().get(du).attack(attacker.getUnits().get(au));
				 }
			 }
		 if(attacker.getUnits().size()>0){
			 occupy(attacker,defender.getCurrentLocation());
			 
		 }
		 else {
			 for(int i=0; i<this.availableCities.size();i++) {
				 if(this.availableCities.get(i).getName().equals(defender.getCurrentLocation())) {
					 this.getAvailableCities().get(i).setTurnsUnderSiege(-1);
					 this.getAvailableCities().get(i).setUnderSiege(false);
					 this.player.getControlledArmies().remove(attacker);
				 }
			 }
		 }
		 
	 }
	 
	 public boolean isGameOver() {
		 if(this.getPlayer().getControlledCities().size()==this.getAvailableCities().size()) {
			 return true;
		 }else if(this.getCurrentTurnCount()>=this.getMaxTurnCount()) {
			 return true;
			 }
		 else {
				 return false;
				 }
		 }
	 }

