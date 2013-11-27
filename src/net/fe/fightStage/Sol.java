package net.fe.fightStage;

import net.fe.RNG;
import net.fe.unit.Unit;

public class Sol extends CombatTrigger {
	public Sol(){
		super(REPLACE_NAME_AFTER_PRE, YOUR_TURN_PRE + YOUR_TURN_POST);
	}
	@Override
	public boolean attempt(Unit user) {
		return RNG.get() < user.get("Skl");
	}
	
	public void runPostAttack(FightStage stage, boolean dir, Unit a, Unit d, int damage){
		if(damage == 0) return;
		int heal = Math.min(damage/2, a.get("HP") - a.getHp());
		stage.addToAttackQueue(a, a, "Sol2", -heal);
		a.setHp(a.getHp() + damage/2);
	}
	
	public String getName(){
		return "Sol1";
	}
}
