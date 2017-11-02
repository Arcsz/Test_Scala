package model

case class ResultData(
  id: String,
  dateOfResult: Long,
  msgType: String,
  msgRaw: String
)

object ResultData {

  import play.api.libs.functional.syntax._
  import play.api.libs.json._

  implicit val resultReads: Reads[ResultData] = (
      (__ \ "idResult").read[String] and
      (__ \ "dateOfResult").read[Long] and
      (__ \ "msg_type").read[String] and
      (__ \ "msg_raw").read[String]
    ) (ResultData.apply _)
}
