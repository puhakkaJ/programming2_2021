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


package object promises {

  import scala.concurrent._
  import ExecutionContext.Implicits.global

  /*
   * Promise-objects are created with the method 'Promise.apply' 
   * (or in short form just 'Promise') that needs a type parameter.
   */

  val p = Promise[Int] 
      // we just made a promise to deliver an Int
    
  val f = p.future
      // f is the future associated with p --
      // once we decide to complete p, the future f will
      // be completed with our chosen completion for p

  p success 123
      // let us complete p with the value 123
      // (at this point f has completed with
      //  the value 123)

  /* 
   * Task 1:
   * Your task is to create a future workflow by returning from the
   * following function two promises, say, p and q, and one future f, 
   * such that when p and q complete successfully, the future f completes 
   * with the sum of the values of p and q. In case p or q fails, 
   * f should complete with either failure. (It does not matter which.)
   *
   * Hint: Every promise contains a future.
   *       Remember how futures were 'chained' in the previous exercises.
   *
   */
  def buildPlusF(): (Promise[Int], Promise[Int], Future[Int]) = {
    var p = Promise[Int]
    var q = Promise[Int]
    var f = p.future.map(l => p.future.value.get.get + q.future.value.get.get)
    (p, q, f)
  }

  /* 
   * Task 2:
   * The same as Task 1, but now f should complete with 0 if
   * at least one of p or q fails.
   *
   * Hint: Review methods for recovering from failure in Future:
   *       https://www.scala-lang.org/api/2.12.12/scala/concurrent/Future.html
   */
  def buildPlusZeroFailF(): (Promise[Int], Promise[Int], Future[Int]) = {
    var p = Promise[Int]
    var q = Promise[Int]
    var f = p.future.map(l => p.future.value.get.get + q.future.value.get.get).recover{case _ => 0}
    (p, q, f)
  }

  /* 
   * Task 3:
   * Promises can be used to select the fastest future to complete
   * among multiple alternative futures. This task asks you to
   * implement such functionality. Complete the following function
   * that returns a future that completes with the fastest 
   * among the two futures a,b to complete, regardless of whether the 
   * fastest future succeeds or fails. 
   *
   * Note: your code must not block and wait for the slower future to complete;
   *       indeed, it may be that the slower future never completes, 
   *       in which case your code will fail.
   *
   * Hint: take a look at the "try"-methods in 
   * http://www.scala-lang.org/api/2.12.12/scala/concurrent/Promise.html
   *
   */
  def fastestOfTwo(a: Future[Int], b: Future[Int]): Future[Int] = {
    var p = Promise[Int]
    var f = p.tryCompleteWith(b)
    f.tryCompleteWith(a)
    f.future
  }

  /* 
   * Task 4:
   * The same as above, but now we want the fastest __successful__
   * future, if any. (If both futures fail, the result should
   * complete with either of the two failed futures, it does not
   * matter which.)
   *
   * Note: your code must not block and wait for the slower future to complete
   *       if you have a successful completion already;
   *       indeed, it may be that the slower future never completes, 
   *       in which case your code will fail.
   *
   * Hint: revisit the previous hint, and also take a look at the 
   * "onComplete", "foreach", and "failed" methods in
   * http://www.scala-lang.org/api/2.12.12/scala/concurrent/Future.html
   *
   */
  def fastestSuccessfulOfTwo(a: Future[Int], b: Future[Int]): Future[Int] = ???

  /*
   * Task 5:
   * Let us revisit the setup of Task 1, but in the context of multiplication
   * rather than addition. Here our intent is to make a future multiplication 
   * complete as fast as possible if one of the future values completes to a 0.
   * (Indeed, in this case the product is 0 no matter what the other value is.)
   * 
   * Your task is to create a future workflow by returning from the following 
   * function two promises, say, p and q, and one future f, such that 
   * when p and q complete successfully, the future f completes with 
   * the __product__ of the values of p and q. 
   * Furthermore, in case p or q completes with the value 0, the future f 
   * should complete with the value 0 __as soon as possible__, that is, 
   * without waiting for both p and q to complete. 
   * In the case of failures, the future f should be completed as follows. 
   * First, if one future fails and the other completes with the value 0, 
   * f should complete (as soon as possible, cf. above) with the value 0. 
   * Second, if either p or q fails and the other completes successfully 
   * with a nonzero value, the future f should complete with the failed
   * p or q. If both p and q fail, f should complete with either failure. 
   * (It does not matter which.)
   *
   * Note: again your code must not block and wait for the slower promise
   *       if you can deliver a result as per the specification above;
   *       indeed, it may be that the slower promise never completes, 
   *       in which case your code will fail.
   *
   * Hint: Construct a promise for the return value, and complete 
   * the promise as instructed. Be careful that you do not accidentally
   * complete with a failure when p or q completes with 0. 
   *
   */

  def buildTimesFast0F(): (Promise[Int], Promise[Int], Future[Int]) = ???
}


