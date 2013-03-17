package controllers

import play.api._
import play.api.mvc._
import models.VM

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index(VM.list()))
  }
  
}