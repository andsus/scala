import scala.language.dynamics

object SpaceAge extends Dynamic {

/*
  test("age on Earth") {
    SpaceAge.onEarth(1000000000) should be (31.69 +- 0.01)
  }
  Get the inspiration from https://exercism.io/tracks/scala/exercises/space-age/solutions/4d76d475f774450cbd4354e6af20a174
*/

  val AstroRation = Map(
    "onEarth" -> 1.0,
    "onMercury" -> 0.2408467,
    "onVenus" -> 0.61519726,
    "onMars" -> 1.8808158,
    "onJupiter" -> 11.862615,
    "onSaturn" -> 29.447498,
    "onUranus" -> 84.016846,
    "onNeptune" -> 164.79132)

  val secondsInEarthYear = 31557600
  val roundOfBy2 = (dec: Double) => "%.02f".format(dec).toDouble

  def applyDynamic(planet: String)(age: Double) : Double = {
    val period = AstroRation getOrElse (planet, 1.0) // add default for unknown planet
    roundOfBy2( age / (period * secondsInEarthYear) )

  }
}