package controllers

import javax.inject.Inject

import model.Result
import play.api.mvc.{AbstractController, ControllerComponents}

class ResultController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def postResult = Action(parse.json) { request =>
    println(request.body)
    val result = request.body.as[Result]
    println(result)
    Ok("hello world")
  }

}
