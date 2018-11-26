package cn.net.menga.http

import java.io.File

import org.junit.jupiter.api._

/**
  * Created by Marvel on 18/10/29.
  */
class FtpTests {

  var ftpClient: FtpClient = _

  @BeforeEach
  def openFtp(): Unit = {
    ftpClient = new FtpClient("uftps.ximucredit.com", 21, "www.isuwang.com", "KRPPnFK1")
    ftpClient.open()
    System.out.println("登录FTP成功")
  }

  @AfterEach
  def closeFtp(): Unit = {
    ftpClient.close()
  }

  @Test
  def test1(): Unit = {
    val r = ftpClient.uploadFile("/fsp20/ln/20181029/", "longmu.gif", new File(ClassLoader.getSystemResource("images/longmu.gif").getFile))
    System.out.println(r)
  }

  @Test
  def test2(): Unit = {
    ftpClient.mkDirs("/fsp20/ln/2018")
  }

}