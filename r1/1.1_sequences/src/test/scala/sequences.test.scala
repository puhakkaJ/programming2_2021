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

package sequences

import org.junit.Test
import org.junit.Assert._

/*
 * Unit tests for sequences.
 *
 */

class UnitTests {

    @Test def testTask1() {
        assertEquals("failure on input Array[Int]()",
            Array[Int]().toSeq, addOneToSeq(Array[Int]()))
        assertEquals("failure on input Array(-47)",
            Array(-46).toSeq, addOneToSeq(Array(-47)))
        assertEquals("failure on input Array(-12)",
            Array(-11).toSeq, addOneToSeq(Array(-12)))
        assertEquals("failure on input Array(-37)",
            Array(-36).toSeq, addOneToSeq(Array(-37)))
        assertEquals("failure on input Array(-77, 8, 70)",
            Array(-76, 9, 71).toSeq, addOneToSeq(Array(-77, 8, 70)))
        assertEquals("failure on input Array(69, 60, -97)",
            Array(70, 61, -96).toSeq, addOneToSeq(Array(69, 60, -97)))
        assertEquals("failure on input Array(-43, -19, -13)",
            Array(-42, -18, -12).toSeq, addOneToSeq(Array(-43, -19, -13)))
        assertEquals("failure on input Array(-60, 13, 83)",
            Array(-59, 14, 84).toSeq, addOneToSeq(Array(-60, 13, 83)))
        assertEquals("failure on input Array(93, 26, -97)",
            Array(94, 27, -96).toSeq, addOneToSeq(Array(93, 26, -97)))
        assertEquals("failure on input Array(50, 25, -9, 24, 40)",
            Array(51, 26, -8, 25, 41).toSeq, addOneToSeq(Array(50, 25, -9, 24, 40)))
        assertEquals("failure on input Array(72, 59, -23, -45, -100)",
            Array(73, 60, -22, -44, -99).toSeq, addOneToSeq(Array(72, 59, -23, -45, -100)))
        assertEquals("failure on input Array(-14, -10, 68, -54, -63)",
            Array(-13, -9, 69, -53, -62).toSeq, addOneToSeq(Array(-14, -10, 68, -54, -63)))
        assertEquals("failure on input Array(5, 92, -80, -52, -80)",
            Array(6, 93, -79, -51, -79).toSeq, addOneToSeq(Array(5, 92, -80, -52, -80)))
        assertEquals("failure on input Array(-90, -19, -62, 35, 45)",
            Array(-89, -18, -61, 36, 46).toSeq, addOneToSeq(Array(-90, -19, -62, 35, 45)))
    }

    @Test def testTask2() {
        assertEquals("failure on input Array[Int]()",
            Array[Int]().toSeq, removeOdd(Array[Int]()))
        assertEquals("failure on input Array(46)",
            Array(46).toSeq, removeOdd(Array(46)))
        assertEquals("failure on input Array(36)",
            Array(36).toSeq, removeOdd(Array(36)))
        assertEquals("failure on input Array(51)",
            Array[Int]().toSeq, removeOdd(Array(51)))
        assertEquals("failure on input Array(98, 48, 44)",
            Array(98, 48, 44).toSeq, removeOdd(Array(98, 48, 44)))
        assertEquals("failure on input Array(65, 13, 3)",
            Array[Int]().toSeq, removeOdd(Array(65, 13, 3)))
        assertEquals("failure on input Array(44, 62, 56)",
            Array(44, 62, 56).toSeq, removeOdd(Array(44, 62, 56)))
        assertEquals("failure on input Array(95, 21, 89)",
            Array[Int]().toSeq, removeOdd(Array(95, 21, 89)))
        assertEquals("failure on input Array(90, 6, 11)",
            Array(90, 6).toSeq, removeOdd(Array(90, 6, 11)))
        assertEquals("failure on input Array(63, 5, 22, 95, 19)",
            Array(22).toSeq, removeOdd(Array(63, 5, 22, 95, 19)))
        assertEquals("failure on input Array(65, 48, 41, 93, 94)",
            Array(48, 94).toSeq, removeOdd(Array(65, 48, 41, 93, 94)))
        assertEquals("failure on input Array(14, 12, 58, 62, 20)",
            Array(14, 12, 58, 62, 20).toSeq, removeOdd(Array(14, 12, 58, 62, 20)))
        assertEquals("failure on input Array(32, 89, 96, 50, 22)",
            Array(32, 96, 50, 22).toSeq, removeOdd(Array(32, 89, 96, 50, 22)))
        assertEquals("failure on input Array(89, 33, 10, 6, 92)",
            Array(10, 6, 92).toSeq, removeOdd(Array(89, 33, 10, 6, 92)))
    }

    @Test def testTask3() {
        assertEquals("failure on input Array(0)",
            0, mySum(Array(0)))
        assertEquals("failure on input Array(36)",
            36, mySum(Array(36)))
        assertEquals("failure on input Array(51)",
            51, mySum(Array(51)))
        assertEquals("failure on input Array(98)",
            98, mySum(Array(98)))
        assertEquals("failure on input Array(48, 44, 65)",
            157, mySum(Array(48, 44, 65)))
        assertEquals("failure on input Array(13, 3, 44)",
            60, mySum(Array(13, 3, 44)))
        assertEquals("failure on input Array(62, 56, 95)",
            213, mySum(Array(62, 56, 95)))
        assertEquals("failure on input Array(21, 89, 90)",
            200, mySum(Array(21, 89, 90)))
        assertEquals("failure on input Array(6, 11, 63)",
            80, mySum(Array(6, 11, 63)))
        assertEquals("failure on input Array(5, 22, 95, 19, 65)",
            206, mySum(Array(5, 22, 95, 19, 65)))
        assertEquals("failure on input Array(48, 41, 93, 94, 14)",
            290, mySum(Array(48, 41, 93, 94, 14)))
        assertEquals("failure on input Array(12, 58, 62, 20, 32)",
            184, mySum(Array(12, 58, 62, 20, 32)))
        assertEquals("failure on input Array(89, 96, 50, 22, 89)",
            346, mySum(Array(89, 96, 50, 22, 89)))
        assertEquals("failure on input Array(33, 10, 6, 92, 20)",
            161, mySum(Array(33, 10, 6, 92, 20)))
    }

    @Test def testTask4() {
        assertEquals("failure on input Array(0, 3)",
            9, sumOfSquaresOfOdd(Array(0, 3)))
        assertEquals("failure on input Array(99, 48)",
            9801, sumOfSquaresOfOdd(Array(99, 48)))
        assertEquals("failure on input Array(66, 15)",
            225, sumOfSquaresOfOdd(Array(66, 15)))
        assertEquals("failure on input Array(44, 63)",
            3969, sumOfSquaresOfOdd(Array(44, 63)))
        assertEquals("failure on input Array(95, 23, 89, 90)",
            17475, sumOfSquaresOfOdd(Array(95, 23, 89, 90)))
        assertEquals("failure on input Array(6, 22, 97, 19)",
            9770, sumOfSquaresOfOdd(Array(6, 22, 97, 19)))
        assertEquals("failure on input Array(95, 94, 14, 12)",
            9025, sumOfSquaresOfOdd(Array(95, 94, 14, 12)))
        assertEquals("failure on input Array(33, 89, 96, 50)",
            9010, sumOfSquaresOfOdd(Array(33, 89, 96, 50)))
        assertEquals("failure on input Array(10, 7, 92, 20)",
            49, sumOfSquaresOfOdd(Array(10, 7, 92, 20)))
        assertEquals("failure on input Array(97, 98, 33, 20, 77, 43, 68, 47)",
            20485, sumOfSquaresOfOdd(Array(97, 98, 33, 20, 77, 43, 68, 47)))
        assertEquals("failure on input Array(82, 41, 8, 22, 59, 63, 90, 18)",
            9131, sumOfSquaresOfOdd(Array(82, 41, 8, 22, 59, 63, 90, 18)))
        assertEquals("failure on input Array(84, 93, 26, 56, 63, 99, 40, 65)",
            26644, sumOfSquaresOfOdd(Array(84, 93, 26, 56, 63, 99, 40, 65)))
        assertEquals("failure on input Array(81, 63, 73, 4, 7, 82, 59, 74)",
            19389, sumOfSquaresOfOdd(Array(81, 63, 73, 4, 7, 82, 59, 74)))
        assertEquals("failure on input Array(39, 13, 85, 45, 29, 96, 54, 6)",
            11781, sumOfSquaresOfOdd(Array(39, 13, 85, 45, 29, 96, 54, 6)))
    }

    @Test def testTask5() {
        assertEquals("failure on input Array(2, 0)",
            2, productOfNonzero(Array(2, 0)))
        assertEquals("failure on input Array(4, 0)",
            4, productOfNonzero(Array(4, 0)))
        assertEquals("failure on input Array(0, 2)",
            2, productOfNonzero(Array(0, 2)))
        assertEquals("failure on input Array(0, 1)",
            1, productOfNonzero(Array(0, 1)))
        assertEquals("failure on input Array(0, -5, 1, 0)",
            -5, productOfNonzero(Array(0, -5, 1, 0)))
        assertEquals("failure on input Array(3, 0, 3, 2)",
            18, productOfNonzero(Array(3, 0, 3, 2)))
        assertEquals("failure on input Array(4, 0, 0, -4)",
            -16, productOfNonzero(Array(4, 0, 0, -4)))
        assertEquals("failure on input Array(-1, 0, 3, 0)",
            -3, productOfNonzero(Array(-1, 0, 3, 0)))
        assertEquals("failure on input Array(0, 3, 4, -3)",
            -36, productOfNonzero(Array(0, 3, 4, -3)))
        assertEquals("failure on input Array(2, -1, -3, -5, 2, 0, 0, 3)",
            -180, productOfNonzero(Array(2, -1, -3, -5, 2, 0, 0, 3)))
        assertEquals("failure on input Array(-5, 0, 2, -1, 3, 1, -3, -2)",
            180, productOfNonzero(Array(-5, 0, 2, -1, 3, 1, -3, -2)))
        assertEquals("failure on input Array(-1, -2, 0, 4, -2, 2, -4, 3)",
            384, productOfNonzero(Array(-1, -2, 0, 4, -2, 2, -4, 3)))
        assertEquals("failure on input Array(-2, 2, -5, 4, 0, -3, -4, -1)",
            -960, productOfNonzero(Array(-2, 2, -5, 4, 0, -3, -4, -1)))
        assertEquals("failure on input Array(-3, 0, 0, 2, -4, -3, 0, 0)",
            -72, productOfNonzero(Array(-3, 0, 0, 2, -4, -3, 0, 0)))
        assertEquals("failure on input Array(-3, -4, -1, 0, 1, 3, 2, 3)",
            -216, productOfNonzero(Array(-3, -4, -1, 0, 1, 3, 2, 3)))
        assertEquals("failure on input Array(1, 3, 1, -4, 1, 0, -4, 1)",
            48, productOfNonzero(Array(1, 3, 1, -4, 1, 0, -4, 1)))
        assertEquals("failure on input Array(3, 3, 3, -2, 3, -4, -5, 0)",
            -3240, productOfNonzero(Array(3, 3, 3, -2, 3, -4, -5, 0)))
        assertEquals("failure on input Array(1, 2, 2, 1, -1, -5, 2, 0)",
            40, productOfNonzero(Array(1, 2, 2, 1, -1, -5, 2, 0)))
        assertEquals("failure on input Array(1, 1, -3, -2, -5, -4, 0, -1)",
            -120, productOfNonzero(Array(1, 1, -3, -2, -5, -4, 0, -1)))
    }

    @Test def testTask6() {
        assertEquals("failure on input Array(100, -28)",
            10000, minOfSquaresAtLeast17OfPositive(Array(100, -28)))
        assertEquals("failure on input Array(30, -12)",
            900, minOfSquaresAtLeast17OfPositive(Array(30, -12)))
        assertEquals("failure on input Array(-94, 73)",
            5329, minOfSquaresAtLeast17OfPositive(Array(-94, 73)))
        assertEquals("failure on input Array(90, 100)",
            8100, minOfSquaresAtLeast17OfPositive(Array(90, 100)))
        assertEquals("failure on input Array(4, 15)",
            225, minOfSquaresAtLeast17OfPositive(Array(4, 15)))
        assertEquals("failure on input Array(-20, 1, 35, 90)",
            1225, minOfSquaresAtLeast17OfPositive(Array(-20, 1, 35, 90)))
        assertEquals("failure on input Array(-88, -78, 82, -90)",
            6724, minOfSquaresAtLeast17OfPositive(Array(-88, -78, 82, -90)))
        assertEquals("failure on input Array(79, -18, 86, 88)",
            6241, minOfSquaresAtLeast17OfPositive(Array(79, -18, 86, 88)))
        assertEquals("failure on input Array(50, -36, 78, 92)",
            2500, minOfSquaresAtLeast17OfPositive(Array(50, -36, 78, 92)))
        assertEquals("failure on input Array(-80, -88, 100, -60)",
            10000, minOfSquaresAtLeast17OfPositive(Array(-80, -88, 100, -60)))
        assertEquals("failure on input Array(94, -34, 95, 54)",
            2916, minOfSquaresAtLeast17OfPositive(Array(94, -34, 95, 54)))
        assertEquals("failure on input Array(32, -48, 20, 86, 48, -42, 64, -18)",
            400, minOfSquaresAtLeast17OfPositive(Array(32, -48, 20, 86, 48, -42, 64, -18)))
        assertEquals("failure on input Array(20, -54, 83, 74, 96, 68, 86, -48)",
            400, minOfSquaresAtLeast17OfPositive(Array(20, -54, 83, 74, 96, 68, 86, -48)))
        assertEquals("failure on input Array(-40, -54, -50, 35, 58, 26, 46, -92)",
            676, minOfSquaresAtLeast17OfPositive(Array(-40, -54, -50, 35, 58, 26, 46, -92)))
        assertEquals("failure on input Array(16, -24, -40, 30, -76, 70, -10, -42)",
            256, minOfSquaresAtLeast17OfPositive(Array(16, -24, -40, 30, -76, 70, -10, -42)))
        assertEquals("failure on input Array(18, -58, 68, 28, 88, 16, 80, 68)",
            256, minOfSquaresAtLeast17OfPositive(Array(18, -58, 68, 28, 88, 16, 80, 68)))
    }

    @Test def testTask7() {
        assertEquals("failure on input Array[(Int,Int)]()",
            Array[Int]().toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array[(Int, Int)]()))
        assertEquals("failure on input Array((46,36))",
            Array(36).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((46, 36))))
        assertEquals("failure on input Array((51,98))",
            Array[Int]().toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((51, 98))))
        assertEquals("failure on input Array((48,44))",
            Array(44).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((48, 44))))
        assertEquals("failure on input Array((65,3), (13,44))",
            Array[Int]().toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((65, 3), (13, 44))))
        assertEquals("failure on input Array((62,95), (56,21))",
            Array(95, 21).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((62, 95), (56, 21))))
        assertEquals("failure on input Array((89,6), (90,11))",
            Array(11).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((89, 6), (90, 11))))
        assertEquals("failure on input Array((63,19), (5,65), (22,48), (95,41))",
            Array(48).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((63, 19), (5, 65), (22, 48), (95, 41))))
        assertEquals("failure on input Array((93,58), (94,62), (14,20), (12,32))",
            Array(62, 20, 32).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((93, 58), (94, 62), (14, 20), (12, 32))))
        assertEquals("failure on input Array((89,89), (96,33), (50,10), (22,6))",
            Array(33, 10, 6).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((89, 89), (96, 33), (50, 10), (22, 6))))
        assertEquals("failure on input Array((92,40), (20,97), (17,97), (87,33))",
            Array(40, 97).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((92, 40), (20, 97), (17, 97), (87, 33))))
        assertEquals("failure on input Array((20,46), (77,78), (43,66), (68,26))",
            Array(46, 26).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((20, 46), (77, 78), (43, 66), (68, 26))))
        assertEquals("failure on input Array((60,59), (93,62), (84,90), (29,18), (82,23), (41,31), (8,60), (22,23))",
            Array(59, 90, 23, 60, 23).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((60, 59), (93, 62), (84, 90), (29, 18), (82, 23), (41, 31), (8, 60), (22, 23))))
        assertEquals("failure on input Array((73,99), (87,40), (98,63), (84,44), (93,92), (26,66), (56,30), (63,23))",
            Array(63, 44, 66, 30).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((73, 99), (87, 40), (98, 63), (84, 44), (93, 92), (26, 66), (56, 30), (63, 23))))
        assertEquals("failure on input Array((25,59), (64,74), (79,43), (63,36), (73,2), (4,18), (7,58), (81,38))",
            Array(74, 18).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((25, 59), (64, 74), (79, 43), (63, 36), (73, 2), (4, 18), (7, 58), (81, 38))))
        assertEquals("failure on input Array((30,6), (39,77), (12,54), (85,81), (45,57), (29,13), (96,59), (53,21))",
            Array(6, 54, 59).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((30, 6), (39, 77), (12, 54), (85, 81), (45, 57), (29, 13), (96, 59), (53, 21))))
        assertEquals("failure on input Array((84,38), (11,90), (94,81), (58,24), (90,23), (84,11), (97,3), (2,96))",
            Array(38, 81, 24, 23, 11, 96).toSeq, sequenceOfSecondPartsWhoseFirstPartIsEven(Array((84, 38), (11, 90), (94, 81), (58, 24), (90, 23), (84, 11), (97, 3), (2, 96))))
    }

    @Test def testTask8() {
        assertEquals("failure on input Array((46,36))",
            1656, sumOfProductsOfPairs(Array((46, 36))))
        assertEquals("failure on input Array((51,48), (98,44))",
            6760, sumOfProductsOfPairs(Array((51, 48), (98, 44))))
        assertEquals("failure on input Array((65,3), (13,44))",
            767, sumOfProductsOfPairs(Array((65, 3), (13, 44))))
        assertEquals("failure on input Array((62,95), (56,21))",
            7066, sumOfProductsOfPairs(Array((62, 95), (56, 21))))
        assertEquals("failure on input Array((89,63), (90,5), (6,22), (11,95))",
            7234, sumOfProductsOfPairs(Array((89, 63), (90, 5), (6, 22), (11, 95))))
        assertEquals("failure on input Array((19,93), (65,94), (48,14), (41,12))",
            9041, sumOfProductsOfPairs(Array((19, 93), (65, 94), (48, 14), (41, 12))))
        assertEquals("failure on input Array((58,89), (62,96), (20,50), (32,22))",
            12818, sumOfProductsOfPairs(Array((58, 89), (62, 96), (20, 50), (32, 22))))
        assertEquals("failure on input Array((89,92), (33,20), (10,17), (6,87))",
            9540, sumOfProductsOfPairs(Array((89, 92), (33, 20), (10, 17), (6, 87))))
        assertEquals("failure on input Array((40,20), (97,77), (97,43), (33,68))",
            14684, sumOfProductsOfPairs(Array((40, 20), (97, 77), (97, 43), (33, 68))))
        assertEquals("failure on input Array((46,82), (78,41), (66,8), (26,22), (60,59), (93,62), (84,90), (29,18))",
            25458, sumOfProductsOfPairs(Array((46, 82), (78, 41), (66, 8), (26, 22), (60, 59), (93, 62), (84, 90), (29, 18))))
        assertEquals("failure on input Array((23,93), (31,26), (60,56), (23,63), (73,99), (87,40), (98,63), (84,44))",
            28331, sumOfProductsOfPairs(Array((23, 93), (31, 26), (60, 56), (23, 63), (73, 99), (87, 40), (98, 63), (84, 44))))
        assertEquals("failure on input Array((92,73), (66,4), (30,7), (23,81), (25,59), (64,74), (79,43), (63,36))",
            20929, sumOfProductsOfPairs(Array((92, 73), (66, 4), (30, 7), (23, 81), (25, 59), (64, 74), (79, 43), (63, 36))))
        assertEquals("failure on input Array((2,45), (18,29), (58,96), (38,53), (30,6), (39,77), (12,54), (85,81))",
            18910, sumOfProductsOfPairs(Array((2, 45), (18, 29), (58, 96), (38, 53), (30, 6), (39, 77), (12, 54), (85, 81))))
        assertEquals("failure on input Array((57,90), (13,84), (59,97), (21,2), (84,38), (11,90), (94,81), (58,24))",
            25175, sumOfProductsOfPairs(Array((57, 90), (13, 84), (59, 97), (21, 2), (84, 38), (11, 90), (94, 81), (58, 24))))
    }

    @Test def testTask9() {
        assertEquals("failure on input a = Array[Int](), b = Array[Int]()",
            Array[Int]().toSeq, sumOfTwoDDimVectors(Array[Int](), Array[Int]()))
        assertEquals("failure on input a = Array(-47), b = Array(-12)",
            Array(-59).toSeq, sumOfTwoDDimVectors(Array(-47), Array(-12)))
        assertEquals("failure on input a = Array(-37), b = Array(-77)",
            Array(-114).toSeq, sumOfTwoDDimVectors(Array(-37), Array(-77)))
        assertEquals("failure on input a = Array(8), b = Array(70)",
            Array(78).toSeq, sumOfTwoDDimVectors(Array(8), Array(70)))
        assertEquals("failure on input a = Array(69, 60, -97), b = Array(-43, -19, -13)",
            Array(26, 41, -110).toSeq, sumOfTwoDDimVectors(Array(69, 60, -97), Array(-43, -19, -13)))
        assertEquals("failure on input a = Array(-60, 13, 83), b = Array(93, 26, -97)",
            Array(33, 39, -14).toSeq, sumOfTwoDDimVectors(Array(-60, 13, 83), Array(93, 26, -97)))
        assertEquals("failure on input a = Array(50, 25, -9), b = Array(24, 40, 72)",
            Array(74, 65, 63).toSeq, sumOfTwoDDimVectors(Array(50, 25, -9), Array(24, 40, 72)))
        assertEquals("failure on input a = Array(59, -23, -45), b = Array(-100, -14, -10)",
            Array(-41, -37, -55).toSeq, sumOfTwoDDimVectors(Array(59, -23, -45), Array(-100, -14, -10)))
        assertEquals("failure on input a = Array(68, -54, -63), b = Array(5, 92, -80)",
            Array(73, 38, -143).toSeq, sumOfTwoDDimVectors(Array(68, -54, -63), Array(5, 92, -80)))
        assertEquals("failure on input a = Array(-52, -80, -90, -19, -62), b = Array(35, 45, 56, -98, -66)",
            Array(-17, -35, -34, -117, -128).toSeq, sumOfTwoDDimVectors(Array(-52, -80, -90, -19, -62), Array(35, 45, 56, -98, -66)))
        assertEquals("failure on input a = Array(28, 79, 69, 85, -2), b = Array(19, -45, 15, 25, 23)",
            Array(47, 34, 84, 110, 21).toSeq, sumOfTwoDDimVectors(Array(28, 79, 69, 85, -2), Array(19, -45, 15, 25, 23)))
        assertEquals("failure on input a = Array(83, 34, -80, -45, 31), b = Array(-34, 59, 96, -28, 26)",
            Array(49, 93, 16, -73, 57).toSeq, sumOfTwoDDimVectors(Array(83, 34, -80, -45, 31), Array(-34, 59, 96, -28, 26)))
        assertEquals("failure on input a = Array(74, -93, -36, 98, 43), b = Array(74, -26, 64, -45, 80)",
            Array(148, -119, 28, 53, 123).toSeq, sumOfTwoDDimVectors(Array(74, -93, -36, 98, 43), Array(74, -26, 64, -45, 80)))
        assertEquals("failure on input a = Array(47, -42, 45, 41, -100), b = Array(85, 46, -63, -6, 14)",
            Array(132, 4, -18, 35, -86).toSeq, sumOfTwoDDimVectors(Array(47, -42, 45, 41, -100), Array(85, 46, -63, -6, 14)))
    }

    @Test def testTask10() {
        assertEquals("failure on input a = Array(-2), b = Array(3)",
            -6, innerProductOfTwoDDimVectors(Array(-2), Array(3)))
        assertEquals("failure on input a = Array(-37), b = Array(-77)",
            2849, innerProductOfTwoDDimVectors(Array(-37), Array(-77)))
        assertEquals("failure on input a = Array(8), b = Array(70)",
            560, innerProductOfTwoDDimVectors(Array(8), Array(70)))
        assertEquals("failure on input a = Array(69), b = Array(60)",
            4140, innerProductOfTwoDDimVectors(Array(69), Array(60)))
        assertEquals("failure on input a = Array(-97, -43, -19), b = Array(-13, -60, 13)",
            3594, innerProductOfTwoDDimVectors(Array(-97, -43, -19), Array(-13, -60, 13)))
        assertEquals("failure on input a = Array(83, 93, 26), b = Array(-97, 50, 25)",
            -2751, innerProductOfTwoDDimVectors(Array(83, 93, 26), Array(-97, 50, 25)))
        assertEquals("failure on input a = Array(-9, 24, 40), b = Array(72, 59, -23)",
            -152, innerProductOfTwoDDimVectors(Array(-9, 24, 40), Array(72, 59, -23)))
        assertEquals("failure on input a = Array(-45, -100, -14), b = Array(-10, 68, -54)",
            -5594, innerProductOfTwoDDimVectors(Array(-45, -100, -14), Array(-10, 68, -54)))
        assertEquals("failure on input a = Array(-63, 5, 92), b = Array(-80, -52, -80)",
            -2580, innerProductOfTwoDDimVectors(Array(-63, 5, 92), Array(-80, -52, -80)))
        assertEquals("failure on input a = Array(-90, -19, -62, 35, 45), b = Array(56, -98, -66, 28, 79)",
            5449, innerProductOfTwoDDimVectors(Array(-90, -19, -62, 35, 45), Array(56, -98, -66, 28, 79)))
        assertEquals("failure on input a = Array(69, 85, -2, 19, -45), b = Array(15, 25, 23, 83, 34)",
            3161, innerProductOfTwoDDimVectors(Array(69, 85, -2, 19, -45), Array(15, 25, 23, 83, 34)))
        assertEquals("failure on input a = Array(-80, -45, 31, -34, 59), b = Array(96, -28, 26, 74, -93)",
            -13617, innerProductOfTwoDDimVectors(Array(-80, -45, 31, -34, 59), Array(96, -28, 26, 74, -93)))
        assertEquals("failure on input a = Array(-36, 98, 43, 74, -26), b = Array(64, -45, 80, 47, -42)",
            1296, innerProductOfTwoDDimVectors(Array(-36, 98, 43, 74, -26), Array(64, -45, 80, 47, -42)))
        assertEquals("failure on input a = Array(45, 41, -100, 85, 46), b = Array(-63, -6, 14, -34, -70)",
            -10591, innerProductOfTwoDDimVectors(Array(45, 41, -100, 85, 46), Array(-63, -6, 14, -34, -70)))
    }

    @Test def testTask11() {
        assertEquals("failure on input a = Array(-2), b = Array(3)",
            25, squareOfDDimEuclideanDistance(Array(-2), Array(3)))
        assertEquals("failure on input a = Array(-37), b = Array(-77)",
            1600, squareOfDDimEuclideanDistance(Array(-37), Array(-77)))
        assertEquals("failure on input a = Array(8), b = Array(70)",
            3844, squareOfDDimEuclideanDistance(Array(8), Array(70)))
        assertEquals("failure on input a = Array(69), b = Array(60)",
            81, squareOfDDimEuclideanDistance(Array(69), Array(60)))
        assertEquals("failure on input a = Array(-97, -43, -19), b = Array(-13, -60, 13)",
            8369, squareOfDDimEuclideanDistance(Array(-97, -43, -19), Array(-13, -60, 13)))
        assertEquals("failure on input a = Array(83, 93, 26), b = Array(-97, 50, 25)",
            34250, squareOfDDimEuclideanDistance(Array(83, 93, 26), Array(-97, 50, 25)))
        assertEquals("failure on input a = Array(-9, 24, 40), b = Array(72, 59, -23)",
            11755, squareOfDDimEuclideanDistance(Array(-9, 24, 40), Array(72, 59, -23)))
        assertEquals("failure on input a = Array(-45, -100, -14), b = Array(-10, 68, -54)",
            31049, squareOfDDimEuclideanDistance(Array(-45, -100, -14), Array(-10, 68, -54)))
        assertEquals("failure on input a = Array(-63, 5, 92), b = Array(-80, -52, -80)",
            33122, squareOfDDimEuclideanDistance(Array(-63, 5, 92), Array(-80, -52, -80)))
        assertEquals("failure on input a = Array(-90, -19, -62, 35, 45), b = Array(56, -98, -66, 28, 79)",
            28778, squareOfDDimEuclideanDistance(Array(-90, -19, -62, 35, 45), Array(56, -98, -66, 28, 79)))
        assertEquals("failure on input a = Array(69, 85, -2, 19, -45), b = Array(15, 25, 23, 83, 34)",
            17478, squareOfDDimEuclideanDistance(Array(69, 85, -2, 19, -45), Array(15, 25, 23, 83, 34)))
        assertEquals("failure on input a = Array(-80, -45, 31, -34, 59), b = Array(96, -28, 26, 74, -93)",
            66058, squareOfDDimEuclideanDistance(Array(-80, -45, 31, -34, 59), Array(96, -28, 26, 74, -93)))
        assertEquals("failure on input a = Array(-36, 98, 43, 74, -26), b = Array(64, -45, 80, 47, -42)",
            32803, squareOfDDimEuclideanDistance(Array(-36, 98, 43, 74, -26), Array(64, -45, 80, 47, -42)))
        assertEquals("failure on input a = Array(45, 41, -100, 85, 46), b = Array(-63, -6, 14, -34, -70)",
            54486, squareOfDDimEuclideanDistance(Array(45, 41, -100, 85, 46), Array(-63, -6, 14, -34, -70)))
    }

    @Test def testTask12() {
        assertEquals("failure on input a = Array(-2), b = Array(3), j = 0",
            Array((-2, 3)).toSeq, pairWithOffset(Array(-2), Array(3), 0))
        assertEquals("failure on input a = Array(-77), b = Array(8), j = 0",
            Array((-77, 8)).toSeq, pairWithOffset(Array(-77), Array(8), 0))
        assertEquals("failure on input a = Array(69), b = Array(60), j = 0",
            Array((69, 60)).toSeq, pairWithOffset(Array(69), Array(60), 0))
        assertEquals("failure on input a = Array(-43), b = Array(-19), j = 0",
            Array((-43, -19)).toSeq, pairWithOffset(Array(-43), Array(-19), 0))
        assertEquals("failure on input a = Array(-60, 13, 83), b = Array(93, 26, -97), j = 1",
            Array((-60, 26), (13, -97)).toSeq, pairWithOffset(Array(-60, 13, 83), Array(93, 26, -97), 1))
        assertEquals("failure on input a = Array(25, -9, 24), b = Array(40, 72, 59), j = 1",
            Array((25, 72), (-9, 59)).toSeq, pairWithOffset(Array(25, -9, 24), Array(40, 72, 59), 1))
        assertEquals("failure on input a = Array(-45, -100, -14), b = Array(-10, 68, -54), j = 2",
            Array((-45, -54)).toSeq, pairWithOffset(Array(-45, -100, -14), Array(-10, 68, -54), 2))
        assertEquals("failure on input a = Array(5, 92, -80), b = Array(-52, -80, -90), j = 2",
            Array((5, -90)).toSeq, pairWithOffset(Array(5, 92, -80), Array(-52, -80, -90), 2))
        assertEquals("failure on input a = Array(-62, 35, 45), b = Array(56, -98, -66), j = 2",
            Array((-62, -66)).toSeq, pairWithOffset(Array(-62, 35, 45), Array(56, -98, -66), 2))
        assertEquals("failure on input a = Array(79, 69, 85, -2, 19), b = Array(-45, 15, 25, 23, 83), j = 1",
            Array((79, 15), (69, 25), (85, 23), (-2, 83)).toSeq, pairWithOffset(Array(79, 69, 85, -2, 19), Array(-45, 15, 25, 23, 83), 1))
        assertEquals("failure on input a = Array(-80, -45, 31, -34, 59), b = Array(96, -28, 26, 74, -93), j = 0",
            Array((-80, 96), (-45, -28), (31, 26), (-34, 74), (59, -93)).toSeq, pairWithOffset(Array(-80, -45, 31, -34, 59), Array(96, -28, 26, 74, -93), 0))
        assertEquals("failure on input a = Array(98, 43, 74, -26, 64), b = Array(-45, 80, 47, -42, 45), j = 1",
            Array((98, 80), (43, 47), (74, -42), (-26, 45)).toSeq, pairWithOffset(Array(98, 43, 74, -26, 64), Array(-45, 80, 47, -42, 45), 1))
        assertEquals("failure on input a = Array(-100, 85, 46, -63, -6), b = Array(14, -34, -70, 29, -36), j = 0",
            Array((-100, 14), (85, -34), (46, -70), (-63, 29), (-6, -36)).toSeq, pairWithOffset(Array(-100, 85, 46, -63, -6), Array(14, -34, -70, 29, -36), 0))
        assertEquals("failure on input a = Array(-91, -80, 8, 77, 56), b = Array(45, 9, -19, 30, 7), j = 1",
            Array((-91, 9), (-80, -19), (8, 30), (77, 7)).toSeq, pairWithOffset(Array(-91, -80, 8, 77, 56), Array(45, 9, -19, 30, 7), 1))
    }

    @Test def testTask13() {
        assertEquals("failure on input Array(-2)",
            Array[(Int, Int)]().toSeq, consecutivePositionPairs(Array(-2)))
        assertEquals("failure on input Array(-12, -37, -77)",
            Array((-12, -37), (-37, -77)).toSeq, consecutivePositionPairs(Array(-12, -37, -77)))
        assertEquals("failure on input Array(8, 70, 69)",
            Array((8, 70), (70, 69)).toSeq, consecutivePositionPairs(Array(8, 70, 69)))
        assertEquals("failure on input Array(60, -97, -43)",
            Array((60, -97), (-97, -43)).toSeq, consecutivePositionPairs(Array(60, -97, -43)))
        assertEquals("failure on input Array(-19, -13, -60)",
            Array((-19, -13), (-13, -60)).toSeq, consecutivePositionPairs(Array(-19, -13, -60)))
        assertEquals("failure on input Array(13, 83, 93)",
            Array((13, 83), (83, 93)).toSeq, consecutivePositionPairs(Array(13, 83, 93)))
        assertEquals("failure on input Array(26, -97, 50, 25, -9)",
            Array((26, -97), (-97, 50), (50, 25), (25, -9)).toSeq, consecutivePositionPairs(Array(26, -97, 50, 25, -9)))
        assertEquals("failure on input Array(24, 40, 72, 59, -23)",
            Array((24, 40), (40, 72), (72, 59), (59, -23)).toSeq, consecutivePositionPairs(Array(24, 40, 72, 59, -23)))
        assertEquals("failure on input Array(-45, -100, -14, -10, 68)",
            Array((-45, -100), (-100, -14), (-14, -10), (-10, 68)).toSeq, consecutivePositionPairs(Array(-45, -100, -14, -10, 68)))
        assertEquals("failure on input Array(-54, -63, 5, 92, -80)",
            Array((-54, -63), (-63, 5), (5, 92), (92, -80)).toSeq, consecutivePositionPairs(Array(-54, -63, 5, 92, -80)))
        assertEquals("failure on input Array(-52, -80, -90, -19, -62)",
            Array((-52, -80), (-80, -90), (-90, -19), (-19, -62)).toSeq, consecutivePositionPairs(Array(-52, -80, -90, -19, -62)))
        assertEquals("failure on input Array(35, 45, 56, -98, -66, 28, 79)",
            Array((35, 45), (45, 56), (56, -98), (-98, -66), (-66, 28), (28, 79)).toSeq, consecutivePositionPairs(Array(35, 45, 56, -98, -66, 28, 79)))
        assertEquals("failure on input Array(69, 85, -2, 19, -45, 15, 25)",
            Array((69, 85), (85, -2), (-2, 19), (19, -45), (-45, 15), (15, 25)).toSeq, consecutivePositionPairs(Array(69, 85, -2, 19, -45, 15, 25)))
        assertEquals("failure on input Array(23, 83, 34, -80, -45, 31, -34)",
            Array((23, 83), (83, 34), (34, -80), (-80, -45), (-45, 31), (31, -34)).toSeq, consecutivePositionPairs(Array(23, 83, 34, -80, -45, 31, -34)))
        assertEquals("failure on input Array(59, 96, -28, 26, 74, -93, -36)",
            Array((59, 96), (96, -28), (-28, 26), (26, 74), (74, -93), (-93, -36)).toSeq, consecutivePositionPairs(Array(59, 96, -28, 26, 74, -93, -36)))
        assertEquals("failure on input Array(98, 43, 74, -26, 64, -45, 80)",
            Array((98, 43), (43, 74), (74, -26), (-26, 64), (64, -45), (-45, 80)).toSeq, consecutivePositionPairs(Array(98, 43, 74, -26, 64, -45, 80)))
    }

    @Test def testTask14() {
        assertEquals("failure on input Array(-47)",
            0, firstMaxPos(Array(-47)))
        assertEquals("failure on input Array(-12, -37)",
            0, firstMaxPos(Array(-12, -37)))
        assertEquals("failure on input Array(-77, 8)",
            1, firstMaxPos(Array(-77, 8)))
        assertEquals("failure on input Array(70, 69)",
            0, firstMaxPos(Array(70, 69)))
        assertEquals("failure on input Array(5, 5)",
            0, firstMaxPos(Array(5, 5)))
        assertEquals("failure on input Array(13, 27, -95, 27)",
            1, firstMaxPos(Array(13, 27, -95, 27)))
        assertEquals("failure on input Array(60, -97, -43, -19)",
            0, firstMaxPos(Array(60, -97, -43, -19)))
        assertEquals("failure on input Array(-13, -60, 13, 83)",
            3, firstMaxPos(Array(-13, -60, 13, 83)))
        assertEquals("failure on input Array(93, 26, -97, 50)",
            0, firstMaxPos(Array(93, 26, -97, 50)))
        assertEquals("failure on input Array(25, -9, 24, 40)",
            3, firstMaxPos(Array(25, -9, 24, 40)))
        assertEquals("failure on input Array(72, 59, -23, -45)",
            0, firstMaxPos(Array(72, 59, -23, -45)))
        assertEquals("failure on input Array(-100, -14, -10, 68, -54, -63, 5, 92)",
            7, firstMaxPos(Array(-100, -14, -10, 68, -54, -63, 5, 92)))
        assertEquals("failure on input Array(-80, -52, -80, -90, -19, -62, 35, 45)",
            7, firstMaxPos(Array(-80, -52, -80, -90, -19, -62, 35, 45)))
        assertEquals("failure on input Array(56, -98, -66, 28, 79, 69, 85, -2)",
            6, firstMaxPos(Array(56, -98, -66, 28, 79, 69, 85, -2)))
        assertEquals("failure on input Array(19, -45, 15, 25, 23, 83, 34, -80)",
            5, firstMaxPos(Array(19, -45, 15, 25, 23, 83, 34, -80)))
        assertEquals("failure on input Array(-45, 31, -34, 59, 96, -28, 26, 74)",
            4, firstMaxPos(Array(-45, 31, -34, 59, 96, -28, 26, 74)))
    }

    @Test def testTask15() {
        assertEquals("failure on input a = Array(-47, -12), b = Array(-37, -77)",
            (Array(-84, -89).toSeq, Array(-10, 65).toSeq), sumAndDifferenceSeqs(Array(-47, -12), Array(-37, -77)))
        assertEquals("failure on input a = Array(8, 70), b = Array(69, 60)",
            (Array(77, 130).toSeq, Array(-61, 10).toSeq), sumAndDifferenceSeqs(Array(8, 70), Array(69, 60)))
        assertEquals("failure on input a = Array(-97, -43), b = Array(-19, -13)",
            (Array(-116, -56).toSeq, Array(-78, -30).toSeq), sumAndDifferenceSeqs(Array(-97, -43), Array(-19, -13)))
        assertEquals("failure on input a = Array(-60, 13, 83), b = Array(93, 26, -97)",
            (Array(33, 39, -14).toSeq, Array(-153, -13, 180).toSeq), sumAndDifferenceSeqs(Array(-60, 13, 83), Array(93, 26, -97)))
        assertEquals("failure on input a = Array(50, 25, -9), b = Array(24, 40, 72)",
            (Array(74, 65, 63).toSeq, Array(26, -15, -81).toSeq), sumAndDifferenceSeqs(Array(50, 25, -9), Array(24, 40, 72)))
        assertEquals("failure on input a = Array(59, -23, -45), b = Array(-100, -14, -10)",
            (Array(-41, -37, -55).toSeq, Array(159, -9, -35).toSeq), sumAndDifferenceSeqs(Array(59, -23, -45), Array(-100, -14, -10)))
        assertEquals("failure on input a = Array(68, -54, -63), b = Array(5, 92, -80)",
            (Array(73, 38, -143).toSeq, Array(63, -146, 17).toSeq), sumAndDifferenceSeqs(Array(68, -54, -63), Array(5, 92, -80)))
        assertEquals("failure on input a = Array(-52, -80, -90), b = Array(-19, -62, 35)",
            (Array(-71, -142, -55).toSeq, Array(-33, -18, -125).toSeq), sumAndDifferenceSeqs(Array(-52, -80, -90), Array(-19, -62, 35)))
        assertEquals("failure on input a = Array(45, 56, -98, -66, 28), b = Array(79, 69, 85, -2, 19)",
            (Array(124, 125, -13, -68, 47).toSeq, Array(-34, -13, -183, -64, 9).toSeq), sumAndDifferenceSeqs(Array(45, 56, -98, -66, 28), Array(79, 69, 85, -2, 19)))
        assertEquals("failure on input a = Array(-45, 15, 25, 23, 83), b = Array(34, -80, -45, 31, -34)",
            (Array(-11, -65, -20, 54, 49).toSeq, Array(-79, 95, 70, -8, 117).toSeq), sumAndDifferenceSeqs(Array(-45, 15, 25, 23, 83), Array(34, -80, -45, 31, -34)))
        assertEquals("failure on input a = Array(59, 96, -28, 26, 74), b = Array(-93, -36, 98, 43, 74)",
            (Array(-34, 60, 70, 69, 148).toSeq, Array(152, 132, -126, -17, 0).toSeq), sumAndDifferenceSeqs(Array(59, 96, -28, 26, 74), Array(-93, -36, 98, 43, 74)))
        assertEquals("failure on input a = Array(-26, 64, -45, 80, 47), b = Array(-42, 45, 41, -100, 85)",
            (Array(-68, 109, -4, -20, 132).toSeq, Array(16, 19, -86, 180, -38).toSeq), sumAndDifferenceSeqs(Array(-26, 64, -45, 80, 47), Array(-42, 45, 41, -100, 85)))
        assertEquals("failure on input a = Array(46, -63, -6, 14, -34), b = Array(-70, 29, -36, -59, -91)",
            (Array(-24, -34, -42, -45, -125).toSeq, Array(116, -92, 30, 73, 57).toSeq), sumAndDifferenceSeqs(Array(46, -63, -6, 14, -34), Array(-70, 29, -36, -59, -91)))
    }

    @Test def testTask16() {
        assertEquals("failure on input Array[String]()",
            "", stringsConcatenated(Array[String]()))
        assertEquals("failure on input Array(\"\")",
            "", stringsConcatenated(Array("")))
        assertEquals("failure on input Array(\"wy\", \"y\")",
            "wyy", stringsConcatenated(Array("wy", "y")))
        assertEquals("failure on input Array(\"ww\", \"x\")",
            "wwx", stringsConcatenated(Array("ww", "x")))
        assertEquals("failure on input Array(\"yy\", \"\")",
            "yy", stringsConcatenated(Array("yy", "")))
        assertEquals("failure on input Array(\"\", \"xw\", \"yx\", \"\")",
            "xwyx", stringsConcatenated(Array("", "xw", "yx", "")))
        assertEquals("failure on input Array(\"zzy\", \"w\", \"zw\", \"\")",
            "zzywzw", stringsConcatenated(Array("zzy", "w", "zw", "")))
        assertEquals("failure on input Array(\"xwy\", \"z\", \"y\", \"\")",
            "xwyzy", stringsConcatenated(Array("xwy", "z", "y", "")))
        assertEquals("failure on input Array(\"xw\", \"wzy\", \"x\", \"\")",
            "xwwzyx", stringsConcatenated(Array("xw", "wzy", "x", "")))
        assertEquals("failure on input Array(\"wxy\", \"\", \"z\", \"\")",
            "wxyz", stringsConcatenated(Array("wxy", "", "z", "")))
        assertEquals("failure on input Array(\"yzw\", \"yzz\", \"\", \"\", \"y\", \"y\", \"wxy\", \"yzx\")",
            "yzwyzzyywxyyzx", stringsConcatenated(Array("yzw", "yzz", "", "", "y", "y", "wxy", "yzx")))
        assertEquals("failure on input Array(\"zxx\", \"ww\", \"\", \"\", \"zxw\", \"\", \"\", \"z\")",
            "zxxwwzxwz", stringsConcatenated(Array("zxx", "ww", "", "", "zxw", "", "", "z")))
        assertEquals("failure on input Array(\"y\", \"xz\", \"zyz\", \"yy\", \"yz\", \"\", \"y\", \"x\")",
            "yxzzyzyyyzyx", stringsConcatenated(Array("y", "xz", "zyz", "yy", "yz", "", "y", "x")))
        assertEquals("failure on input Array(\"xw\", \"\", \"yx\", \"z\", \"yy\", \"xyw\", \"xzy\", \"yyz\")",
            "xwyxzyyxywxzyyyz", stringsConcatenated(Array("xw", "", "yx", "z", "yy", "xyw", "xzy", "yyz")))
        assertEquals("failure on input Array(\"xwx\", \"yx\", \"yy\", \"y\", \"zz\", \"xy\", \"\", \"yzw\")",
            "xwxyxyyyzzxyyzw", stringsConcatenated(Array("xwx", "yx", "yy", "y", "zz", "xy", "", "yzw")))
    }

    @Test def testTask17() {
        assertEquals("failure on input Array[Int]()",
            Array[Int]().toSeq, runningSum(Array[Int]()))
        assertEquals("failure on input Array(-47)",
            Array(-47).toSeq, runningSum(Array(-47)))
        assertEquals("failure on input Array(-12)",
            Array(-12).toSeq, runningSum(Array(-12)))
        assertEquals("failure on input Array(-37)",
            Array(-37).toSeq, runningSum(Array(-37)))
        assertEquals("failure on input Array(-77, 8, 70)",
            Array(-77, -69, 1).toSeq, runningSum(Array(-77, 8, 70)))
        assertEquals("failure on input Array(69, 60, -97)",
            Array(69, 129, 32).toSeq, runningSum(Array(69, 60, -97)))
        assertEquals("failure on input Array(-43, -19, -13)",
            Array(-43, -62, -75).toSeq, runningSum(Array(-43, -19, -13)))
        assertEquals("failure on input Array(-60, 13, 83)",
            Array(-60, -47, 36).toSeq, runningSum(Array(-60, 13, 83)))
        assertEquals("failure on input Array(93, 26, -97)",
            Array(93, 119, 22).toSeq, runningSum(Array(93, 26, -97)))
        assertEquals("failure on input Array(50, 25, -9, 24, 40)",
            Array(50, 75, 66, 90, 130).toSeq, runningSum(Array(50, 25, -9, 24, 40)))
        assertEquals("failure on input Array(72, 59, -23, -45, -100)",
            Array(72, 131, 108, 63, -37).toSeq, runningSum(Array(72, 59, -23, -45, -100)))
        assertEquals("failure on input Array(-14, -10, 68, -54, -63)",
            Array(-14, -24, 44, -10, -73).toSeq, runningSum(Array(-14, -10, 68, -54, -63)))
        assertEquals("failure on input Array(5, 92, -80, -52, -80)",
            Array(5, 97, 17, -35, -115).toSeq, runningSum(Array(5, 92, -80, -52, -80)))
        assertEquals("failure on input Array(-90, -19, -62, 35, 45)",
            Array(-90, -109, -171, -136, -91).toSeq, runningSum(Array(-90, -19, -62, 35, 45)))
    }

    @Test def testTask18() {
        assertEquals("failure on input in = Array(-47), w = 1",
            Array(-47).toSeq, movingSum(Array(-47), 1))
        assertEquals("failure on input in = Array(-12), w = 1",
            Array(-12).toSeq, movingSum(Array(-12), 1))
        assertEquals("failure on input in = Array(-37), w = 1",
            Array(-37).toSeq, movingSum(Array(-37), 1))
        assertEquals("failure on input in = Array(-77, 8, 70), w = 2",
            Array(-69, 78).toSeq, movingSum(Array(-77, 8, 70), 2))
        assertEquals("failure on input in = Array(69, 60, -97), w = 1",
            Array(69, 60, -97).toSeq, movingSum(Array(69, 60, -97), 1))
        assertEquals("failure on input in = Array(-43, -19, -13), w = 1",
            Array(-43, -19, -13).toSeq, movingSum(Array(-43, -19, -13), 1))
        assertEquals("failure on input in = Array(-60, 13, 83), w = 2",
            Array(-47, 96).toSeq, movingSum(Array(-60, 13, 83), 2))
        assertEquals("failure on input in = Array(93, 26, -97), w = 2",
            Array(119, -71).toSeq, movingSum(Array(93, 26, -97), 2))
        assertEquals("failure on input in = Array(50, 25, -9, 24, 40), w = 1",
            Array(50, 25, -9, 24, 40).toSeq, movingSum(Array(50, 25, -9, 24, 40), 1))
        assertEquals("failure on input in = Array(72, 59, -23, -45, -100), w = 4",
            Array(63, -109).toSeq, movingSum(Array(72, 59, -23, -45, -100), 4))
        assertEquals("failure on input in = Array(-14, -10, 68, -54, -63), w = 4",
            Array(-10, -59).toSeq, movingSum(Array(-14, -10, 68, -54, -63), 4))
        assertEquals("failure on input in = Array(5, 92, -80, -52, -80), w = 3",
            Array(17, -40, -212).toSeq, movingSum(Array(5, 92, -80, -52, -80), 3))
        assertEquals("failure on input in = Array(-90, -19, -62, 35, 45), w = 1",
            Array(-90, -19, -62, 35, 45).toSeq, movingSum(Array(-90, -19, -62, 35, 45), 1))
    }
}


