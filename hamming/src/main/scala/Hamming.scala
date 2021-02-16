object Hamming {
    def distance(leftStrand: String, rightStrand: String): Option[Int] =  {
        if (leftStrand.size == rightStrand.size) { 
            Some(leftStrand.zip(rightStrand).count { strand => strand._1 != strand._2 })
        } else {
            None
        }
    }

}
