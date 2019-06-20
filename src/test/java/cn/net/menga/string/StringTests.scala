package cn.net.menga.string

import java.util.concurrent.ConcurrentHashMap

import org.junit.Test

import scala.collection.immutable.Queue

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

  @Test
  def test2(): Unit = {
    val a = 1235
    val b: Double = 0

    System.out.println(a.formatted("%05d"))
    System.out.println(b.formatted("%.2f"))
    System.out.println(Queue(Range(1, 20): _*))
  }

  @Test
  def test3(): Unit = {
    val cacheMap: ConcurrentHashMap[String, Int] = new ConcurrentHashMap[String, Int]()

    cacheMap.put("a", 3)
    cacheMap.put("a", 4)

    System.out.println(cacheMap.containsKey("a"))
  }

  @Test
  def test4(): Unit = {
    val a: Double = 1.20
    System.out.println(a)
  }

  @Test
  def test5(): Unit = {
    val s = "a. xxx"
    val s1 = s.replaceAll("\\.", "\\\\.")
    System.out.println(s)
    System.out.println(s1)
  }
}
