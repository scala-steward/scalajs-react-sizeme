package react

import scala.scalajs.js
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode
import react.common._

package object sizeme {
  type RawRenderFn = js.Function1[SizeP, React.Node]
  type RenderF     = js.Function1[Size, VdomNode]
}

package sizeme {
  sealed trait RefreshMode extends Product with Serializable

  object RefreshMode {
    implicit val enumValue: EnumValue[RefreshMode] = EnumValue.toLowerCaseString

    case object Throttle extends RefreshMode
    case object Debounce extends RefreshMode
  }

  @js.native
  trait SizeP extends js.Object {
    var size: Size
  }

  object SizeP {
    def apply(size: Size): SizeP = {
      val p = (new js.Object).asInstanceOf[SizeP]
      p.size = size
      p
    }
  }

}
