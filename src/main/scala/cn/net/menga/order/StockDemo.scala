package cn.net.menga.order

/**
  * Created by Marvel on 2019/7/4.
  */
object StockDemo {

  def main(args: Array[String]): Unit = {
    val stockInfos = List(StockInfo(1, 0.5), StockInfo(1, 0.3), StockInfo(1, 0.2))
    val targetWeight = BigDecimal(0.9)
    splitStockInfo(targetWeight, stockInfos)
  }

  def splitStockInfo( targetWeight: BigDecimal,stockInfos: List[StockInfo]): Unit = {

    //List(1,2,3,4) => List(List(1,2,3,4),List(1,2,3),List(1,2,4),List(1,3,4),List(1,2),List(1,3).......)
    //取的所有组合情况
    val combinationResult: List[List[StockInfo]] = (1 to stockInfos.size).flatMap(index => stockInfos.combinations(index)).filter(x => x.map(_.weight).sum >= targetWeight).toList.sortBy(_.size)

    //找出全完美匹配的库存
    if(combinationResult.exists(_.map(_.weight).sum == targetWeight)){
      val result: List[StockInfo] = combinationResult.filter(_.map(_.weight).sum == targetWeight).head
      System.out.println("result=" + result)
    }else{
      //不存在完美匹配库存结构， 将最小库存组合进行拆分，并按重量升序
      val minByWeightList: List[StockInfo] = combinationResult.filter(_.map(_.weight).sum>targetWeight).minBy(_.map(_.weight).sum).sortBy(_.weight)

      // 取出最小的库存，用于拆分
      val splitStock = minByWeightList.head
      // 剩余待合并的库存
      val tailWeightList = minByWeightList.tail
      // 剩余待合并的库存的重量
      val currentWeight = tailWeightList.map(_.weight).sum
      // 需要从最小库存里面拆分的重量
      val splitWeight = targetWeight - currentWeight

      System.out.println(s"splitStock=$splitStock, tailWeightList=$tailWeightList, currentWeight=$currentWeight, splitWeight=$splitWeight")

//      val targetStockId = splitAndDeleteStockInfoByWeight(splitStock,splitWeight = targetWeight)
//      StockInfoSql.findById(targetStockId).get :: minByWeightList.filter(_.id != splitStock.id)
    }
  }
}
