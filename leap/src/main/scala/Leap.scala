object Leap {
  def leapYear(year: Int): Boolean = {

    val isDivBy: (Int) => Boolean = year % _ == 0
    (isDivBy(4) && !isDivBy(100)) || isDivBy(400)
    //isDivBy(4) && (!isDivBy(100) || isDivBy(400))
    
  }
}
