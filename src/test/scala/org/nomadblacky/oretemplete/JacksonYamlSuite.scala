package org.nomadblacky.oretemplete

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.scalatest.FunSuite

/**
  * Created by blacky on 17/04/30.
  */
class JacksonYamlSuite extends FunSuite {

  case class Hoge(id: Int, name: String)

  test("jackson-yaml sample") {
    val mapper = new ObjectMapper(new YAMLFactory())
    mapper.registerModule(DefaultScalaModule)
    val yaml =
      """- id: 1
        |  name: hoge
      """.stripMargin
    val myCaseClass = mapper.readValue(yaml, Hoge.getClass)
    println(myCaseClass)
  }
}
