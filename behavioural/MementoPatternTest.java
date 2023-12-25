import java.util.ArrayList;
import java.util.List;

class OriginatorObject{
  private int temperature;
  private int volume;
  public OriginatorObject(int t, int v){
   temperature = t;
   volume = v;
  }
  public void setTemperature(int t){
   temperature = t;
  }
  public void setVolume(int v){
   volume = v;
  }
  public int getTemperature(){
   return temperature;
  }
  public int getVolume(){
   return volume;
  }
  public void restoreState(MementoObject m){
   temperature = m.getTemperature();
   volume = m.getVolume();
  }
  public MementoObject saveStateDetailsToMemento(){
   return new MementoObject(temperature, volume);
  }
  public String toString(){
   return "Temperature Value: " + temperature + " and Volume: " + volume;
  }
  public void operateMachine(){
   System.out.println("Machine operating with temperature: " + temperature + " and 
   Volume: " + volume);
  }
}

class MementoObject{
  private int temperature;
  private int volume;
  public MementoObject(int t, int v){
   temperature = t;
   volume = v;
  }
  public int getTemperature(){
    return temperature;
  }
  public int getVolume(){
    return volume;
  }
}

class CareTakerObject{
  private List<MementoObject> list = new ArrayList<MementoObject>();
  public void add(MementoObject m){
    list.add(m); 
  }
  public MementoObject getState(int i){
    return list.get(i);
  }
}

public class MementoPatternTest {
 // Create Originator Object
 // Call business Method on originator object
 // save state of originator
  public static void main(String[] args) {
    OriginatorObject Origin = new OriginatorObject(56, 78);
    Origin.operateMachine();
    Origin.saveStateDetailsToMemento();
  }
}
