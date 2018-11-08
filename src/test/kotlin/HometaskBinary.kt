import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

class BinarySpec : DescribeSpec({
    describe("Checks for HometaskBinary") {
        context("releaseTesting ") {
            var a = 110110111L
            var b = 110110110L

            it("Binary to Int checking") {
                binaryToInt(a) shouldBe 439
                binaryToInt(0L) shouldBe 0
                binaryToInt(111L) shouldBe 7
            }
            it("Int to Binary checking") {
                intToBinary(439) shouldBe a
                intToBinary(0) shouldBe 0L
                intToBinary(7) shouldBe 111L
            }
            it("Sum") {
                binarySum(a,b) shouldBe 1101101101
                binarySum(111L,11L) shouldBe 1010
            }
        }
    }

})

fun binarySum(a:Long,b:Long): Long {
    var sumInt=binaryToInt(a)+binaryToInt(b)
    return intToBinary(sumInt)
}

fun binaryToInt(a:Long) :Int {
    var num = a
    var decimalNumber = 0
    var i = 0
    var remainder: Long

    while (num.toInt() != 0) {
        remainder = num % 10
        num /= 10
        decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
        ++i
    }
    return decimalNumber
}

fun intToBinary(a:Int):Long{
    var n = a
    var binaryNumber: Long = 0
    var remainder: Int
    var i = 1

    while (n != 0) {
        remainder = n % 2
        n /= 2
        binaryNumber += (remainder * i).toLong()
        i *= 10
    }
    return binaryNumber
}
