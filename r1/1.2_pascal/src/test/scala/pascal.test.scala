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

package pascal

import org.junit.Test
import org.junit.Assert._

/**
 * Some simple unit tests for Pascal's triangle.
 */
class UnitTests {
  @Test def test1() {
    assertEquals("value at (0,0)", 1, getCoefficient(0, 0))
  }
  @Test def test2() {
    assertEquals("value at (4,0)", 1, getCoefficient(4, 0))
  }
  @Test def test3() {
    assertEquals("value at (5,5)", 1, getCoefficient(5, 5))
  }
  @Test def test4() {
    assertEquals("value at (4,1)", 4, getCoefficient(4, 1))
  }
  @Test def test5() {
    assertEquals("value at (5,2)", 10, getCoefficient(5, 2))
  }
}


