package react.sizeme.demo

import scala.scalajs.js.annotation._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import react.sizeme._

object HomeComponent {

  val component =
    ScalaComponent
      .builder[Unit]("Home")
      .render { _ =>
        // <.div(
        SizeMe() { s =>
          println(s.width)
          <.div(
            s"Width: ${s.width}"
          )
        }
        // )
      }
      .build

  def apply() = component()
}
@JSExportTopLevel("Demo")
object Demo {

  @JSExport
  def main(): Unit = {
    // needed to load the styles
    val container = Option(dom.document.getElementById("root")).getOrElse {
      val elem = dom.document.createElement("div")
      elem.id = "root"
      dom.document.body.appendChild(elem)
      elem
    }

    HomeComponent().renderIntoDOM(container)

    ()
  }
}
