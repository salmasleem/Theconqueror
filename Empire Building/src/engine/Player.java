package engine;

import java.util.ArrayList;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import units.Army;
import units.Status;
import units.Unit;

public class Player {
	 private String name;
	 private ArrayList<City> controlledCities;
	 private ArrayList<Army> controlledArmies;
	 private double treasury;
	 private double food;
	 
	 public Player(String name) {
		 this.name=name;
		 controlledCities =  new ArrayList<City>();
		 controlledArmies = new ArrayList<Army>();
		 treasury = 5000;
	 }

	public String getName() {
		return name;
	}


	public ArrayList<City> getControlledCities() {
		return controlledCities;
	}

	public ArrayList<Army> getControlledArmies() {
		return controlledArmies;
	}

	public double getTreasury() {
		return treasury;
	}

	public void setTreasury(double treasury) {
		this.treasury = treasury;
	}

	public double getFood() {
		return food;
	}

	public void setFood(double food) {
		this.food = food;
	}
	public void recruitUnit(String type, String cityName)
			throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException {
		for (City c : controlledCities) {
			if (c.getName().equals(cityName)) {
				for (MilitaryBuilding b : c.getMilitaryBuildings()) {
					if ((type.toLowerCase().equals("archer") && b instanceof ArcheryRange)
							|| (type.toLowerCase().equals("cavalry") && b instanceof Stable)
							|| (type.toLowerCase().equals("infantry") && b instanceof Barracks)) {
						Unit u = b.recruit();
						if(treasury < b.getRecruitmentCost())
							throw new NotEnoughGoldException("Not enough gold");
						treasury -= b.getRecruitmentCost();
						u.setParentArmy(c.getDefendingArmy());
						c.getDefendingArmy().getUnits().add(u);
					}
				}
			}
		}

	}
	public void build(String type,String cityName) throws NotEnoughGoldException{
		 City x = null;
		 Building b = null;
		 String BT = "";
			for(int i = 0; i<this.controlledCities.size();i++) {
				if(this.controlledCities.get(i).getName().equals(cityName)) {
					x = controlledCities.get(i);	
				}
			}
			if(type.equals("Farm")) {
					for(int i=0; i<x.getEconomicalBuildings().size();i++)
						if(x.getEconomicalBuildings().get(i) instanceof Farm)
							return;
					b = new Farm();
					BT = "EconomicalBuildings";
			}	
			else if (type.equals("Market")) {
				for(int i=0; i<x.getEconomicalBuildings().size();i++)
					if(x.getEconomicalBuildings().get(i) instanceof Market)
						return;
					b = new Market();
					BT = "EconomicalBuildings";
				}
			
			else if (type.equals("Stable")) {
				for(int i=0; i<x.getMilitaryBuildings().size();i++)
					if(x.getMilitaryBuildings().get(i) instanceof Stable)
						return;
				b = new Stable();
				BT = "MilitaryBuildings";
			}
			else if (type.equals("ArcheryRange")) {
				for(int i=0; i<x.getMilitaryBuildings().size();i++)
					if(x.getMilitaryBuildings().get(i) instanceof ArcheryRange)
						return;
				b = new ArcheryRange();
				BT = "MilitaryBuildings";
			}
			else
			{
				for(int i=0; i<x.getMilitaryBuildings().size();i++)
					if(x.getMilitaryBuildings().get(i) instanceof Barracks)
						return;
				b = new Barracks();
				BT = "MilitaryBuildings";
			}
			if(this.treasury < b.getCost()) {
				throw new NotEnoughGoldException("You don't have moneyy");
			}
				if(BT == "MilitaryBuildings") 
					x.getMilitaryBuildings().add((MilitaryBuilding) b);
				else 
					x.getEconomicalBuildings().add((EconomicBuilding) b);

				double cost = this.treasury - b.getCost();
				b.setCoolDown(true);
				this.setTreasury(cost);
			}
	
	 public void upgradeBuilding(Building b) throws NotEnoughGoldException,
	 BuildingInCoolDownException, MaxLevelException{
		 if(b.isCoolDown()) {
				BuildingInCoolDownException z = new BuildingInCoolDownException("Try Again Next Turn");
	 			throw z;
			}
			if(this.treasury < b.getUpgradeCost()) {
				NotEnoughGoldException NE = new NotEnoughGoldException("not enough gold");
				throw NE;
			}
			if(b.getLevel() == 3)	
			{
				MaxLevelException ML = new MaxLevelException();
				throw ML;
			}
			double m = this.getTreasury() - b.getUpgradeCost();
			this.setTreasury(m);
			b.upgrade();
	 }
	 public void initiateArmy(City city, Unit unit) {
			Army army = new Army(city.getName());
			army.getUnits().add(unit);
			city.getDefendingArmy().getUnits().remove(unit);
			unit.setParentArmy(army);
			controlledArmies.add(army);
	 }
	 public void laySiege(Army army,City city) throws TargetNotReachedException,
	 FriendlyCityException{
		 city.setTurnsUnderSiege(0);
		 army.setCurrentStatus(Status.BESIEGING);
		 city.setUnderSiege(true);
		 
		 if (this.controlledCities.contains(city)) {
				FriendlyCityException FC = new FriendlyCityException();
				throw FC;
			}
		 if(army.getDistancetoTarget() != -1) {
			 TargetNotReachedException T = new TargetNotReachedException();
			 throw T;
		 }
	 }
	 
	 }
	 

