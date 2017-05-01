package org.nomadblacky.oretemplete

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.scalatest.FunSuite

/**
  * Created by blacky on 17/04/30.
  */
class JacksonYamlSuite extends FunSuite {

  case class Hoge(id: Int, name: String)

  test("jackson-yaml sample") {
    val mapper = new ObjectMapper(new YAMLFactory()) with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val yaml =
      """---
        |id: 1
        |name: "foo"
      """.stripMargin
    val hoge = mapper.readValue[Hoge](yaml)
    println(hoge)
  }

  test("hoge") {
    val hoge = Hoge(1, "foo")
    val mapper = new ObjectMapper(new YAMLFactory()) with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val yaml = mapper.writeValueAsString(hoge)
    println(yaml)
  }
}
