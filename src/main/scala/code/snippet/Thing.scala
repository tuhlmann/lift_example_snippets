package code
package snippet

import net.liftweb.util.Helpers._
import net.liftweb.util.Helpers
import code.lib._
import net.liftweb.http.js.JsCmd
import net.liftweb.common.Full
import net.liftweb.http.{S, SessionVar, SHtml}
import net.liftweb.http.js.JsCmds.SetHtml
import xml.Text
import net.liftweb._
import http._
import common._
import util.Helpers._
import js._
import JsCmds._
import JE._
import scala.xml.NodeSeq

class Thing1 {

  var cnt = 0

  def value = "* *" #> cnt
  def button = "* [onclick]" #> SHtml.ajaxInvoke(() => {cnt += 1; SetHtml("count1", Text(cnt.toString))})

}

class Thing2 extends Logger {

  var cnt = 0

  def render = "*" #> SHtml.idMemoize {
    memo =>
    "span *" #> cnt & "button [onclick]" #> SHtml.ajaxInvoke(() => {cnt += 1; memo.setHtml()})
  }

}

object Thing3 {

  var cnt = 0

  def value = "* *" #> cnt
  def button = "* [onclick]" #> SHtml.ajaxInvoke(() => {cnt += 1; SetHtml("count3", Text(cnt.toString))})

}

object Thing4 {

  var cnt = 0

  def render = "*" #> SHtml.idMemoize {
    memo =>
    "span *" #> cnt & "button [onclick]" #> SHtml.ajaxInvoke(() => {cnt += 1; memo.setHtml()})
  }
}

object ShowMemoize {

  var cnt = 0

  def incrCnt = { cnt+=1; cnt }

  def render =
    "div" #> SHtml.idMemoize(
      memo =>
        // display a bunch of items
        "#count5" #> incrCnt &
        // update the "two" div on button press
        "button [onclick]" #> SHtml.ajaxInvoke(memo.setHtml _))
}

