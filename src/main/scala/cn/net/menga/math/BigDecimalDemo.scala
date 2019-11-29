package cn.net.menga.math

import scala.math.BigDecimal.RoundingMode

/**
  * Created by Marvel on 18/08/27.
  */
object BigDecimalDemo {

  def test1(): Unit = {
    val a = BigDecimal(9321.5)

    val b = a.setScale(-2, RoundingMode.HALF_UP)

    System.out.print(b)
  }

  def test2(): Unit = {
    val a = BigDecimal(6.33)
    val b = BigDecimal(0.3)
    val c = a % b
    val (c1, c2) = a /% b
    System.out.println(c)
    System.out.println(c1)
    System.out.println(c2)
  }

  def main(args: Array[String]): Unit = {
    test2()
  }
}
