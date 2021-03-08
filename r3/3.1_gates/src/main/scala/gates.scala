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
package gates

import scala.collection.immutable.Set
import scala.collection.immutable.HashSet

/** The abstract base class for all our Boolean gate types */
abstract class Gate() {
  /** The (evaluated) value of the gate */
  def value: Boolean
  /** A shorthand allowing us to write !g */
  def unary_!(): Gate = new NotGate(this)
  /** A shorthand allowing us to write g1 && g2 */
  def &&(that: Gate): Gate = new AndGate(this, that)
  /** A shorthand allowing us to write g1 || g2 */
  def ||(that: Gate): Gate = new OrGate(this, that)

  /** The maximum distance to an input element or constant gate. For instance, considering the circuit
   * val a = new InputElement()
   * val b = new ConstantGate(false)
   * val c = new ConstantGate(false)
   * val g1 = new AndGate(a,b)
   * val g2 = new OrGate(g1,b)
   * val g3 = new AndGate(c, g2)
   * the depth of g3 is 3.
   */
  def depth: Int

  /**
   * The support of a gate.
   * The support is the set of gates that includes (i) the gate itself, and
   * (ii) all the gates whose value must be evaluated when we evaluate
   * the gate itself. For instance, considering the circuit
   * val a = new InputElement()
   * val b = new ConstantGate(false)
   * val c = new ConstantGate(false)
   * val g1 = new AndGate(a,b)
   * val g2 = new OrGate(g1,b)
   * val g3 = new AndGate(c, g2)
   * the support of g2 is {g2,g1,b,a}.
   * Observe that the returned set must be a subclass of
   * [[scala.collection.immutable.Set]], [[scala.collection.immutable.HashSet]]
   * is a good candidate.
   */
  def support: Set[Gate]
  /**
   * The input element support of a gate.
   * The input element support consists all the InputElement gates whose
   * value can effect the value of the gate.
   * Implement the support method first. Then you have two choices:
   * - implement this method with similar recursive code, or
   * - modify the result of support to contain only InputElements 
   *   (for this you'll probably need the filter/map/foldLeft etc methods 
   *   from [[scala.immutable.Set]] as well a isInstanceOf and asInstanceOf 
   *   from [[scala.Any]].
   *   Later in the course we will find a more elegant way for doing the same
   *   by using 'case classes'.
   * */
  def inputElementSupport: Set[InputElement] = (this.support.filter(_.isInstanceOf[InputElement]).map(_.asInstanceOf[InputElement]))
}

/**
 * The companion object allowing easier construction of
 * constant and input gates.
 */
object Gate {
  val False: Gate = new ConstantGate(false)
  val True: Gate = new ConstantGate(true)
  def input(): Gate = new InputElement()
}

/** An input element gate. The value of an input element can be changed. */
class InputElement() extends Gate() {
  var v = false // default value is false
  def set(s: Boolean) = { v = s }
  def value = v
  def depth: Int = 0
  def support: Set[Gate] = Set(this)
}

/** A "not" gate */
class NotGate(in: Gate) extends Gate() {
  def value = !in.value
  def depth: Int = in.depth +1
  def support: Set[Gate] = in.support + this
}

/** An "or" gate */
class OrGate(in1: Gate, in2: Gate) extends Gate() {
  def value = in1.value || in2.value
  def depth: Int = math.max(in1.depth +1,in2.depth +1)
  def support: Set[Gate] = (in1.support | in2.support)  + this
}

/** An "and" gate */
class AndGate(in1: Gate, in2: Gate) extends Gate() {
  def value = in1.value && in2.value
  def depth: Int = math.max(in1.depth +1,in2.depth +1)
  def support: Set[Gate] = (in1.support | in2.support)  + this
}

/** An "exclusive-or" gate */
class XorGate(in1: Gate, in2: Gate) extends Gate() {
  def value = in1.value^in2.value
  def depth: Int = math.max(in1.depth +1,in2.depth +1)
  def support: Set[Gate] = (in1.support | in2.support)  + this
}

/** A "majority-of-three" gate.
 * @return true if and only if at least two of the inputs
 *              in1, in2, and in3 evaluate to true. */
class MajorityGate(in1: Gate, in2: Gate, in3: Gate) extends Gate() {
  def value = if ((in1.value && in2.value) || (in1.value && in3.value) || (in3.value && in2.value)) true else false
  def depth: Int = math.max(math.max(in1.depth +1,in2.depth +1),in3.depth+1)
  def support: Set[Gate] = (in1.support | in2.support | in3.support)  + this
}

/** Constant gates, always fixed to some value */
class ConstantGate(v: Boolean) extends Gate() {
  def value = v
  def depth: Int = 0
  def support: Set[Gate] = Set(this)
}


