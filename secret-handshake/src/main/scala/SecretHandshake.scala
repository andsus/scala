import scala.::

object SecretHandshake {
  val codes = List("wink", "double blink", "close your eyes", "jump")
  //  def isBitSet(bit: Int)  = (number: Int) =>  ((number << bit) & 0x1) == 1
  // Closure
  def isBitSet(number: Int) = (bit: Int) => ((number & (1 << bit)) != 0)

  def commands(number: Int): List[String] = {
    val bitSet = isBitSet(number)

    val result = (codes.indices.collect {
      case idx if bitSet(idx) => codes(idx)
    }).toList

    if (bitSet(4)) result.reverse else result
  }
}