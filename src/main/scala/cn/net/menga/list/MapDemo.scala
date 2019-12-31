package cn.net.menga.list

/**
  * Created by Marvel on 2019/10/30.
  */
object MapDemo {

  def test1(): Unit = {
    val cat1 = new Cat(1, "A", 11)
    val cat2 = new Cat(2, "A", 11)
    val cat3 = new Cat(3, "C", 11)
    val cat4 = new Cat(4, "C", 11)
    val cats = List(cat1, cat2, cat3, cat4)

    val tupleToCats: Map[(String, Integer), List[Cat]] = cats.groupBy(it => (it.getName, it.getAge))

  }

  def main(args: Array[String]): Unit = {
    val cat1 = new Cat(1, "A", 11)
    val cat2 = new Cat(2, "B", 11)
    val cat3 = new Cat(3, "C", 12)
    val cats = List(cat1, cat2, cat3)

    val catsMapByAge: Map[Integer, List[Cat]] = cats.groupBy(_.getAge)
    System.out.println(catsMapByAge)

    val ageCountMap: Map[Integer, Int] = catsMapByAge.map {
      case (age, cat) => {
        age -> cat.length
      }
    }
    System.out.println(ageCountMap)

    val nameAgeMap = catsMapByAge.flatMap {
      case (age, cat) => {
        cat.map(it => it.getName -> it.getId)
      }
    }
    System.out.println(nameAgeMap)

  }
}
