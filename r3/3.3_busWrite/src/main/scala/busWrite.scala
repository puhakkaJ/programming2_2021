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

package tinylog
package busWrite

object factory {

  /**
   *  A controllable bus write unit. Specification is as follows:
   *
   * The input to the unit consists of
   * 1) 4 "register" buses, "r0", "r1", "r2", "r3", each consisting of n bits,
   * 2) a bus "data", consisting of n bits,
   * 3) a gate "writeEnable",
   * 4) a bus "writeTo", consisting of 2 bits, and
   * 5) a gate "reset".
   *
   * The output consists of 4 "register" buses "s0", "s1", "s2", "s3", each consisting
   * of n bits.
   *
   * The following three requirements must all hold.
   * a) If "reset" is true, then all bits in each of "s0", "s1", "s2", "s3"
   *    must be false.
   * b) If "reset" is false and "write_enable" is false, then
   *    the bits of "si" must agree with the bits of "ri", for all i=0,1,2,3.
   * c) If "reset" is false and "write_enable" is true, then
   *    the bits of "si" must agree with the bits of "ri", for all i=0,1,2,3
   *    such that i is not equal to j, where j is given by the
   *    bits of "write_to" in binary, that is, the least significant
   *    bit of j is equal to the value of write_to(0). Furthermore, the
   *    bits of "sj" must agree with the bits of "data".
   *
   * That is, in slightly less precise terms, if "reset" is true, then all
   * outputs must be false; otherwise "si" equals "ri" unless
   * "write_enable" is true in which case "sj" equals "data" for
   * j given by "write_to".
   */
  def buildBusWriteUnit4(r0: Bus, r1: Bus, r2: Bus, r3: Bus,
    data: Bus, writeEnable: Gate, writeTo: Bus, reset: Gate): (Bus, Bus, Bus, Bus) = {
    require(r0.length > 0, "The register buses cannot be empty")
    require(r0.length == r1.length, "The register buses must be of same width")
    require(r0.length == r2.length, "The register buses must be of same width")
    require(r0.length == r3.length, "The register buses must be of same width")
    require(r0.length == data.length, "The data bus must be of same width as the register buses")
    require(writeTo.length == 2)
    var b1 = r0 && (!reset && !writeEnable) | (data && (!reset && writeEnable && !writeTo(0) && !writeTo(1))) | (r0 && (!reset && writeEnable && !(!writeTo(0) && !writeTo(1))))
    var b2 = r1 && (!reset && !writeEnable) | (data && (!reset && writeEnable &&  writeTo(0) && !writeTo(1))) | (r1 && (!reset && writeEnable &&  !(writeTo(0) && !writeTo(1))))
    var b3 = r2 && (!reset && !writeEnable) | (data && (!reset && writeEnable && !writeTo(0) &&  writeTo(1))) | (r2 && (!reset && writeEnable && !(!writeTo(0) &&  writeTo(1))))
    var b4 = r3 && (!reset && !writeEnable) | (data && (!reset && writeEnable &&  writeTo(0) &&  writeTo(1))) | (r3 && (!reset && writeEnable &&  !(writeTo(0) &&  writeTo(1))))
    
    (b1, b2, b3, b4)
  }
}


