class ProductModelEntity{

 int id;

 String name;

 public ProductModelEntity(int id, String n){

 this.id = id;

 name = n;

 }

 public void setId(int id){

 this.id = id;

 }

 public int getID(){

 return id;

 }

 public void setName(String name){

 this.name = name;

 }

 public String getName(){

 return name;

 }

}

class ViewEntity{

 public void printProduct(int id, String name){

 System.out.println("Employee Details: " + id + " and Name: " + name);

 }

}

class ControllerEntity{

 ProductModelEntity pm;

 ViewEntity ve;

 public ControllerEntity(ProductModelEntity p, ViewEntity v){

 pm = p;

 ve = v;

 }

 public void setId(int id){

 pm.setId(id);

 }

 public void setName(String name){

 pm.setName(name);

 }

 public void updateProductView(int id, String name){

 ve.printProduct(id, name);

 }

}

class MVCPatternDemo{

 public static void main(String[] args){

 ProductModelEntity p1 = new ProductModelEntity(101, "PR1");

 ProductModelEntity p2 = new ProductModelEntity(102, "PR1");

 ViewEntity v1 = new ViewEntity();

 ControllerEntity ce = new ControllerEntity(p1, v1);

 v1.printProduct(p1.getID(), p1.getName());

 ce.setName("PR3");

 ce.updateProductView(p1.getID(), p1.getName());

 

 }

}
