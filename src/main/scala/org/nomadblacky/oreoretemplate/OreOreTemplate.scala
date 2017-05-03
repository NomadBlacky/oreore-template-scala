package org.nomadblacky.oreoretemplate
import xsbti.{ AppConfiguration, MainResult }

/**
 * Created by blacky on 17/05/02.
 */
class OreOreTemplate extends xsbti.AppMain {
  override def run(appConfiguration: AppConfiguration): MainResult = {
    val scalaVersion = appConfiguration.provider().scalaProvider().version()
    println(scalaVersion)
    new Exit(0)
  }
  class Exit(val code: Int) extends xsbti.Exit
}
