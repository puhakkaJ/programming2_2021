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

package object percentiles {

  /**
   * Given a non-empty sequence of elements of type T, returns the smallest element e
   * in the sequence for which it holds that at least p percent of the elements in the sequence
   * are smaller or equal to e.
   * Note the special cases:
   * - when p == 0, the result should be the smallest element in the sequence
   * - when p == 100, the result should be the largest element in the sequence
   * If the sequence is empty, java.lang.IllegalArgumentException is thrown.
   *
   * For a sequence of length n, the method should make at most n*log(n)
   * [again, here log means base-2 logarithm] comparison operations between
   * the elements in the sequence.
   * Furthermore, assuming that comparison is a constant-time operation,
   * the whole method should run in O(n*log(n)) time.
   * Hint: you can assume that the "sorted" method of Seq performs at most n*log(n) comparisons for
   * sequences of length n (the real underlying implementation of "sorted" is currently
   * http://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort%28T[],%20java.util.Comparator%29 )
   * 
   * Note that there are alternative definitions for "percentile",
   * see e.g. http://en.wikipedia.org/wiki/Percentile
   *
   * Advanced (non-obligatory) stuff: for the implicit keyword below, one can consult, for instance,
   * http://www.artima.com/pins1ed/implicit-conversions-and-parameters.html
   */
  def percentile[T](p: Int)(seq: Seq[T])(implicit ord: Ordering[T]): T = {
    require(0 <= p && p <= 100)
    require(!seq.isEmpty, "cannot compute percentiles on an empty sequence")
    if (p == 100) seq.sorted.last
    else if (p == 0) seq.sorted.head
    else {
      var l = Math.ceil(seq.length.toDouble * (p.toDouble / 100.0)).toInt
      seq.sorted.apply(l-1)
    }
  }
  def percentile10[T](seq: Seq[T])(implicit ord: Ordering[T]): T = percentile(10)(seq)
  def median[T](seq: Seq[T])(implicit ord: Ordering[T]): T = percentile(50)(seq)
  def percentile90[T](seq: Seq[T])(implicit ord: Ordering[T]): T = percentile(10)(seq)

  
  /*
   * The following functions are only provided for "additional reading"
   * to illustrate the use of implicit keyword.
   * You can safely ignore them if you wish.
   */
  /** Average value of a sequence of Ints*/
  def averageInt(seq: Seq[Int]): Double =  if(seq.isEmpty) 0.0 else seq.sum / seq.length
  /** Average value of a sequence of Doubles */
  def averageDouble(seq: Seq[Double]): Double =  if(seq.isEmpty) 0.0 else seq.sum / seq.length
  /**
   * With implicit conversions and the Numeric package, we can do a generic average
   * value function that works for all types T that can be implicitly translated into Numeric[T].
   * Performance-wise this is not as good as the specialized methods above!
   */
  def average[T](seq: Seq[T])(implicit conv: Numeric[T]): Double = {
    if (seq.isEmpty) 0.0
    else {
      val sum = seq.foldLeft[T](conv.zero)((s, e) => conv.plus(s, e))
      conv.toDouble(sum) / seq.length
    }
  }
}


