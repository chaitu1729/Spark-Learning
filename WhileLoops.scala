import util.control.Breaks._

var x = 0;

while(x<5)
{
println(s"$x is still less than 5 \n adding 1.")
x=x+1;
if(x==3) break
}
