package cn.net.menga.utils

/**
  * Created by Marvel on 18/09/28.
  */
object ReflectDemo {

  def main(args: Array[String]): Unit = {
    val r = new Rabbit()
    r.setId(1)
    r.setName("sss")
    System.out.println(r)
    setNullStringToBlank(r)
    System.out.println(r)
  }

  /**
    * 把类型为 java.lang.String 且值为 null 的属性值改为空字符串
    */
  def setNullStringToBlank[T](source: T): T = {
    val fields = source.getClass.getDeclaredFields
    fields.foreach(field => {
      if (field.getGenericType.getTypeName.equals("java.lang.String")) {
        val isAccessible = field.isAccessible
        field.setAccessible(true)
        val obj = field.get(source)
        if (obj == null) {
          field.set(source, "")
        }
        field.setAccessible(isAccessible)
      }
    })
    source
  }
}
