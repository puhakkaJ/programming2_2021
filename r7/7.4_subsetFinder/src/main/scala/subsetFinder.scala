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

package subsetFinder

import scala.collection.immutable.Set

object Finder {
  /**
   * Find one "important" element in the domain of the tester.
   * If the domain contains no important elements, return None.
   * Use binary search to implement this.
   * Sets can be split with splitAt method (see http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.Set).
   * Must make at most ceil(log(tester.domain)*2)+1 calls to tester.contains.
   */
  def findOne[T](tester: Tester[T]): Option[T] = {
    var a = tester.domain

    def loop(tester: Tester[T]): Option[T] = {

      if (a.size == 1) {
        return Some(a.head)  
      }

      var b = a.splitAt(a.size / 2)

      if (tester.contains(b._1)) {
        a = b._1
        loop(tester)
      }

      else if (tester.contains(b._2)){
        a = b._2
        loop(tester)
      }

      else return None
    }

    if (a.isEmpty) return None
    else loop(tester)
  }
 
  /**
   * Find all the k "important" elements in the domain of the tester
   * (the value k is not known in advance!).
   * If the domain contains no important elements, return an empty set.
   * Use binary search to implement this.
   * Must make at most k*ceil(log(tester.domain)*2)+1 calls to tester.contains.
   */
  def findAll[T](tester: Tester[T]): Set[T] = {
    var a = tester.domain
    var set = Set[T]()

    def loop(s: Set[T]): Set[T] = {
      var split = s.splitAt(s.size / 2)

      if (s.size == 1) {
        set += s.head
      } else {
        var b = tester.contains(split._1)
        var c = tester.contains(split._2)

        if (b & c) {
          loop(split._1)
          loop(split._2)
        } else if (b) {
          loop(split._1)
        } else {
          loop(split._2)
        }                    
      }       
      
      set
    }

    if (tester.contains(a)) loop(a) 
    else set
  }
}

