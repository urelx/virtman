package controllers

import play.api._
import play.api.mvc._
import models.VM
import views.html.defaultpages.badRequest
import models.VMState

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index(VM.list()))
  }
  
  def changeVMState(vmID: Int) = Action(parse.json) { implicit request =>
    Logger.debug("PUT /vm/%d" format vmID)
    (request.body \ "state").asOpt[String] match {
      case None => BadRequest("state param required.")
      case Some("stopped") => { VM.shutdown(vmID); Ok }
      case Some("running") => { VM.startup(vmID); Ok }
      case Some(other) => 
        BadRequest("illegal state value. [%s]" format other)
    }
  }
  
  def javascriptRoutes = Action { implicit request =>
    Ok(Routes.javascriptRouter("jsRouter", Some("jQuery.ajax"))(
      routes.javascript.Application.changeVMState)).as("text/javascript")
  }
  
}
