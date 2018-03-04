import scala.io
import scala.io.Source

val orderItems = Source.fromFile("data/retail_db/orders/part-00000")
orderItems.take(10).foreach(println)// this will result in printing each character as a record and prints the character
val orderItems = Source.fromFile("data/retail_db/orders/part-00000").getlines
orderItems.take(10).foreach(println)// this will result in printing each line as record


//in a given dataset of transactions find sum of all transactions that are CLOSED
val orderItems = Source.fromFile("data/retail_db/orders/part-00000").getlines.toList
val orderItemsFilter = orderItems.filter(item => item.split(",")(3)=="CLOSED")

//map function that does a row transformation of obtaining the ordercost
val orderItemsMap = orderItemsFilter.map(ele => ele.split(",")(2).toFloat)
//alternative syntax for map
val orderItemsMap = orderItemsFilter.map(_.split(",")(2).toFloat)

//reduce function that does a sum of al results obtained in map function
val orderItemsReduce = orderItemsMap.reduce((total,ele) => total+ele)
//alternative syntax for reduce
val orderItemsReduce = orderItemsMap.reduce(_+_)
