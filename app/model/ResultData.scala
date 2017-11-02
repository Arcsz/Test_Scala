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

  implicit val resultDataReads: Reads[ResultData] = (
      (__ \ "idResult").read[String] and
      (__ \ "dateOfResult").read[Long] and
      (__ \ "msg_type").read[String] and
      (__ \ "msg_raw").read[String]
    ) (ResultData.apply _)

  implicit val resultDataWrites: Writes[ResultData] = (
      (__ \ "idResult").write[String] and
      (__ \ "dateOfResult").write[Long] and
      (__ \ "msg_type").write[String] and
      (__ \ "msg_raw").write[String]
    ) (unlift(ResultData.unapply))
}
