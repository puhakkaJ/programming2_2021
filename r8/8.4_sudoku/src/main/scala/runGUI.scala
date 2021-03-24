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

package sudoku

/**
 * A simple object to launch the graphical sudoku solver.
 * Observe how the graphical interface changes after
 * you have implemented the isConsistent method in Grid.
 * @author: Tommi Junttila
 * For the use in the CS-A1120 course only. Redistribution not allowed.
 */
object RunGUI {

  def main(args: Array[String]): Unit = {
    val small = Grid(List(
      "1 ? ? 3",
      "2 ? ? ?",
      "? ? ? 1",
      "? 1 ? ?"))
    val easy = Grid(List(
      "? ? ? ? ? 6 ? 8 ?",
      "? 4 3 9 ? ? 1 ? 7",
      "7 2 ? 1 5 ? 9 ? ?",
      "1 ? ? 2 ? ? 6 ? ?",
      "3 ? ? ? ? 4 ? ? ?",
      "? ? ? ? 6 8 ? ? 5",
      "? ? 5 ? ? ? ? 7 ?",
      "? ? ? ? 2 ? ? 6 1",
      "? ? 7 6 ? ? 2 ? ?"))
    val medium = Grid(List(
      "5 3 ? ? 7 ? ? ? ?",
      "6 ? ? 1 9 5 ? ? ?",
      "? 9 8 ? ? ? ? 6 ?",
      "8 ? ? ? 6 ? ? ? 3",
      "4 ? ? 8 ? 3 ? ? 1",
      "7 ? ? ? 2 ? ? ? 6",
      "? 6 ? ? ? ? 2 8 ?",
      "? ? ? 4 1 9 ? ? 5",
      "? ? ? ? 8 ? ? 7 9"))
    // From Gordon Royle's collection, see http://school.maths.uwa.edu.au/~gordon/sudokumin.php
    val hard = Grid(List(
      "? ? ? ? ? 4 ? ? 3",
      "? ? 6 ? 5 8 ? ? ?",
      "1 ? ? ? ? 2 7 ? ?",
      "? ? ? 9 ? ? ? 4 ?",
      "2 6 ? 3 ? ? ? ? ?",
      "7 ? ? ? ? ? ? 8 ?",
      "? ? ? ? ? ? ? ? ?",
      "? ? ? ? ? ? 2 ? ?",
      "? ? ? ? ? ? ? ? 1"))
    val instance = easy
    val gui = new GUI(instance)
    gui.go()
  }
}


