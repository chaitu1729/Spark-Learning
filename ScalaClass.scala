
//Declaring calss like below will create some final variables which we cant access and hence if we need to access the variables we have to declare them as variables shown in second way

class Order(vaorderId: Int,orderDate: String,orderedByCustomerId: Int,orderStatus: String){
  println("class constructor")
  override def toString = "Order("+orderId+","+orderDate+","+orderedByCustomerId+","+orderStatus+")"
}



//declaring class like this will create gettermethods for the variable above we can access them but how do we modify them???
class Order(val orderId: Int,val orderDate: String,val orderedByCustomerId: Int,val orderStatus: String){
  println("class constructor")
  override def toString = "Order("+orderId+","+orderDate+","+orderedByCustomerId+","+orderStatus+")"
}

//declaring class like this will create gettermethods and setter method which are mutable
class Order(var orderId: Int,var orderDate: String,var orderedByCustomerId: Int,var orderStatus: String){
  println("class constructor")
  override def toString = "Order("+orderId+","+orderDate+","+orderedByCustomerId+","+orderStatus+")"
}
