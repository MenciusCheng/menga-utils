package cn.net.menga.math

import java.text.DecimalFormat

/**
  * 数字转英文
  *
  * Created by Marvel on 2019/6/28.
  */
object EnglishNumberToWords {
  private lazy val tensNames = Array("", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety")

  private lazy val numNames = Array("", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen")

  private def convertLessThanOneThousand(number: Int): String = {
    val hundreds = number / 100

    val soFar =
      if (number % 100 < 20) {
        numNames(number % 100)
      } else {
        tensNames(number / 10 % 10) + numNames(number % 10)
      }

    if (hundreds == 0) soFar else numNames(hundreds) + " hundred" + soFar
  }

  def convert(number: Long): String = {
    // 0 to 999 999 999 999
    if (number == 0) return "zero"

    // pad with "0"
    val mask = "000000000000"
    val df = new DecimalFormat(mask)
    val snumber = df.format(number)

    // XXXnnnnnnnnn
    val billions = snumber.substring(0, 3).toInt
    // nnnXXXnnnnnn
    val millions = snumber.substring(3, 6).toInt
    // nnnnnnXXXnnn
    val hundredThousands = snumber.substring(6, 9).toInt
    // nnnnnnnnnXXX
    val thousands = snumber.substring(9, 12).toInt

    val tradBillions =
      billions match {
        case 0 => ""
        case 1 => convertLessThanOneThousand(billions) + " billion "
        case _ => convertLessThanOneThousand(billions) + " billion "
      }

    val tradMillions =
      millions match {
        case 0 => ""
        case 1 => convertLessThanOneThousand(millions) + " million "
        case _ => convertLessThanOneThousand(millions) + " million "
      }

    val tradHundredThousands =
      hundredThousands match {
        case 0 => ""
        case 1 => "one thousand "
        case _ => convertLessThanOneThousand(hundredThousands) + " thousand "
      }

    val tradThousand = convertLessThanOneThousand(thousands)

    val result = tradBillions + tradMillions + tradHundredThousands + tradThousand
    // remove extra spaces!
    result.replaceAll("^\\s+", "").replaceAll("\\s+$", "").replaceAll("\\b\\s{2,}\\b", " ")
  }

  def convertToDollarAndCent(decimal: Double): String = {
    val dollars = decimal.toInt
    val cent = ((BigDecimal(decimal) - BigDecimal(dollars)) * BigDecimal(100)).toInt
    val s = "$ " + EnglishNumberToWords.convert(dollars) + " and " + EnglishNumberToWords.convert(cent) + " cents"
    s
  }

  def main(args: Array[String]): Unit = {
    System.out.println(convertToDollarAndCent(2.3))
  }
}
