object Bob {

  implicit def stringToUtterance(input: String) = new Utterance(input) 

  class Utterance(utter: String) {
    def shouting = utter.toUpperCase == utter && utter.exists( _.isUpper)
    def questioning = utter.trim endsWith "?"
    def silence = utter.trim isEmpty
  }


  def response(input: String) : String = input match {
    case i if i.shouting && i.questioning  => "Calm down, I know what I'm doing!"
    case i if i.shouting  => "Whoa, chill out!"
    case i if i.questioning => "Sure."
    case i if i.silence => "Fine. Be that way!"
    case _ => "Whatever."
  
  }


}
