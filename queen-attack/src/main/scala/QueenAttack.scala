case class Queen(row: Int, col: Int)

object Queen {

    def isValidChess(x: Int): Boolean = x >= 0 && x < 8

    def create (row: Int, col: Int): Option[Queen]= {
        if (!isValidChess(row) || !isValidChess(col)) {
            None
        } else {
            Some(new Queen(row,col))
        }
    }
 
}

object QueenAttack {
    def canAttack(queen1: Queen, queen2: Queen): Boolean = {
        queen1.row == queen2.row || // same row
        queen1.col == queen2.col || // same col
        (queen1.row - queen2.row).abs == (queen1.col - queen2.col).abs // on diagonal
    }
}