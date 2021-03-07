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
 * Assignment:  Word operations
 *
 * Description:
 * This assignment asks you to implement common word operations that are
 * not available in the Scala programming language. The intent is to practice
 * your skills at working with bits.
 *
 */

package object wordOps {

  /*
   * Task 1: Population count (number of 1-bits in a word)
   *
   * Complete the following function that takes as parameter
   * a 32-bit word, w, and returns __the number of 1-bits__ in w.
   *
   */

  def popCount(w: Int): Int = {
    var count: Int = 0
    var n = 0

    for (i <- 0 until 32) {
      n = (w >> i)&1.toInt
      
      if (n == 1) {
        count = count + 1
      }
    }

    return count
  }
  
  /*
   * Task 2: Reverse bit positions
   *
   * Complete the following function that takes as parameter
   * a 16-bit word, w, and returns a 16-bit word, r, such that
   * for every j=0,1,...,15,
   * the value of the bit at position j in r is equal to
   * the value of the bit at position 15-j in w.
   *
   */

  def reverse(w: Short): Short = {
    var b = 0x0000 
    var a = w.toInt

    for(i <- 0 until 16) {
	    b <<=1
	    b |= a & 0x1 
	    a = a >> 1 
    }

    return b.toShort
  }

  /*
   * Task 3: Left rotation
   *
   * Complete the following function that takes two parameters
   *
   * 1) a 64-bit word, w, and
   * 2) a 32-bit word, k.
   *
   * The function returns a 64-bit word, r, such that
   * for all j=0,1,...,63
   * the value of the bit at position (j+k)%64 in r is equal to
   * the value of the bit at position j in w.
   *
   */

  def leftRotate(w: Long, k: Int): Long = {
    var a:Long = w << k
    //tellAboutLong(a)
    var b:Long = (w >>> (64-k))
    //tellAboutLong(b)

    //tellAboutLong((a|b))

    return (a|b)

  }
}


