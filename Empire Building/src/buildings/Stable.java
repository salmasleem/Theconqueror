package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Cavalry;
import units.Unit;

public class Stable extends MilitaryBuilding {
    public Stable() {
    	super(2500,1500,600);
    }
    public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
    	super.upgrade();
		if(this.getLevel() == 1) {
			this.setLevel(2);
			this.setUpgradeCost(2000);
			this.setRecruitmentCost(650);
		
		}
		else if(this.getLevel() == 2) {
			this.setLevel(3);
			this.setRecruitmentCost(700);
		}
	}
public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException {
	if (this.isCoolDown()) {
		    BuildingInCoolDownException x = new BuildingInCoolDownException();
		throw x;
	}
		int s = this.getCurrentRecruit();
		if(s<this.getMaxRecruit()) {
			int level = this.getLevel();
			Cavalry C = null;
			if(level==1)
				 C = new Cavalry(1, 40, 0.6, 0.7, 0.75);
				
			else if(level==2)
				C = new Cavalry(2, 40, 0.6, 0.7, 0.75);
			else if(level==3)
				C = new Cavalry(3, 60, 0.7, 0.8, 0.9);
			
			this.setCurrentRecruit(s+1);
			return C;	
		}
		else {
			MaxRecruitedException x = new MaxRecruitedException();
			throw x;
		}
	}
}
