package units;

import exceptions.FriendlyFireException;

public class Archer extends Unit {
	 public Archer(int level, int maxSoldierCount, double idleUpkeep, double
			 marchingUpkeep, double siegeUpkeep) {
		 super(level,maxSoldierCount,idleUpkeep,marchingUpkeep,siegeUpkeep);
	 }
	 public void attack(Unit target) throws FriendlyFireException {
			super.attack(target); 
			double factor = 0;
			if(target instanceof Archer)
				if(this.getLevel() == 1)
					factor = 0.3;
				else if(this.getLevel() == 2)
					factor = 0.4;
				else
					factor = 0.5;
					
			else if (target instanceof Infantry)
				if(this.getLevel() == 1)
					factor = 0.2;
				else if(this.getLevel() == 2)
					factor = 0.3;
				else
					factor = 0.4;
			else
				if(this.getLevel() == 1)
					factor = 0.1;
				else if(this.getLevel() == 2)
					factor = 0.1;
				else
					factor = 0.2;
		
			target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(factor*getCurrentSoldierCount()));
			target.getParentArmy().handleAttackedUnit(target);
			}
	 
}
