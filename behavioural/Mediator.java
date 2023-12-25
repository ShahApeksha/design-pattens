interface Commander {

 void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankunit); 

 //here we can maintain a list as well

 void setAttackStatus(boolean attackStatus);

 boolean canAttack();

 void startAttack(ArmedUnit armedUnit);

 void ceaseAttack(ArmedUnit armedUnit);

}

interface ArmedUnit { 

 void attack(); 

 void stopAttack();

}

//Implementing the Mediator Interface 

class CommaderImpl implements Commander {

 ArmedUnit soldierUnit, tankUnit;

 boolean attackStatus = true;

 @Override

 public void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankunit) {

 this.tankUnit = tankunit;

 this.soldierUnit = soldierUnit;

 }

 @Override

 public void setAttackStatus(boolean attackStatus) {

 this.attackStatus = attackStatus;

 }

 @Override 

 public boolean canAttack() { 

 return attackStatus;

 }

 @Override

 public void startAttack(ArmedUnit armedUnit) {

 armedUnit.attack();

 }

 @Override

  public void ceaseAttack(ArmedUnit armedUnit) {

 armedUnit.stopAttack();

 }

}

class SoldierUnit implements ArmedUnit {

 //Keeping the reference of mediator private

 Commander commander; 

 public SoldierUnit(Commander commander) {

 this.commander = commander;

 }

 @Override 

 public void attack() {

 if (commander.canAttack()) {

 System.out.println("Soldier Unit is Currently Attacking...");

 commander.setAttackStatus(false);

 } 

 else { 

 System.out.println("Soldier Unit cannot attack now others are Currently Attacking...");

 }

 }

 @Override

 public void stopAttack() {

 System.out.println("Soldier Units has stopped Attacking now....");

 commander.setAttackStatus(true);

 }

} 

class TankUnit implements ArmedUnit {

  //Keeping the reference of mediator

 private Commander commander;

 public TankUnit(Commander commander) {

 this.commander = commander;

 }

 @Override public

 void attack() {

 if (commander.canAttack()) {

 System.out.println("Tank Unit is Currently Attacking...");

 commander.setAttackStatus(false);

 } 

 else {

 System.out.println("Tank Unit cannot attack now others are Currently Attacking...");

 }

 }

 @Override

 public void stopAttack() {

 System.out.println("Tank Units has stopped Attacking now....");

 commander.setAttackStatus(true);

 }

}

public class Mediator{

 public static void main(String[] args) {

 Commander commander= new CommaderImpl();

 ArmedUnit soldierUnit=new SoldierUnit(commander);

 ArmedUnit tankUnit=new TankUnit(commander);

 commander.registerArmedUnits(soldierUnit, tankUnit);

 commander.startAttack(soldierUnit);

 commander.startAttack(tankUnit);

 commander.ceaseAttack(soldierUnit);

 commander.startAttack(tankUnit);

 commander.startAttack(soldierUnit);

 }

}
