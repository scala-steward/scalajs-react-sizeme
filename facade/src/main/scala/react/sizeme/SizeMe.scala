package react

package sizeme

import scala.scalajs.js
import js.annotation.JSImport
import japgolly.scalajs.react.JsComponent
import japgolly.scalajs.react.Children
import japgolly.scalajs.react.vdom.html_<^._
import react.common._

final case class SizeMe(
  renderFn:               RenderF,
  monitorWidth:           js.UndefOr[Boolean],
  monitorHeight:          js.UndefOr[Boolean],
  monitorPosition:        js.UndefOr[Boolean],
  refreshRate:            js.UndefOr[Int],
  refreshMode:            js.UndefOr[RefreshMode],
  placeholder:            js.UndefOr[VdomNode],
  noPlaceholder:          js.UndefOr[Boolean],
  renderOnUndefined:      Boolean,
  override val modifiers: Seq[TagMod]
) extends GenericComponentPA[SizeMe.SizeMeProps, SizeMe] {
  override def cprops              = SizeMe.props(this)
  override protected val component = SizeMe.component
  override def addModifiers(modifiers: Seq[TagMod]) = copy(modifiers = this.modifiers ++ modifiers)
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
             q.noPlaceholder,
             q.renderOnUndefined)

  def rawprops(
    children:          RenderF,
    monitorWidth:      js.UndefOr[Boolean] = js.undefined,
    monitorHeight:     js.UndefOr[Boolean] = js.undefined,
    monitorPosition:   js.UndefOr[Boolean] = js.undefined,
    refreshRate:       js.UndefOr[Int] = js.undefined,
    refreshMode:       js.UndefOr[RefreshMode] = js.undefined,
    placeholder:       js.UndefOr[VdomNode] = js.undefined,
    noPlaceholder:     js.UndefOr[Boolean] = js.undefined,
    renderOnUndefined: Boolean
  ): SizeMeProps = {
    val p = (new js.Object).asInstanceOf[SizeMeProps]
    p.children = (s: SizeP) => {
      println(s)
      println("-----")
      println(s.size)
      if (renderOnUndefined || (!js.isUndefined(s) && !js.isUndefined(s.size.width)))
        children(s.size).rawNode
      else placeholder.rawNode
    }
    monitorWidth.foreach(v => p.monitorWidth       = v)
    monitorHeight.foreach(v => p.monitorHeight     = v)
    monitorPosition.foreach(v => p.monitorPosition = v)
    refreshRate.foreach(v => p.refreshRate         = v)
    refreshMode.toJs.foreach(v => p.refreshMode    = v)
    noPlaceholder.foreach(v => p.noPlaceholder     = v)
    p
  }

  val component = JsComponent[SizeMeProps, Children.None, Null](RawComponent)

  def apply(
    monitorWidth:      js.UndefOr[Boolean] = js.undefined,
    monitorHeight:     js.UndefOr[Boolean] = js.undefined,
    monitorPosition:   js.UndefOr[Boolean] = js.undefined,
    refreshRate:       js.UndefOr[Int] = js.undefined,
    refreshMode:       js.UndefOr[RefreshMode] = js.undefined,
    placeholder:       js.UndefOr[VdomNode] = js.undefined,
    noPlaceholder:     js.UndefOr[Boolean] = js.undefined,
    renderOnUndefined: Boolean = false,
    modifiers:         Seq[TagMod] = Seq.empty
  )(render:            RenderF): SizeMe =
    new SizeMe(render,
               monitorWidth,
               monitorHeight,
               monitorPosition,
               refreshRate,
               refreshMode,
               placeholder,
               noPlaceholder,
               renderOnUndefined,
               modifiers)
}
