import java.util.*;

class SubjectEntity{

 private List<ObserverObject> lm = new ArrayList<ObserverObject>();

 private int numberState;

 public void setNumberState(int n){

 numberState = n;

 notifyAllObservers();

 }

 public int getNumberState(){

 return numberState;

 }

 public void registerObserver(Object o){

 lm.add((ObserverObject) o);

 }

 public void UnRegisterObserver(ObserverObject o){

 lm.remove(o);

 }

 public void notifyAllObservers() {

 for(ObserverObject o : lm){

 o.update();

 }

 }

}

abstract class ObserverObject{

 SubjectEntity sm;

 abstract public void update();

}

class BinaryObserverObject extends ObserverObject{

 public BinaryObserverObject (SubjectEntity e){

 sm= e;

 sm.registerObserver(this);

 }

 public void update(){

 int n = sm.getNumberState();

 System.out.println("Updating binary number: " + n + " to binary state: " + 

Integer.toBinaryString(n));

 }

}

// creating hex 

class HexObserverObject extends ObserverObject{

 public HexObserverObject (SubjectEntity e){

 sm= e;

 sm.registerObserver(this);

 }

 public void update(){

 int n = sm.getNumberState();

 System.out.println("Updating hex number: " + n + " to hex state: " + 

Integer.toHexString(n));

 }

}

class OctalObserverObject extends ObserverObject{

 public OctalObserverObject (SubjectEntity e){

 sm= e;

 sm.registerObserver(this);

 }

 public void update(){

 int n = sm.getNumberState();

 System.out.println("Updating octal number: " + n + " to octal state: " + 

Integer.toOctalString(n));

 }

}

public class ObserverPatternDemo {

 public static void main(String[] args){

 SubjectEntity se = new SubjectEntity();

 ObserverObject o1 = new BinaryObserverObject(se);

 ObserverObject o2 = new HexObserverObject(se);

 ObserverObject o3 = new OctalObserverObject(se);

 se.setNumberState(12);

 //ObserverObject o2 = new HexObserverObject(se);

 //se.setNumberState(15); 

 }

}
