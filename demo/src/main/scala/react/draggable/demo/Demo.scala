package react.sizeme.demo

import scala.scalajs.js.annotation._
import japgolly.scalajs.react.ReactFragment
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import react.sizeme._

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

    println("demo")
    <.div(^.width := 100.pct, ^.height := 100.pct, SizeMe() { s =>
      ReactFragment(<.div("Width:"), s"${s.width}")
    }).renderIntoDOM(container)

    ()
  }
}
