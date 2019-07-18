package cn.net.menga.scalafood.recursion

/**
  * 尾递归
  *
  * Created by Marvel on 2019/7/11.
  */
object TailRecursionDemo {

  /**
    * 常规递归并无优化
    */
  def factorial(number: Int): BigInt = {
    if (number == 0)
      1
    else
      number * factorial(number - 1)
  }

  /**
    * 尾递归，把计算结果放到参数里，Scala 会对尾递归进行优化
    * 加入 tailrec 注解，可以在编译时检查该函数是否为尾递归
    */
  @scala.annotation.tailrec
  def factorial(fact: BigInt, number: Int): BigInt = {
    if (number == 0)
      fact
    else
      factorial(fact * number, number - 1)
  }

  def main(args: Array[String]): Unit = {
    // 栈溢出
//    println(factorial(10000))
    // 尾递归优化，不会栈溢出
    println(factorial(1, 10000))
  }
}
