package cn.net.menga.json

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
    val typeToken = new TypeToken[java.util.Map[String, String]](){}.getType
    val m2: java.util.Map[String, String] = gson.fromJson("{\"a\":\"b\",\"b\":1}", typeToken)
    p(m2.toString, m2("b"))
  }

}
