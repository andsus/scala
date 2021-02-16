import Bearing.Bearing

object Bearing extends Enumeration {
  type Bearing = Value
  val North, East, West, South = Value

  val rightBearing = Map( North -> East,
                          East -> South,
                          South -> West,
                          West -> North)
  val leftBearing = rightBearing.map { case (k, v) => (v, k) } // flip bearing
}

case class Robot(var bearing: Bearing, var coordinates: (Int, Int)) {
  def turnRight(): Robot = Robot(Bearing.rightBearing(bearing), coordinates)

  def turnLeft(): Robot = Robot(Bearing.leftBearing(bearing), coordinates)

  def advance(): Robot = bearing match {
    case Bearing.North => Robot(bearing, (coordinates._1, coordinates._2 + 1))
    case Bearing.East => Robot(bearing, (coordinates._1 + 1, coordinates._2))
    case Bearing.South => Robot(bearing, (coordinates._1, coordinates._2 - 1))
    case Bearing.West => Robot(bearing, (coordinates._1 - 1, coordinates._2))
  }

  def simulate(str: String) = {
    str.foldLeft(this) {
      case (robot, c) => c match {
        case 'R' => robot.turnRight
        case 'L' => robot.turnLeft
        case 'A' => robot.advance
      }
    }
  }

}