import java.util.*;

abstract class Component{

  protected String name;

  public Component(String n){

  name = n;

  }

  abstract public void showName();

}
class Leaf extends Component{

  public Leaf(String name){

  super(name);

 }

  public void showName(){

   System.out.println(name);

 } 

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

   System.out.println("Composite: " + name);

   System.out.println("Leaf: ");

   for (Component c : ls)

   c.showName();
 

  } 

 }
public class DecoratorDesignPattern {

 public static void main(String[] args){

 Component l1 = new Leaf("HDD");

 Component l2 = new Leaf("CPU");

 Component l3 = new Leaf("RAM");

 Composite c1 = new Composite("cabinet");

 Composite c2 = new Composite("Mother-Board");

 Composite c3 = new Composite("Computer");

 c2.addComponent(l2);

 c2.addComponent(l3);

 c1.addComponent(l1);

 c1.addComponent(c2);

 c3.addComponent(c1);

 l3.showName();

 l2.showName();

 System.out.println("*********");

 c2.showName();

 }

}

OU
