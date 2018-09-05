package cn.net.menga.list

/**
  * Created by Marvel on 18/09/05.
  */
object ForDemo {

  def main(args: Array[String]): Unit = {
    val l = List(1, 2, 5, 8)

    val s = for (i <- l.indices) yield {
      l(i) * 10
    }

    System.out.println(s.toList)
  }
}
