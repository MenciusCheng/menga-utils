package cn.net.menga.http

import java.net.{HttpURLConnection, URL}

object HttpUtils {
  def download(src:String): Array[Byte] = {
    val url = new URL(src)
    val in = url.openStream()
    Stream.continually(in.read).takeWhile(-1 !=).map(_.toByte).toArray
  }

  def download2(src:String): Array[Byte] = {
    val url = new URL(src)
    val htpcon = url.openConnection().asInstanceOf[HttpURLConnection]
    htpcon.setRequestMethod("GET")
    htpcon.setDoOutput(true)
    htpcon.setDoInput(true)
    htpcon.setUseCaches(false)
    htpcon.setConnectTimeout(3000)
    htpcon.setReadTimeout(3000)
    val in = htpcon.getInputStream
    Stream.continually(in.read).takeWhile(-1 !=).map(_.toByte).toArray
  }

  def main(args: Array[String]): Unit = {
    val src = "http://118.190.142.194/res/user/529ae527f94e46469de807c12008a77b/seals/png/bb85d040-85e1-4e07-879a-d74c087018aa.png"
    System.out.println(" Begin to download png... src=" + src)
    val file = download2(src)
    System.out.println(file.length)
    System.out.println(" End...")

  }
}
