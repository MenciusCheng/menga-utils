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
    testFromJsonScala()
  }

  def testToJsonScala(): Unit = {
    val request = new BrRequest()
    request.requestId = "00120180830113132766"
    request.admissionResult = "1"
    request.contractAmt = "500"
    request.reason = ""

    val requestJson = gson.toJson(request)
    System.out.println(requestJson)
  }

  def testFromJsonScala(): Unit = {
    val json = "{\"head\":{\"responseCode\":\"900\",\"responseMsg\":\"success\"}}"
    val response: BrResponse = gson.fromJson(json, classOf[BrResponse])
    System.out.println(response.head.responseCode)
  }

  def testToJsonOptional(): Unit = {
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
