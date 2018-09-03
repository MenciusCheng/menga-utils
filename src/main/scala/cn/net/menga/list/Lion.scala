package cn.net.menga.list

/**
  * Created by Marvel on 18/09/03.
  */
class Lion {
  var id: Int = _
  var name: String = _

  override def toString = s"Lion($id, $name)"
}

object Lion {
  def apply(id: Int, name: String): Lion = {
    val l = new Lion()
    l.id = id
    l.name = name
    l
  }
}
