# lazy 在scala中的使用

```scala
// 在定义时并不会发生计算，只有真正使用的时候才会发生计算
lazy val a:Int = 6
```

# 函数

- 函数最后一行的结果就是返回值，不需要return
- 只有一行的函数可以不用写大括号
- 没有参数的函数，调用时可以省略圆括号

> 默认参数

```bash
# 配置文件
$SPARK_HOME/conf/spark-defaults.conf.template

# 进入bin目录
spark-shell --help

--properties-file FILE 
# 加载额外参数的路径，如果没有指定将从 conf/spark-defaults.conf 加载
Path to a file from which to load extra properties. If not specified, this will look for conf/spark-defaults.conf.
```
> 命名参数

指定参数名称后调用函数，参数的顺序可以和定义时不一致

> 可变参数

在类型后面加一个星号，表示多个类型一样的参数

```scala
package scalastart
import org.apache.spark.{SparkConf, SparkContext}
object FunctionApp {
  def main(args: Array[String]): Unit = {
//    println(add(6, 6))
//    println(three(1, 2))
//    println(four)
      sayName("chendaye")
//      val conf = new SparkConf().setAppName("taobao").setMaster("local[2]")
//      val sc = new SparkContext(conf)

    // 可以打乱参数的时序
    val a = distanceTime(100, 10)
    val b:Float = distanceTime(time = 10, distance = 100)
    println(a)
    println(b)
    println(manyArg(1, 2, 3, 4, 5, 6, 7, 8, 9 ))
    
  }

  def add(x:Int, y:Int): Int ={
    x + y
  }

  def three(x:Int, y:Int) = x + y

  // 没有入参的函数可以直接写方法名调用,括号是可以省略
  def  four() = 2 + 2

  // 默认参数
  def sayName(name:String = "PK") = {
    println(name)
  }

  def loadConf(conf:String = "spark.default.conf") = {
     println(conf)
  }

  // 命名参数
  def distanceTime(distance:Float, time:Float):Float = {
    distance / time
  }

  // 可变参数：参数个数不定
  def manyArg(num: Int*) = {
    var sum  = 0
    for(elem <- num){
      sum += elem
    }
    sum
  }
  
}

```


# 条件表达式

# 循环

```scala
package scalastart

object CircleApp {
  def main(args: Array[String]): Unit = {
    1.to(10)
    Range(1, 12, 2)
    circleTest()
  }

  def circleTest(): Unit ={
    for(elem <- 1 to 12 if elem % 2 == 0){
      println(elem)
    }

    val bigdata = Array("scala", "hadoop", "Hive", "spark")

    for (e <- bigdata){
      println(e)
    }
    bigdata.foreach(tmp => println(tmp))

    var (num, sum) = (1, 100)
    while (num < 100){
      sum += num
      num += 1
    }
    println(sum)
  }
}

```


# 面向对象

- case class 不用实例化
- trait 用 extends A with B, C
- 封装
- 继承
- 多态
- 主构造器、附属构造器
- override 关键字进行属性方法重写
- 伴生类和伴生对象是相互的概念。对象或类名() 调用的是 object.apply()，类的实例()   调用的是 class.apply()。最佳实践是在 object.apply()中实例化class
- case class,不需实例化，可直接使用，多用于模式匹配
- 可变数组&不可变数组

