package react

import scala.scalajs.js
import japgolly.scalajs.react.CtorType
import japgolly.scalajs.react.raw.React
import japgolly.scalajs.react.vdom.VdomNode
import react.common.EnumValue
import react.common.Render
import react.common.Size

package object sizeme {
  type RawRenderFn                       = js.Function1[SizeP, React.Node]
  type RenderFn                          = js.Function1[Size, VdomNode]
  type GenericComponentP[P <: js.Object] = GenericComponent[P, CtorType.Props, Unit]

  implicit def gP2VdomNode[P <: js.Object](
    p: GenericComponentP[P]
  ): VdomNode =
    p.render
  implicit def gProps2Render[P <: js.Object](
    p: GenericComponentP[P]
  ): Render[P] =
    p.render

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

  trait GenericComponent[P <: js.Object, CT[-p, +u] <: CtorType[p, u], U] {
    def cprops: P
    @inline def render: Render[P]
  }

}
