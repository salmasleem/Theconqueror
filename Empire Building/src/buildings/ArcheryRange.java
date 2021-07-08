package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Archer;
import units.Unit;

public class ArcheryRange extends MilitaryBuilding {
     public ArcheryRange() {
    	 super(1500,800,400);
     }
     public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
 		super.upgrade();
				if(this.getLevel() == 1) {
					this.setLevel(2);
					this.setUpgradeCost(700);
					this.setRecruitmentCost(450);
				}
				else if(this.getLevel() == 2) {
					this.setLevel(3);
					this.setRecruitmentCost(500);
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
			Archer A = null;
			if(level==1)
				 A = new Archer(1,60, 0.4, 0.5, 0.6);
			else if(level==2)
				A = new Archer(2,60, 0.4, 0.5, 0.6);
			else if(level==3)
				A = new Archer(3, 70, 0.5, 0.6, 0.7);
			
			this.setCurrentRecruit(s+1);
			return A;
		}
		else {
			MaxRecruitedException x = new MaxRecruitedException();
			throw x;
		}
		
	}
     
}
