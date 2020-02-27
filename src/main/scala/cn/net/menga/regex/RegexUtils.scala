package cn.net.menga.regex

import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

/**
  * Created by Marvel on 2018/5/15.
  */
object RegexUtils {

  /**
    * 正则表达式：验证身份证
    */
  lazy val REGEX_ID_CARD = """^[1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$"""

  /**
    * 正则表达式：验证手机号码
    */
  lazy val REGEX_PHONE: String = """^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$"""

  def main(args: Array[String]): Unit = {
    testIndex()
  }

  def test1(): Unit = {
    //    System.out.println("44082319990721732x".matches(REGEX_ID_CARD))
    //    System.out.println("4408231999072173211".matches(REGEX_ID_CARD))
    //    System.out.println("15811112222".matches(REGEX_PHONE))
    //    System.out.println("158111122226".matches(REGEX_PHONE))

    val str = "亲爱的${name},您${name}的验证码为${code}"
    //    val reg: Regex = """(?<=\$\{)\w+(?=\})""".r
    //    val sl = reg.findAllMatchIn(str).toList.map(a => a.toString())
    //    sl.foreach(s => {
    //      System.out.println(s)
    //    })

    System.out.println(str.replace("${name}", "hahah").replace("${code}",  "wawa"))
  }

  /**
   * 根据正则分割字符串，不保留分隔符
   */
  def testSplit(): Unit = {
    val str = "Hello###12###My Name is###76###Wei"
    val p = """###\d+###""".r
    val matchStr = p.split(str)
    matchStr.foreach(it => System.out.println(it))
  }

  def testIndex(): Unit = {
    val str1 = "Hello###12###My Name is###76###Wei"
    val str2 = "Hello###12###My Name is###12###Hello######"
    val str3 = "###12###My Name is###76###Wei"
    val p: Regex = """###\d+###""".r


    val list1 = splitMatch(str1, p)
    val list2 = splitMatch(str2, p)
    val list3 = splitMatch(str3, p)

    System.out.println(list1)
    System.out.println(list2)
    System.out.println(list3)
  }

  /**
   * 根据正则分割字符串，并且保留分隔符
   */
  def splitMatch(str: String, pattern: Regex): List[String] = {
    val matches: List[Regex.Match] = pattern.findAllMatchIn(str).toList
    val list = new ArrayBuffer[String]()
    var start = 0
    for (i <- matches.indices) {
      val it = matches(i)
      if (start < it.start) {
        // 匹配前面的字符串
        list += str.substring(start, it.start)
      }
      // 匹配中的字符串
      list += str.substring(it.start, it.end)

      if (i == matches.length - 1) {
        if (it.end < str.length) {
          // 匹配后面的字符串
          list += str.substring(it.end, str.length)
        }
      } else {
        start = it.end
      }
    }
    list.toList
  }
}
