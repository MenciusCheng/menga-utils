package cn.net.menga.string

import org.junit.Test

/**
  * Created by Marvel on 18/10/30.
  */
class StringTests {

  @Test
  def test1(): Unit = {
    val s = "01345"

    System.out.println(s.substring(0, 2))
    System.out.println(s.substring(0, 4))
    System.out.println(s.substring(0, 6))
  }
}
