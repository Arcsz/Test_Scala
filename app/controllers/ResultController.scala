package controllers

import javax.inject.Inject

import model.Result
import play.api.cache.SyncCacheApi
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.duration.Duration

class ResultController @Inject()(cache: SyncCacheApi, cc: ControllerComponents) extends AbstractController(cc) {

  /**
    * Route for POST request with patient result
    * Handles one json object and also json array
    * @return
    */
  def postResult = Action(parse.json) { request =>
    // retrieve result database
    val database: Set[Result] = cache.getOrElseUpdate(Config.DATABASE_NAME, Duration.Inf)(Set())

    // deserialize results
    parseJsonResult(request.body) match {
      case Some(result) =>
        cache.set(Config.DATABASE_NAME, database ++ result, Duration.Inf)
        Ok(Json.obj("status" -> "Result successfully added to database"))

      // TODO detailed error msg
      case None =>
        BadRequest(Json.obj("status" -> "Error while deserializing json"))
    }
  }

  /**
    * parse results in an optionnal set
    * @param json request
    * @return
    */
  private def parseJsonResult(json: JsValue): Option[Set[Result]] = {
    json.asOpt[Result] match {
      case Some(result) => Some(Set(result))
      case None         => json.asOpt[Set[Result]]
    }
  }

}
