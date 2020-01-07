package cn.net.menga.json

import java.util.Optional

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.serializer.SerializerFeature

/**
  * Created by Marvel on 2020/1/7.
  */
object FastjsonDemo {

  def main(args: Array[String]): Unit = {
    testToJsonOptional()
  }

  def testToJsonOptional(): Unit = {
    val giant = new Giant(
      Optional.of(1),
      Optional.of("mai"),
      Optional.empty()
    )
    val jsonString = JSON.toJSONString(giant, SerializerFeature.QuoteFieldNames)
    System.out.println(jsonString)
    System.out.println("=======================================")

    val jsonGian: Giant = JSON.parseObject(jsonString, classOf[Giant])
    System.out.println(jsonGian)
  }
}
