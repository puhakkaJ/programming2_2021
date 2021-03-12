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

package minilog
package seqmul

object factory {
  
  /** Helper functions for building a sequential multiplier. */
  
  def buildAdder0(aa: Bus, bb: Bus, c0v: Boolean) = {
    new Bus(
      (aa zip bb).scanLeft((aa.host.False, if (c0v) aa.host.True else aa.host.False)){
        case ((s, c), (a, b)) =>
          (a + b + c, (a && b) || (a && c) || (b && c)) // sum-mod-2, majority-of-3
      }.drop(1).map(_._1))
  }

  def buildAdder(aa: Bus, bb: Bus) = buildAdder0(aa, bb, false)
  
  /**
   * This task asks you to implement a builder for a sequential logic unit 
   * that multiplies two integers. 
   *
   * The multiplier takes the following inputs. First, there are two operand 
   * buses, "aa" and "bb", whose product is to be computed and given as output.
   * Second, there is an enable bit, "loadEnable", for loading operands and 
   * starting multiplication. There are two outputs, a gate "ready" and 
   * a bus "result". The bus "result" must have length at least the length 
   * of "aa" plus the length of "bb". 
   *
   * The multiplier must meet the following, more detailed specification.
   * All of the following requirements must be met:
   *
   * 1)
   * A multiplication is initialized by setting "aa" and "bb" to the values 
   * to be multiplied, setting "loadEnable" to true, and clocking the circuit.
   * This combination is referred to as a "load" in what follows.
   *
   * 2)
   * When "loadEnable" is true, "ready" must be false.
   * 
   * 3) 
   * After a "load" clocks the circuit, and "loadEnable" is set to false 
   * during subsequent clocks, "ready" may be false for at most 
   * 2*(aa.length+bb.length)+1 subsequent clocks.
   * (That is, the multiplication must complete in at most this number of 
   * clocks unless there is a new "load".) 
   * 
   * 4) 
   * When "ready" is true, "result" contains the product of the operands 
   * that were loaded during the most recent "load". 
   *
   * 5)
   * Once "ready" is true, it must remain true unless there is a new "load". 
   *
   * 6) 
   * The constructed circuit may have at most 30*(aa.length+bb.length) gates, 
   * including logic gates and input elements. In particular, a combinational 
   * multiplier will not do.
   *
   * Your function should return the gate "ready" and the bus "result", 
   * in this order.
   *
   * Hints: 
   * You will need to build internal state elements (that is, input elements) 
   * to store the operands and the result inside the unit. You can do this 
   * by first getting the host circuit (e.g. by calling loadEnable.host) and 
   * then requesting one more buses of input elements from the host. 
   * A simple solution is to have equal-length buses for storing both operands 
   * and the result. Shift one operand to the left and the other operand to 
   * the right when the clock triggers. Accumulate the result with a single 
   * adder. The multiplication is ready when one of the operands becomes zero. 
   * (Bitwise NOT the bus and reduce with AND to test this.) 
   * A helper function for building adders is given above. 
   * Use Trigger to test your design. Yet again the object "play" may 
   * be helpful. 
   *
   */

  def buildSequentialMultiplier(aa: Bus, bb: Bus, loadEnable: Gate): (Gate, Bus) = {
    val len = (aa++bb).length
    val result = loadEnable.host.inputs(len)
    val a = loadEnable.host.inputs(len)
    val b = loadEnable.host.inputs(len)
    var bbb = bb ++loadEnable.host.falses(a.length)
  
    //kertolaskun jälkeen a:sta pudeotetaan a(0) pois ja lisätään loppuun yksi 0 (Bus päittäin kuin bitit)
    //b siirretään vasemmalle niin, että oikealle lisätään aina yksi 0
    a.buildFeedback(((a.drop(1) ++ loadEnable.host.falses(1)) && !loadEnable) | (aa && loadEnable)) //a alempana kertolaskussa - valitaan aina aa(0), millä kerrotaan bb
    b.buildFeedback(((loadEnable.host.falses(1) ++ b.dropRight(1)) && !loadEnable) | (bbb && loadEnable))  //b ylhäällä kertolaskussa
    //koitin myös ilman dropRight(1)
 
    result.buildFeedback(buildAdder(result, b&&a(0)) && !loadEnable)  //summan tulos

    var r = ((~a).reduce(_ && _)) //katotaan onko jompikumpi tyhjänä

    (r && !loadEnable, result)
  }
}


