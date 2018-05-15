package cn.net.menga.regex

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
  lazy val REGEX_PHONE = """^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$"""

  def main(args: Array[String]): Unit = {
    System.out.println("44082319990721732x".matches(REGEX_ID_CARD))
    System.out.println("4408231999072173211".matches(REGEX_ID_CARD))
    System.out.println("15811112222".matches(REGEX_PHONE))
    System.out.println("158111122226".matches(REGEX_PHONE))
  }
}
