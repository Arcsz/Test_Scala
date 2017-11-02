package model

import org.joda.time.DateTime

case class Patient(
  id: String,
  firstName: String,
  lastName: String,
  birthdayDate: DateTime
)

object Patient {

  import play.api.libs.functional.syntax._
  import play.api.libs.json._

  implicit val patientReads: Reads[Patient] = (
      (__ \ "idPatient").read[String] and
      (__ \ "firstName").read[String] and
      (__ \ "lastName").read[String] and
      (__ \ "birthdayDate").read[DateTime](JodaReads.jodaDateReads("dd-MM-yyyy"))
    ) (Patient.apply _)

  implicit val patientWrites: Writes[Patient] = (
      (__ \ "idPatient").write[String] and
      (__ \ "firstName").write[String] and
      (__ \ "lastName").write[String] and
      (__ \ "birthdayDate").write[DateTime](JodaWrites.jodaDateWrites("dd-MM-yyyy"))
  ) (unlift(Patient.unapply))
}
