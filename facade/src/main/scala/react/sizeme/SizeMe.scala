package react

package sizeme

import scala.scalajs.js
import js.annotation.JSImport
import japgolly.scalajs.react.JsComponent
import japgolly.scalajs.react.Children
import japgolly.scalajs.react.vdom.html_<^._
import react.common._

final case class SizeMe(
  renderFn:        RenderF,
  monitorWidth:    js.UndefOr[Boolean],
  monitorHeight:   js.UndefOr[Boolean],
  monitorPosition: js.UndefOr[Boolean],
  refreshRate:     js.UndefOr[Int],
  refreshMode:     js.UndefOr[RefreshMode],
  placeholder:     js.UndefOr[VdomNode],
  noPlaceholder:   js.UndefOr[Boolean]
) extends GenericComponentP[SizeMe.SizeMeProps] {
  override def cprops = SizeMe.props(this)
  @inline def render  = SizeMe.component(SizeMe.props(this))
}

object SizeMe {

  @js.native
  @JSImport("react-sizeme", "SizeMe")
  object RawComponent extends js.Object

  @js.native
  trait SizeMeProps extends js.Object {
    var children: RawRenderFn                = js.native
    var monitorWidth: js.UndefOr[Boolean]    = js.native
    var monitorHeight: js.UndefOr[Boolean]   = js.native
    var monitorPosition: js.UndefOr[Boolean] = js.native
    var refreshRate: js.UndefOr[Int]         = js.native
    var refreshMode: js.UndefOr[String]      = js.native
    var noPlaceholder: js.UndefOr[Boolean]   = js.native
  }

  def props(
    q: SizeMe
  ): SizeMeProps =
    rawprops(q.renderFn,
             q.monitorWidth,
             q.monitorHeight,
             q.monitorPosition,
             q.refreshRate,
             q.refreshMode,
             q.placeholder,
             q.noPlaceholder)

  def rawprops(
    children:        RenderF,
    monitorWidth:    js.UndefOr[Boolean] = js.undefined,
    monitorHeight:   js.UndefOr[Boolean] = js.undefined,
    monitorPosition: js.UndefOr[Boolean] = js.undefined,
    refreshRate:     js.UndefOr[Int] = js.undefined,
    refreshMode:     js.UndefOr[RefreshMode] = js.undefined,
    placeholder:     js.UndefOr[VdomNode] = js.undefined,
    noPlaceholder:   js.UndefOr[Boolean] = js.undefined
  ): SizeMeProps = {
    val p = (new js.Object).asInstanceOf[SizeMeProps]
    p.children = (s: SizeP) =>
      if (!js.isUndefined(s) && !js.isUndefined(s.size.width)) children(s.size).rawNode else placeholder.rawNode
    p.monitorWidth    = monitorWidth
    p.monitorHeight   = monitorHeight
    p.monitorPosition = monitorPosition
    p.refreshRate     = refreshRate
    p.refreshMode     = refreshMode.toJs
    p.noPlaceholder   = noPlaceholder
    p
  }

  val component = JsComponent[SizeMeProps, Children.None, Null](RawComponent)

  def apply(
    monitorWidth:    js.UndefOr[Boolean] = js.undefined,
    monitorHeight:   js.UndefOr[Boolean] = js.undefined,
    monitorPosition: js.UndefOr[Boolean] = js.undefined,
    refreshRate:     js.UndefOr[Int] = js.undefined,
    refreshMode:     js.UndefOr[RefreshMode] = js.undefined,
    placeholder:     js.UndefOr[VdomNode] = js.undefined,
    noPlaceholder:   js.UndefOr[Boolean] = js.undefined
  )(render:          RenderF): SizeMe =
    new SizeMe(render,
               monitorWidth,
               monitorHeight,
               monitorPosition,
               refreshRate,
               refreshMode,
               placeholder,
               noPlaceholder)
}
