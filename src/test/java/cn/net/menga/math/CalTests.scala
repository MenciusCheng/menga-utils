package cn.net.menga.math

import org.junit.Test

/**
  * Created by Marvel on 2019/6/12.
  */
class CalTests {

  /**
    * 测试精度问题
    */
  @Test
  def test1(): Unit = {
    val a: Double = 0.05
    val b: Double = 0.01

    System.out.println(a + b)
    System.out.println(BigDecimal(a) + BigDecimal(b))
  }

}
