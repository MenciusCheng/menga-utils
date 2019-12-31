package cn.net.menga.list

import scala.collection.immutable

/**
  * Created by Marvel on 2018/7/16.
  */
object ListDemo {

  def main(args: Array[String]): Unit = {
    testCaseClassEqual()
  }

  def testCaseClassEqual(): Unit = {
    val d1 = Dog(id = 1, age = 2)
    val d2 = Dog(id = 1, age = 2)
    System.out.println(d1 == d2)
  }

  def testCombinations(): Unit = {
    val list = List(1, 3, 6, 9)
    System.out.println(list.combinations(2).toList)

    val n = (1 to list.size).flatMap(it => list.combinations(it)).toList
    System.out.println(n)
  }

  def testInit(): Unit = {
    val list = List(1, 3, 6, 9)
    System.out.println(list)
    System.out.println(list.init)
    System.out.println(list.last)
  }

  def testGroupBy(): Unit = {
    val list = List(Lion(1,"apple"), Lion(2,"banana"))
    val map = list.groupBy(_.id)

    System.out.println(map)
    System.out.println(map.contains(4))
  }

  def testFlatMap(): Unit = {
    val list = List(List(1,2,3), List(5,6,7))
    val list2 = list.flatMap(l => {
      l.map(_ * 2)
    })
    System.out.println(list2)
  }

  def testSortWith(): Unit = {
    val list = List(3, 6, 2, 7)
    val list2 = list.sortWith(_ < _)
    System.out.println(list2)
  }

  def testToMap(): Unit = {
    val listMap = List((1, "333"), (3, "555"), (6, "677"), (6, "699"))
    val map = listMap.toMap
    System.out.println(map)
  }

  def testToSet(): Unit = {
    val list = List(1, 1, 2, 2)
    val set = list.toSet
    System.out.println(set)
  }

  def testFilter(): Unit = {
    val list = Set(1, 3, 6, 9)
    System.out.println(list)
    val f = list.filter(isGreaterThan3).toList
    System.out.println(f)
  }

  def isGreaterThan3(n: Int): Boolean = {
    n > 3
  }
}
