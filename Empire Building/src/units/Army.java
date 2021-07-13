package units;
import java.util.ArrayList;

import exceptions.MaxCapacityException;

public class Army {
	 private Status currentStatus;
	 private ArrayList<Unit> units;
	 private int distancetoTarget;
	 private String target;
	 private String currentLocation;
	 final private int maxToHold=10;
	 
	 public Army(String currentLocation) {
		 currentStatus= Status.IDLE;
		 this.currentLocation=currentLocation;
		 target="";
		 distancetoTarget=-1;
		 units = new ArrayList<Unit>();
	 }

	public Status getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

	public void setUnits(ArrayList<Unit> units) {
		this.units = units;
	}

	public int getDistancetoTarget() {
		return distancetoTarget;
	}

	public void setDistancetoTarget(int distancetoTarget) {
		this.distancetoTarget = distancetoTarget;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public int getMaxToHold() {
		return maxToHold;
	}
	public double foodNeeded() {
		double foodNeeded = 0;
		if(this.currentStatus==Status.IDLE) {
			 for(int i=0; i<units.size(); i++) {
				foodNeeded += this.units.get(i).getIdleUpkeep()*this.units.get(i).getCurrentSoldierCount();
			 }
		 }
		else if(this.currentStatus==Status.MARCHING) {
			for(int i=0; i<units.size(); i++) {
				foodNeeded += this.units.get(i).getMarchingUpkeep()*this.units.get(i).getCurrentSoldierCount();
			 }
		}
		else {
			for(int i=0; i<units.size(); i++) {
				foodNeeded += this.units.get(i).getSiegeUpkeep()*this.units.get(i).getCurrentSoldierCount();
			 }
		}
		return foodNeeded;
	 }
	public void relocateUnit(Unit unit) throws MaxCapacityException{		
		if(units.size()<this.getMaxToHold()) {
			units.add(unit);
			for(int i=0; i<unit.getParentArmy().getUnits().size();i++) {
				if(unit.getParentArmy().getUnits().get(i).equals(unit)) {
					unit.getParentArmy().getUnits().remove(i);
					break;
				}			
			}
			unit.setParentArmy(this);
		}
		else {
			MaxCapacityException y = new MaxCapacityException();
			throw y;
		}		
	}
public void handleAttackedUnit(Unit u) {
		
		if(u.getCurrentSoldierCount() <= 0) {
			u.setCurrentSoldierCount(0);
			units.remove(u);
		}
}
}
