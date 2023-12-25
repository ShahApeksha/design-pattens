import java.util.*;
abstract class Component{
  protected String name;
  public Component(String name){
    this.name = name;
  }
  public abstract void showName();
}
class Leaf extends Component{
  public Leaf(String name){
    super(name);
  }
  public void showName(){ System.out.println(name);}
}
class Composite extends Component{
  List<Component> ls = new ArrayList<Component>();
  public Composite(String name){
    super(name);
  }
  public void addComponent(Component c){
    ls.add(c);
  }
  public void removeComponent(Component c){
    ls.remove(c);
  }
  public void showName(){
    System.out.println("Displaying leaf components for : " + name);
    for(Component cs : ls){
      cs.showName();
  }
  }
}
class TestComposite{
  public static void main(String[] args){
    Component l1 = new Leaf("HDD");
    Component l2 = new Leaf("RAM");
    Component l3 = new Leaf("CPU");
    Composite cs1 = new Composite("Cabinet");
    Composite cs2 = new Composite("MotherBoard");
    Composite cs3 = new Composite("Computer");
    cs2.addComponent(l2);
    cs2.addComponent(l3);
    cs1.addComponent(l1);
    cs3.addComponent(cs1);
    cs3.addComponent(cs2);
    cs3.showName();
    cs1.showName();
    l1.showName();
  }
}
