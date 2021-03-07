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

package polynomials

import org.junit.Test
import org.junit.Assert._

/*
 * Unit tests for polynomials.
 *
 */

class UnitTests {

  @Test def testTask1() {
    val x = new Variable("x")
    for(x0 <- -10 to 10) {
      x.set(x0)
      assertEquals("Set value " ++ x0.toString ++ " to x " 
                   ++ "but got " ++ x.value.toString ++ " back",
                   x0,
		   x.value)
    }
    for(x0 <- -10 to 10) {
      val c = new Constant(x0)
      assertEquals("Created constant with value " ++ x0.toString
                   ++ "but constant reports value " ++ c.value.toString,
                   x0,
		   c.value)
    }
  }

  @Test def testTasks12() {
    val x = new Variable("x")
    val poly = new Sum(new Product(x,x), new Constant(1)) // x*x+1
    for(x0 <- -10 to 10) {
      x.set(x0)
      assertEquals("Evaluated p(x) = " ++ poly.asString 
                   ++ " at x = " ++ x0.toString 
                   ++ " and got " ++ poly.value.toString
                   ++ "; however, should have gotten " 
                   ++ (x0*x0+1).toString,
                   x0*x0+1,
		   poly.value)
    }
  }

  @Test def testTasks123Univariate() {
    val x = new Variable("x")
    val poly = x*x + new Constant(1)
    for(x0 <- -10 to 10) {
      x.set(x0)
      assertEquals("Evaluated p(x) = " ++ poly.asString 
                   ++ " at x = " ++ x0.toString 
                   ++ " and got " ++ poly.value.toString
                   ++ "; however, should have gotten " 
                   ++ (x0*x0+1).toString,
                   x0*x0+1,
		   poly.value)
    }
  }

  @Test def testTasks123Univariate2() {
    val x = new Variable("x")
    val poly = x*(x + new Constant(1))+x*(x+x+x)*x+x
    for(x0 <- -10 to 10) {
      x.set(x0)
      assertEquals("Evaluated p(x) = " ++ poly.asString 
                   ++ " at x = " ++ x0.toString 
                   ++ " and got " ++ poly.value.toString
                   ++ "; however, should have gotten " 
                   ++ (x0*(x0+1)+x0*(x0+x0+x0)*x0+x0).toString,		   
                   x0*(x0+1)+x0*(x0+x0+x0)*x0+x0,
                   poly.value)
    }
  }  

  @Test def testTasks123Multivariate() {
    val x = new Variable("x")
    val y = new Variable("y")
    val poly = x*(y + new Constant(1))+y+x*new Constant(2)
    for(x0 <- -10 to 10) {
      x.set(x0)
      for(y0 <- -10 to 10) {
        y.set(y0)
        assertEquals("Evaluated p(x,y) = " ++ poly.asString 
                     ++ " at x = " ++ x0.toString ++ ", y = " ++ y0.toString
                     ++ " and got " ++ poly.value.toString
                     ++ "; however, should have gotten " 
                     ++ (x0*(y0+1)+y0+2*x0).toString,
                     x0*(y0+1)+y0+2*x0,
		     poly.value)
      }
    }
  }  
}


