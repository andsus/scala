import scala.collection.mutable

object Change {
  def findFewestCoins(money: Int, coins: List[Int]): Option[List[Int]] = {
    def makeChangeMemo(money: Int, denominations: List[Int], cache: mutable.Map[(Int, List[Int]), Option[List[Int]]]): Option[List[Int]] = {
      cache.getOrElseUpdate((money, denominations), {
        if (money == 0) Some(List.empty)
        else if (money < 0) None
        else
          denominations match {
            case Nil => None
            case x :: xs =>
              val candidates = List(
                makeChangeMemo(money - x, denominations, cache).map(x :: _), // use the largest coin
                makeChangeMemo(money, xs, cache), // do not use the largest coin
              ).filter(_.isDefined)

              if (candidates.isEmpty) None
              else Some(candidates.map(_.get).minBy(_.length))
          }
      })
    }

    makeChangeMemo(money, coins.sorted.reverse, mutable.Map.empty).map(_.reverse)
  }
}


//def countChange(money: Int, coins: List[Int]): Int = {
//  if (coins.isEmpty || money <0) 0
//  else if (money == 0) 1
//  else
//    countChange(money - coins.head, coins) + countChange(money,coins.tail)
//
//}