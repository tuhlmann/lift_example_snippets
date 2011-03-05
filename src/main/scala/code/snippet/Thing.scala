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

class Thing1 {

  var cnt = 0

  def value = "* *" #> cnt
  def button = "* [onsubmit]" #> SHtml.ajaxInvoke(() => {cnt += 1; SetHtml("count", Text(cnt.toString))})

}

class Thing2 {

  var cnt = 0

  def render = "*" #> SHtml.idMemoize {
    memo =>
    "span *" #> cnt & "button [onsubmit]" #> SHtml.ajaxInvoke(() => {cnt += 1; memo.setHtml()})
  }

}
