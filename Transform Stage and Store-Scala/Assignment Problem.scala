import scala.io.Source
val orders = sc.textFile("/public/retail_db/orders")
val order_Items = sc.textFile("/public/retail_db/order_items")
orders.take(10).foreach(println)
order_Items.take(10).foreach(println)

val ordersMap = orders.map(order => (order.split(",")(0).toInt,(order.split(",")(1).substring(0,10),order.split(",")(3))))
val ordersMap_Filtered = ordersMap.filter(order => ((order._2._2 == "COMPLETE") || (order._2._2 == "CLOSED")))
ordersMap_Filtered.take(10).foreach(println)

val order_ItemsMap = order_Items.map(orderItem => ((orderItem.split(",")(1).toInt,(orderItem.split(",")(2).toInt,orderItem.split(",")(4).toFloat))))
order_ItemsMap.take(10).foreach(println)


val ordersJoined = ordersMap.join(order_ItemsMap)
ordersJoined.take(10).foreach(println)

val ordersByDateAndOrderId = ordersJoined.map(order => ((order._1,order._2._1._1,order._2._2._1),(order._2._2._2)))
ordersByDateAndOrderId.take(10).foreach(println)

val ordersGroupBy = ordersByDateAndOrderId.groupByKey()
ordersGroupBy.take(35).foreach(println)
ordersGroupBy.map(order => (order._2._1,order._2._2)).take(10).foreach(println)

val ordersGroupedSum = ordersGroupBy.map(order => {

val ordersSum = order._2.toList.sum
(order._1,ordersSum)
})
ordersGroupedSum.take(35).foreach(println)

val ordersReformatted = ordersGroupedSum.map(order => (order._1._3,(order._1._1,order._1._2,order._2)))
ordersReformatted.sortyByKey().collect().foreach(println)
val products = Source.fromFile("/data/retail_db/products")
val productsIterable = products.getLines
val productsList = productsIterable.toList
val productsRDD = sc.Parellelize(productsList)
