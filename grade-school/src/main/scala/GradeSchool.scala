import scala.collection.immutable.TreeMap
class School {
  type DB = Map[Int, Seq[String]]
  
  private var _db: DB = TreeMap()

  def add(name: String, g: Int) = { _db = _db.updated(g, grade(g) :+ name ) }

  def db: DB = _db

  def grade(g: Int): Seq[String] = db.getOrElse(g, Seq())

  
  def sorted: DB = _db.transform( (k,v) => v.sorted)
}

