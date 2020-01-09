package react

package sizeme

import japgolly.scalajs.react.test._
import japgolly.scalajs.react.vdom.html_<^._
import utest._

object SizeMeTests extends TestSuite {

  val tests = Tests {
    test("render") - {
      val sizeme = SizeMe()(s => <.div(s"${s.width}"))
      ReactTestUtils.withNewBodyElement { mountNode =>
        sizeme.renderIntoDOM(mountNode)
        assert(mountNode.innerHTML == """<div style="width: 100%; height: 100%;"></div>""")
      }
    }
  }
}
