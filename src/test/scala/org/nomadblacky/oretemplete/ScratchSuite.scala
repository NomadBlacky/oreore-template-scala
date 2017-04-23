package org.nomadblacky.oretemplete

import org.scalatest.FunSuite

import scala.util.parsing.combinator.JavaTokenParsers

/**
  * Created by blacky on 17/04/19.
  */
class ScratchSuite extends FunSuite {
  object HogeParser extends JavaTokenParsers {
    def apply(source: CharSequence) = parseAll(code, source)
    def code = plainText ~ space ~ "$$" ~> """\w+""".r <~ "$$" ~ space ~ plainText
    def plainText = """\S+""".r
    def space = """\s*""".r
  }

  test("hoge") {
    val source = """aaa $$xxx$$ bbb"""
    val result = HogeParser(source)
    println(result.toString)
  }
}
