package org.nomadblacky.oretemplete

import org.scalatest.FunSuite
import net.jcazevedo.moultingyaml._
import DefaultYamlProtocol._

/**
  * Created by blacky on 17/05/01.
  */
class MoultingYAMLSuite extends FunSuite {

  test("Read YAML") {
    val source =
      """---
        |id: 1
        |name: foo
      """.stripMargin
    val yamlAst = source.parseYaml
    println(yamlAst.prettyPrint)
  }

  test("Write YAML") {
    val yamlAst = List(1, 2, 3).toYaml
    println(yamlAst.prettyPrint)
  }

  test("Case class") {
    case class Color(name: String, red: Int, green: Int, blue: Int)
    object MyYamlProtcol extends DefaultYamlProtocol {
      implicit val colorFormat = yamlFormat4(Color)
    }
    import MyYamlProtcol._
    import net.jcazevedo.moultingyaml._
    val yaml = Color("CadetBule", 95, 158, 160).toYaml
    println(yaml.prettyPrint)
    val color = yaml.convertTo[Color]
    println(color)
  }
}
