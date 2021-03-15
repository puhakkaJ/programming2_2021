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

package object withProb {

  /**
   * NOTE: The seed should be System.nanoTime or something similar
   * in order to get real pseudo-randomness but we fix it now
   * for the sake of repeatability.
   */
  val rand = new scala.util.Random(2105)

  /**
   * Executes the given code with probability "prob".
   * For instance,
   *   doWithProb(30.0) { Console.println("I'm feeling lucky!") }
   * shall print the text to the console with probability of 30 percent.
   *
   * Note that you have to modify the type of the "thenAction" parameter so that it admits code
   * to be passed in "call-by-name" evaluation mode.
   * Please see the course material and
   * http://docs.scala-lang.org/tour/automatic-closures.html
   */
  def doWithProb(prob: Double)(thenAction: => Unit): Unit = {
    require(0.0 <= prob && prob <= 100.0)
    var i = rand.nextDouble() * 100
    if ( i >= 0 & i <= prob) thenAction
  }

  /**
   * The expression
   *   withProb(prob) {choice1} otherwise {choice2}
   * returns the value of the first choice code with probability prob and
   * the value of the second choice with probability 1-prob.
   *
   * For instance,
   *  val x = 2
   *  val y = 3
   *  val z: Int = withProb(30.0) {x*y} otherwise {0}
   * shall return 6 with 30% probability and 0 with 70% probability.
   *
   * Observe that we can also write a statement like
   *  withProb(70.0) { println("first action") } otherwise { println("second action") }
   * The return value is just ignored.
   *
   * Note that you have to modify the types of the choice1 and choice2 parameters so that they admit code
   * with correct return type to be passed in "call-by-name" evaluation mode.
   * Again, please see the course material and especially
   * http://docs.scala-lang.org/tour/automatic-closures.html
   * for help.
   */
  def withProb[T](prob: Double)(choice1: => T): withProbElse[T] = {
    require(0.0 <= prob && prob <= 100.0)
    new withProbElse[T](prob, choice1)
  }
  protected class withProbElse[T](prob: Double, choice1: => T) {
    var i = rand.nextDouble() * 100

    def otherwise(choice2: =>  T): T = {
      if ( i >= 0 & i <= prob) {
      choice1
    }
      else choice2
    }
  }
}


