package ObjectOriented

object AbstractClass {
  def main(args: Array[String]): Unit = {
    val girls = new beautifulGirl
    girls.speak
  }
}

/**
 * 抽象类
 * */

abstract class Girls{
  def speak  // 抽象方法
}

class beautifulGirl extends Girls {
  override def speak: Unit = {
    println(" Girls are beautiful")
  }
}
