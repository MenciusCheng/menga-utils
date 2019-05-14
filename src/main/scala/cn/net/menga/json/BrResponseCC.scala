package cn.net.menga.json

/**
  * Created by Marvel on 18/09/04.
  */
case class BrResponseCC
(
  head: BrResponseHeadCC
)

case class BrResponseHeadCC
(
  responseCode: String,
  responseMsg: String
)

