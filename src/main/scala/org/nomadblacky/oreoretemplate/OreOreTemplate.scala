package org.nomadblacky.oreoretemplate

import xsbti.{ AppConfiguration, MainResult }
import scala.reflect.io.File

/**
 * Created by blacky on 17/05/02.
 */
case class Config(variablesFile: File = File("variables"), templateDirectory: File = File("templates"))

class Exit(val code: Int) extends xsbti.Exit

class OreOreTemplate extends xsbti.AppMain {
  override def run(appConfiguration: AppConfiguration): MainResult = new Exit(run(appConfiguration.arguments()))

  def run(args: Array[String]): Int = {
    args.partition { s ⇒
      s.matches("""""")
    }
    println("hoge")
    0
  }

}

object OreOreTemplate {
  val parser = new scopt.OptionParser[Config]("oreoretemplate") {
    head("oretmpl", "0.1.0")
  }
}