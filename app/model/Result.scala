package model

case class Result(
  msgType: String,
  correspondent: Correspondent,
  patient: Patient,
  result: ResultData
)

object Result {

  import play.api.libs.functional.syntax._
  import play.api.libs.json._

  implicit val resultReads: Reads[Result] = (
      (__ \ "msg_type").read[String] and
      (__ \ "correspondent").read[Correspondent] and
      (__ \ "patient").read[Patient] and
      (__ \ "result").read[ResultData]
    ) (Result.apply _)

  implicit val resultWrites: Writes[Result] = (
      (__ \ "msg_type").write[String] and
      (__ \ "correspondent").write[Correspondent] and
      (__ \ "patient").write[Patient] and
      (__ \ "result").write[ResultData]
    ) (unlift(Result.unapply))
}
