package cn.net.menga.math

import scala.math.BigDecimal.RoundingMode

/**
  * Created by Marvel on 18/08/27.
  */
object BigDecimalDemo {

  def main(args: Array[String]): Unit = {
    val a = BigDecimal(9321.5)

    val b = a.setScale(-2, RoundingMode.HALF_UP)

    System.out.print(b)
  }
}
