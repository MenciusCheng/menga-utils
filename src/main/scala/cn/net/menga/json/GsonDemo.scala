package cn.net.menga.json

import java.util
import java.util.Optional

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.menga.utils.PrintUtils._

import scala.collection.JavaConversions._

/**
  * Created by Marvel on 2018/2/8.
  */
object GsonDemo {

  lazy val gson = new Gson()

  def main(args: Array[String]): Unit = {

//    val giant = new Giant(
//      1,
//      "mai",
//      30.5,
//      1527126580876L,
//      List(
//        new GiantItem(1, "apple", 12.3, 1527126580876L),
//        new GiantItem(2, "banana", 8.5, 1527126580876L)
//      )
//    )
//    val giant = new Giant(
//      Optional.of(1),
//      Optional.of("mai"),
//      Optional.of(30.5),
//      Optional.of(1527126580876L),
//      List(
//        new GiantItem(Optional.of(1), Optional.of("apple"), Optional.of(12.3), Optional.of(1527126580876L)),
//        new GiantItem(Optional.of(2), Optional.of("banana"), Optional.of(8.5), Optional.of(1527126580876L))
//      )
//    )
    val giant = new Giant(
      Optional.of(1),
      Optional.of("mai")
    )
    val jsonString = gson.toJson(giant)
    System.out.println(jsonString)
    System.out.println("=======================================")

    val jsonGian: Giant = gson.fromJson(jsonString, classOf[Giant])
    System.out.println(jsonGian)
  }

  def fromMapJson(): Unit = {
    val typeToken = new TypeToken[java.util.Map[String, String]](){}.getType
    val m2: java.util.Map[String, String] = gson.fromJson("{\"a\":\"b\",\"b\":1}", typeToken)
    p(m2.toString, m2("b"))
  }

}
