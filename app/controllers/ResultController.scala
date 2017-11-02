package controllers

import javax.inject.Inject

import play.api.mvc.{AbstractController, ControllerComponents}

class ResultController @Inject()(cc : ControllerComponents) extends AbstractController(cc) {

  def postResult = Action(parse.json) { request =>
    Ok("hello world")
  }

}
