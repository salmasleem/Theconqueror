package units;

import exceptions.FriendlyFireException;

public class Cavalry extends Unit {
	public Cavalry(int level, int maxSoldierCount, double idleUpkeep, double
			 marchingUpkeep, double siegeUpkeep) {
		 super(level,maxSoldierCount,idleUpkeep,marchingUpkeep,siegeUpkeep);
	 }
public void attack(Unit target) throws FriendlyFireException{
		
		super.attack(target);
		//System.out.println(this.getCurrentSoldierCount() + "/ " + target.getCurrentSoldierCount() + "/ " + target.getClass().getSimpleName());
		
		double factor = 0;
		if(target instanceof Archer) {
			if(this.getLevel() == 1)
				factor = 0.5;
			else if(this.getLevel() == 2)
				factor = 0.6;
			else
				factor = 0.7;
		}		
		else if (target instanceof Infantry) {
		
			if(this.getLevel() == 1)
				factor = 0.3;
			else if(this.getLevel() == 2)
				factor = 0.4;
			else
				factor = 0.5;
		}
		else {
			if(this.getLevel() == 1)
				factor = 0.2;
			else if(this.getLevel() == 2)
				factor = 0.2;
			else
				factor = 0.3;
		}
		
		target.setCurrentSoldierCount(target.getCurrentSoldierCount()-(int)(factor*getCurrentSoldierCount()));
		target.getParentArmy().handleAttackedUnit(target);
		//System.out.println(this.getCurrentSoldierCount() + "/ " + target.getCurrentSoldierCount());
		}
	
}
