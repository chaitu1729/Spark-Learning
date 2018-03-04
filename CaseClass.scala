//declaring class as a case class will implemnt two other classes namely Product and Serializable
case class  Order(var orderId: Int,var orderDate: String,var orderedByCustomerId: Int,var orderStatus: String){
  println("class constructor")
  override def toString = "Order("+orderId+","+orderDate+","+orderedByCustomerId+","+orderStatus+")"
}
//unix command to see all previous commands that starts with order()
:h? order(

  val order = new Order(2,"10/102018",100,"Placed")
  order.productArity //will return 4 which is number of input arguments
  order.productElement(0)//will give first productElement
  order.productIterator//will return iterator(Any) object
  order.productPrefix//will return className (String)
