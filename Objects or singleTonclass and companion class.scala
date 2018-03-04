//Scala doesnt have static keyword all the methods that are required for static usage can be declared in object instance
object HelloWorld{
  def main (args: Array[String]): Unit ={
    println("HellowWorld")
  }
}
s

//object with same name as class
class Order(var orderId: Int,var orderDate: String,var orderedByCustomerId: Int,var orderStatus: String){
  println("class constructor")
  override def toString = "Order("+orderId+","+orderDate+","+orderedByCustomerId+","+orderStatus+")"
}

object Order{
  def apply(orderId: Int,orderDate: String,orderedByCustomerId: Int,orderStatus: String): Order = {
    new Order(orderId,orderDate,orderedByCustomerId,orderStatus)
  }
}

//in scala if we have object and class declared with same name we have two class files one with same name as class and another with $ at the end
:javap -p Order$ will give metadata of object

//when you have Object block with same name as class there is no need to invoke apply method

Order order = Order(1,"jhshjah",122,"asasas")// simple use case of no need to use new keyword to create an object

//we can create as many apply methods as the construictors, if we have 3 constructors we can have 3 aply gettermethods
