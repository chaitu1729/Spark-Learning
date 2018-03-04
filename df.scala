import apache.spark.sql.SparkSession

//get or create a spark session
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.csv("Citi2006to2008.csv")
df.head(5)
