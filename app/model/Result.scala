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

  implicit val messageReads: Reads[Result] = (
      (__ \ "msg_type").read[String] and
      (__ \ "correspondent").read[Correspondent] and
      (__ \ "patient").read[Patient] and
      (__ \ "result").read[ResultData]
    ) (Result.apply _)
}
