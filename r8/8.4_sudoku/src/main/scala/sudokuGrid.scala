/*
  * This program text file is part of the CS-A1120 Programming 2 course
  * materials at Aalto University in Spring 2021. The programming exercises
  * at CS-A1120 are individual and confidential assignments---this means
  * that as a student taking the course you are allowed to individually
  * and confidentially work with the material, to discuss and review the
  * material with course staff, as well as to submit the material for grading
  * on course infrastructure. All other use, including in particular
  * distribution of the material or exercise solutions, is forbidden and
  * constitutes a violation of the code of conduct at this course.
  *
  */

/*
 * @author: Tommi Junttila
 * For the use in the course CS-A1120 only. Redistribution not allowed.
 */

package sudoku
import scala.math.{ sqrt, round }
import scala.collection.immutable.Vector

/**
 * Sudoku grid data structure. Immutable.
 * To create grids from scratch, please use the factory methods in the companion object.
 * @parameter cells immutable two-dimensional array giving the contents of the grid.
 */
class Grid(private val cells: Seq[Seq[Int]]) {
  val n: Int = cells.length
  require(n >= 1, "The grid size must be positive")
  val subDim = round(sqrt(n)).toInt
  require(subDim * subDim == n, "The grid size must be a square of a positive integer")
  for (r <- 0 until n) {
    val row = cells(r)
    require(row.length == n, "Row " + r + " is not of length " + n)
    for (c <- 0 until n) {
      val v = row(c)
      require(v == Grid.unknown || (1 <= v && v <= n), "Illegal value " + v + " at row " + r + ", column " + c)
    }
  }

  /**
   * A human-readable string presentation of the grid.
   */
  override def toString = {
    val elementLength = n.toString.length
    val formatString = "%" + elementLength + "d"
    def formatEntry(e: Int, i: Int) =
      (if (e == Grid.unknown) "?" else formatString.format(e)) +
        (if (i >= n - 1) "" else if ((i % subDim) == subDim - 1) " | " else " ")
    def rowConcat(r: String, i: Int) = r + (if (i >= n - 1) "" else if ((i % subDim) == subDim - 1) "\n" + ("-" * r.length) + "\n" else "\n")
    val rows = for (r <- 0 until n) yield cells(r).zipWithIndex.foldLeft("")((s, ie) => s + formatEntry(ie._1, ie._2))
    rows.zipWithIndex.foldLeft("")((s, ri) => s + rowConcat(ri._1, ri._2))
  }

  /**
   * Equality comparison method.
   * For more on equality, see Chapter 30 of "Programming in Scala, 2nd edition"
   */
  override def equals(other: Any): Boolean = {
    other match {
      case that: Grid => n == that.n && (for (r <- 0 until n; c <- 0 until n) yield (r, c)).forall({ case (r, c) => this(r, c) == that(r, c) })
      case _ => false
    }
  }
  override def hashCode = toString.hashCode

  /**
   * A helper method: returns the grid in the "list of strings" form accepted by
   * the builder in the companion object.
   */
  def toStringList: IndexedSeq[String] = {
    for (r <- 0 until n) yield cells(r).map(e => if (e == Grid.unknown) "?" else e.toString).mkString(" ")
  }

  /**
   * Get the value in the grid position (r,c).
   * As "apply" has a special interpretation, we can write g(r,c) instead of g.apply(r,c).
   */
  def apply(r: Int, c: Int): Int = {
    require(0 <= r && r < n)
    require(0 <= c && c < n)
    cells(r)(c)
  }

  /**
   * Returns true iff the grid position (r,c) has a value.
   */
  def defined(r: Int, c: Int): Boolean = {
    require(0 <= r && r < n)
    require(0 <= c && c < n)
    cells(r)(c) != Grid.unknown
  }

  /**
   * Return a grid that is the same as this except that the grid position (r,c) has value v.
   */
  def updated(r: Int, c: Int, v: Int): Grid = {
    require(0 <= r && r < n)
    require(0 <= c && c < n)
    require(v == Grid.unknown || (1 <= v && v <= n))
    new Grid(cells.updated(r, cells(r).updated(c, v)))
  }

  /**
   * Check if the argument grid "that" is a solution of this grid.
   */
  def isSolution(that: Grid): Boolean = {
    require(this.n == that.n, "The grids must be of same size")
    require(that.isConsistent, "The solution grid is not consistent")
    for (r <- 0 until n; c <- 0 until n) {
      if (this(r, c) != Grid.unknown) { if (this(r, c) != that(r, c)) return false }
      else require(that(r, c) != Grid.unknown, "The solution grid is not fully specified")
    }
    true
  }

  /**
   * Check if the grid is consistent.
   * A grid is consistent if
   * - no row contains a number twice
   * - no column contains a number twice, and
   * - no sub-grid contains a number twice.
   */
  def isConsistent: Boolean = {
    for (i <- 0 until cells.size) {
      for (j <- 0 until cells(i).filter(_ > 0).size) {
        if (cells(i).filter(_ > 0).count(_ == cells(i)(j)) >= 2) return false
      }
    }

    var list = Array.fill(cells.size)(Array.fill[Int](cells.size)(0))

    for (i <- 0 until cells.size) {
      for (j <- 0 until cells.size) {
        list(i)(j) = cells(j)(i)
      }
      list(i) = list(i).filter(_ > 0)
      for (j <- 0 until list(i).size) {
        if (list(i).count(_ == list(i)(j)) >= 2) return false
      }
    }

    var list2 = Seq(Seq[Int]())

    for(i <- 0 until this.subDim) {
      for(j <- 0 until this.subDim) {
        var ruutu = Seq[Int]()
        for(r <- 0 until this.subDim){
          for(c <- 0 until this.subDim){
            ruutu = ruutu :+ cells(i * this.subDim + r)(j * this.subDim +c)
            ruutu = ruutu.filter(_ > 0)
          }
        }
        list2 = list2 :+ ruutu
        for (j <- 0 until ruutu.size) {
          if (ruutu.count(_ == ruutu(j)) >= 2) return false
        }
      }
    }
    true
  }
}


object Grid {
  /** Constant for storing the fact that a grid element has no value */
  val unknown = 0
  /**
   * Create a new n*n grid, where n must be a square of a positive integer.
   * All the cells are empty, i.e. have the value "unknown".
   */
  def apply(n: Int) = {
    require(n >= 1, "The grid size must be positive")
    val subDim = round(sqrt(n)).toInt
    require(subDim * subDim == n, "The grid size must be a square of a positive integer")
    val g = (1 to n).map(e => (1 to n).map(f => unknown).toIndexedSeq).toIndexedSeq
    new Grid(g)
  }

  /**
   * Create a new grid from the "sequence of strings" format,
   * e.g. the following describes a 2*2 grid:
   * val s = List(
   *          "1 ? ? 3",
   *          "2 ? ? ?",
   *          "? ? ? 1",
   *          "? 1 ? ?")
   */
  def apply(s: Seq[String]): Grid = {
    val n = s.length
    val cells = new Array[Array[Int]](n)
    (0 until n).foreach(r => cells(r) = new Array[Int](n))
    val regex = "\\S".r
    val numRegex = "(\\d+)".r
    for ((row, rowNum) <- s.zipWithIndex) {
      val entries = (regex findAllIn row).toIndexedSeq
      require(entries.length == n, "Illegal number of entries on line " + (rowNum + 1))
      for ((entry, columnNum) <- entries.zipWithIndex) {
        entry match {
          case "?" => cells(rowNum)(columnNum) = unknown
          case numRegex(e) => { cells(rowNum)(columnNum) = e.toInt }
          case _ => require(false, "Illegal entry '" + entry + "' on line " + (rowNum + 1))
        }
      }
    }
    new Grid(cells.map(r => r.toIndexedSeq).toIndexedSeq)
  }
}


