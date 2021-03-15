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


package object frequencies {
  /*
   * NOTE: this is an exercise on functional programming style.
   * Therefore, you are NOT allowed to use mutable data structures or vars.
   */

  /**
   * Given a sequence seq of items of type T,
   * returns a map that associates each item in the sequence to the number times it
   * occurs in the sequence.
   * The resulting map should be undefined for all the items that do not appear in the sequence.
   * Hint: study the methods of http://www.scala-lang.org/api/current/index.html#scala.collection.Seq
   * and http://www.scala-lang.org/api/current/index.html#scala.collection.Map,
   * for instance, groupBy and mapValues may be useful.
   */
  def frequencies[T](seq: Seq[T]): Map[T, Int] = seq.groupBy(x => x).mapValues(x => x.length)
    
  /**
   * Given a sequence seq of items of type T,
   * returns a map that associates, to each positive integer i, the set of items
   * that occur i times in the sequence.
   * If no item occurs i times in the sequence, then the map must be undefined for that i.
   */
  def freqToItems[T](seq: Seq[T]): Map[Int, Set[T]] = seq.toSet.groupBy(x => frequencies(seq)(x))
  
  /**
   * Given a sequence seq of items of type T,
   * returns the set of all items that occur most frequently in the sequence.
   * If the sequence is empty, then (and only then) the resulting set should be empty.
   */
  def mostFrequent[T](seq: Seq[T]): Set[T] = if (seq.length > 0) freqToItems(seq).toList.sortWith(_._1 > _._1).head._2 else Set[T]()
}


