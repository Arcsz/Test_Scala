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

  implicit val correspondentWrites: Writes[Correspondent] = (
      (__ \ "idCorrespondent").write[String] and
      (__ \ "profile").write[String] and
      (__ \ "firstName").write[String] and
      (__ \ "lastName").write[String] and
      (__ \ "mobile").write[String]
    ) (unlift(Correspondent.unapply))
}
