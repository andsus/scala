object Etl {
    def transform( input: Map[Int, Seq[String]]) : Map[String, Int] = {
        for (  (score, letters) <- input;
               out <- letters map { v => (v.toLowerCase, score) }
        ) yield out
    }
}