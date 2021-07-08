package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Infantry;
import units.Unit;

public class Barracks extends MilitaryBuilding {
    public Barracks() {
    	super(2000,1000,500);
    }
    public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
    	super.upgrade();
		if(this.getLevel() == 1) {
			this.setLevel(2);
			this.setUpgradeCost(1500);
			this.setRecruitmentCost(550);
		}
		else if(this.getLevel() == 2) {
			this.setLevel(3);
			this.setRecruitmentCost(600);
		}
	}

	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException {
		if(this.isCoolDown()) {
 			BuildingInCoolDownException x = new BuildingInCoolDownException();
 			throw x;
 		}
		int s = this.getCurrentRecruit();
		if(s<this.getMaxRecruit()) {
			int level = this.getLevel();
			Infantry I = null;
			if(level==1)
				 I = new Infantry(1, 50, 0.5, 0.6, 0.7);
			else if(level==2)
				I = new Infantry(2, 50, 0.5, 0.6, 0.7);
			else if(level==3)
				I = new Infantry(3, 60, 0.6, 0.7, 0.8);
			
			this.setCurrentRecruit(s+1);
			return I;
		}
		else {
			MaxRecruitedException x = new MaxRecruitedException();
			throw x;
		}
	}
}
