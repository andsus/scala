object House {
  private val source = List(("that lay in",      "the house that Jack built.\n"),
    ("that ate",         "the malt"),
    ("that killed",      "the rat"),
    ("that worried",     "the cat"),
    ("that tossed",      "the dog"),
    ("that milked",      "the cow with the crumpled horn"),
    ("that kissed",      "the maiden all forlorn"),
    ("that married",     "the man all tattered and torn"),
    ("that woke",        "the priest all shaven and shorn"),
    ("that kept",        "the rooster that crowed in the morn"),
    ("that belonged to", "the farmer sowing his corn"),
    ("",                 "the horse and the hound and the horn"));

  val rhyme: String = {
    for (
      i <- (0 until source.length);
      j <- (i to 0 by -1);
      (adjective, subject) = source(j)
    ) yield {
      if (j == i) "This is "       + subject
      else        adjective  + " " + subject
    }
  }.mkString("", "\n", "\n")


  def recite(beginning: Int, end: Int) :String = {
    val nouns = List(
      "the house that Jack built",
      "the malt that lay in",
      "the rat that ate",
      "the cat that killed",
      "the dog that worried",
      "the cow with the crumpled horn that tossed",
      "the maiden all forlorn that milked",
      "the man all tattered and torn that kissed",
      "the priest all shaven and shorn that married",
      "the rooster that crowed in the morn that woke",
      "the farmer sowing his corn that kept",
      "the horse and the hound and the horn that belonged to"
    )
    (beginning to end).map { n =>
      val verse = nouns.take(n).foldLeft("") { (res, noun) => s"$noun $res" }
      s"This is ${verse.trim}."
    }.mkString("", "\n", "\n\n")
  }
}