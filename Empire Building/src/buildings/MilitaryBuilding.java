package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxRecruitedException;
import units.Unit;


public abstract class MilitaryBuilding extends Building {
	
	private int recruitmentCost;
	private int currentRecruit;
	final private int maxRecruit=3;
	 
	 public MilitaryBuilding(int cost, int upgradeCost,int recruitmentCost) {
		 super(cost,upgradeCost);
		 this.recruitmentCost=recruitmentCost;
	 }
	 
	 public int getRecruitmentCost() {
			return recruitmentCost;
		}

		public void setRecruitmentCost(int recruitmentCost) {
			this.recruitmentCost = recruitmentCost;
		}

		public int getCurrentRecruit() {
			return currentRecruit;
		}

		public void setCurrentRecruit(int currentRecruit) {
			this.currentRecruit = currentRecruit;
		}

		public int getMaxRecruit() {
			return maxRecruit;
		}
//		public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
//			if (this.isCoolDown()) {
//	 		    BuildingInCoolDownException x = new BuildingInCoolDownException();
//				throw x;
//	 	}
//			if(this instanceof ArcheryRange)
//			{
//				if(this.getLevel() == 1) {
//					this.setLevel(2);
//					this.setUpgradeCost(700);
//					this.setRecruitmentCost(450);
//					this.setCoolDown(true);
//				}
//				else if(this.getLevel() == 2) {
//					this.setLevel(3);
//					this.setRecruitmentCost(500);
//					this.setCoolDown(true);
//				}
//				else {
//					MaxLevelException x = new MaxLevelException();
//					throw x;
//				}
//				}
//				else if(this instanceof Barracks)
//				{
//					if(this.getLevel() == 1) {
//						this.setLevel(2);
//						this.setUpgradeCost(1500);
//						this.setRecruitmentCost(550);
//						this.setCoolDown(true);
//					}
//					else if(this.getLevel() == 2) {
//						this.setLevel(3);
//						this.setRecruitmentCost(600);
//						
//					}
//					else {
//						MaxLevelException x = new MaxLevelException();
//						throw x;
//					}
//				}else if(this instanceof Stable)
//				{
//					if(this.getLevel() == 1) {
//						this.setLevel(2);
//						this.setUpgradeCost(2000);
//						this.setRecruitmentCost(650);
//						this.setCoolDown(true);
//					}
//					else if(this.getLevel() == 2) {
//						this.setLevel(3);
//						this.setRecruitmentCost(700);
//						this.setCoolDown(true);
//					}
//					else {
//						MaxLevelException x = new MaxLevelException();
//						throw x;
//					}
//			
//		}
//		}
		 public abstract Unit recruit() throws BuildingInCoolDownException,
		 MaxRecruitedException;
}
