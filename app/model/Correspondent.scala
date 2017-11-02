package model

case class Correspondent(
  id: String,
  profil: String,
  firstName: String,
  lastName: String,
  mobile: String
)

object Correspondent {

  import play.api.libs.functional.syntax._
  import play.api.libs.json._

  implicit val correspondentReads: Reads[Correspondent] = (
      (__ \ "idCorrespondent").read[String] and
      (__ \ "profil").read[String] and
      (__ \ "firstName").read[String] and
      (__ \ "lastName").read[String] and
      (__ \ "mobile").read[String]
    ) (Correspondent.apply _)
}
