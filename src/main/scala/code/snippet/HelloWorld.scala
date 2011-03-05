package code
package snippet

import _root_.scala.xml.{NodeSeq, Text}
import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import _root_.java.util.Date
import code.lib._
import Helpers._
import net.liftweb.http.js.JsCmds.SetHtml
import net.liftweb.http.SHtml

object HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date] // inject the date

  // replace the contents of the element with id "time" with the date
  def howdy = "#time *" #> date.map(_.toString)

  /*
   lazy val date: Date = DependencyFactory.time.vend // create the date via factory

   def howdy = "#time *" #> date.toString
   */

  var cnt = 0

  def value = {
    println("VALUE = "+cnt)
    "* *" #> cnt
  }

  def button = {
    println("BUTTON")
    "* [onsubmit]" #> SHtml.ajaxInvoke(() => {cnt += 1; SetHtml("count", Text(cnt.toString))})
  }

}
