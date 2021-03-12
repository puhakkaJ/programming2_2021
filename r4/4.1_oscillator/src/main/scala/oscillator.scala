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
package oscillator

object factory {
  
  /**
   * An oscillator unit with period 2.
   * 
   * The function returns a bus that represents the oscillator state at 
   * time t, i.e., after t clock(s). The output of the oscillator is 
   * defined to be the value of the first gate, state(0), in the bus. 
   * The state is initialized in such a way that the output is true 
   * for t = 0, 2, 4, 6, ... and false otherwise.  
   */
  def buildOscillatorPeriod2(host: Circuit): Bus = {
    
    /** The state of the oscillator circuit consists of a bus with two gates 
        because the period is two. The bus is created from two input elements. */
    val state = host.inputs(2)
    
    /** The state gates are connected to each other using feedback such that 
        - the value of the second gate, state(1), is fed to the first gate, state(0),
        - the value of the first gate, state(0), is fed to the second gate, state(1). */ 
    state(0).buildFeedback(state(1))
    state(1).buildFeedback(state(0))
    
    /** Initialize the state such that the first gate value is true. The other 
        gate value is false by default. */  
    state(0).set(true)
    
    /** Return the full state. */
    state
  }
  
  /**
   * An oscillator unit with period 3.
   * 
   * The function returns a bus that represents the oscillator state at 
   * time t, i.e., after t clock(s). The output of the oscillator is defined 
   * to be the value of the first gate, state(0), in the bus. The state is 
   * initialized in such a way that the output is true for t = 0, 3, 6, 9, ... 
   * and false otherwise.  
   */
  def buildOscillatorPeriod3(host: Circuit): Bus = {
    
    /** The state of the oscillator circuit consists of a bus with three gates 
        because the period is three. The bus is created from three input elements. */
    val state = host.inputs(3)
    
    /** The state gates are connected to each other using feedback such that 
        - the value of the second gate, state(1), is fed to the first gate, state(0), 
        - the value of the third gate, state(2), is fed to the second gate, state(1),
        - the value of the first gate, state(0), is fed to the third gate, state(2). */
    state(0).buildFeedback(state(1))
    state(1).buildFeedback(state(2))
    state(2).buildFeedback(state(0))
    
    /** Initialize the state such that the first gate value is true. The other 
        gate values are false by default. */  
    state(0).set(true)
    
    /** Return the full state. */
    state
  }
  
  /**
   * An oscillator unit with period 4. 
   * 
   * In this case, the function creates an oscillator with period 4. 
   * The oscillator state should be initialized in such a way that the output 
   * is true for t = 0, 4, 8, 12, ... and false otherwise. 
   * Unlike in the previous cases, the function should return only 
   * the output gate (first gate in the state bus) instead of the full state. 
   */
  def buildOscillatorPeriod4(host: Circuit): Gate = { 
    val state = host.inputs(4)
    
    /** The state gates are connected to each other using feedback such that 
        - the value of the second gate, state(1), is fed to the first gate, state(0), 
        - the value of the third gate, state(2), is fed to the second gate, state(1),
        - the value of the first gate, state(0), is fed to the third gate, state(2). */
    state(0).buildFeedback(state(1))
    state(1).buildFeedback(state(2))
    state(2).buildFeedback(state(3))
    state(3).buildFeedback(state(0))
    
    /** Initialize the state such that the first gate value is true. The other 
        gate values are false by default. */  
    state(0).set(true)
    
    /** Return the full state. */
    state(0)
  }
  
  /**
   * An oscillator unit with a user-defined period.
   */
  def buildOscillator(host: Circuit, period: Int): Gate = {
    require(period > 0, "Period must be a positive integer.")
    val state = host.inputs(period)
    
    for (i <- 0 until period) {
      if (i == period-1) {
        state(i).buildFeedback(state(0))
      } else {
        state(i).buildFeedback(state(i+1))
      }
    }
    
    /** Initialize the state such that the first gate value is true. The other 
        gate values are false by default. */  
    state(0).set(true)
    
    /** Return the full state. */
    state(0)
  }
}


