package model

import org.joda.time.DateTime

case class Patient(
  idPatient: String,
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
}
