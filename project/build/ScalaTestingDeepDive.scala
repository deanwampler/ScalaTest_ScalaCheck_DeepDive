import sbt._

class ScalaTestingDeepDiveProject(info: ProjectInfo) extends DefaultProject(info)
{
  val scalaToolsSnapshots = "Scala-Tools Maven2 Snapshots Repository" at "http://scala-tools.org/repo-snapshots"

  val scalatest  = "org.scalatest" % "scalatest" % "1.0"
  val scalacheck = "org.scala-tools.testing" % "scalacheck_2.7.7" % "1.6" withSources()
  
  lazy val about = task { 
    println("CASE Meeting 12/17/2009: Scala Testing Deep Dive")
    None 
  }
}