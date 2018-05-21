val products = sc.textFile("/public/retail_db/products")
val productsFilter = products.filter(product => product.split(",")(4)!="")
val productsMap = productsFilter.map(product => {
(product.split(",")(1).toInt,product)
})
val productsGroupBy = productsMap.groupByKey()

val topNPriceData = productsGroupBy.map(product => topNPrices(product._2,3))
val topNPriceDataFlattened = productsGroupBy.flatMap(product => topNPrices(product._2,3))
/*
val productsListForOneRecord =  productsGroupBy.first._2.toList

val priceExtract = productsListForOneRecord.map(order => order.split(",")(4).toFloat)

val priceExtractSet = priceExtract.toSet
val priceListSorted = priceExtractSet.toList.sortBy(o => -o)
val top5Prices = priceListSorted.take(5)
top5Prices.min()
productsListForOneRecord.sortBy(product => -product.split(",")(4).toFloat)
val a = productsGroupBy.map(order => order._2)*/

def topNPrices(items: Iterable[String],n: Int): Iterable[String] ={
val priceExtract =  items.map(o => o.split(",")(4).toFloat).toList // an Iterable of string canbe converted to List using toList
val priceExtractSet = priceExtract.toSet
val priceListSorted = priceExtractSet.toList.sortBy(o => -o)
val nPriceList = priceListSorted.take(n)
val minPrice = nPriceList.min
val itemSorted = items.toList.sortBy(o => -o.split(",")(4).toFloat) //in sortBy we can define the attribute to sortBy
val topnPrices = itemSorted.takeWhile(o => o.split(",")(4).toFloat >= minPrice)// takeWhile works just like filter but the exception being it only runs until the first time the condition returns false
return topnPrices
}
