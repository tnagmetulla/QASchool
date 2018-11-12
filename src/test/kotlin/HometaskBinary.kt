import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

class BinarySpec : DescribeSpec({
    describe("Checks for HometaskBinary") {
        context("releaseTesting ") {
            var a = arrayOf("110110111","110110110","0","111","11","1","10")

            it("Binary to Int checking") {
                binaryToInt(a[0]) shouldBe 439
                binaryToInt(a[2]) shouldBe 0
                binaryToInt(a[3]) shouldBe 7
                binaryToInt(a[4]) shouldBe 3
                binaryToInt(a[5]) shouldBe 1
                binaryToInt(a[6]) shouldBe 2
                binaryToInt("a") shouldBe 0
                binaryToInt("") shouldBe 0



            }
            it("Int to Binary checking") {
                intToBinary(439) shouldBe 110110111
                intToBinary(0) shouldBe 0
                intToBinary(1) shouldBe 1
                intToBinary(2) shouldBe 10
                intToBinary(7) shouldBe 111
            }
            it("Sum") {
                binarySum(a[0],a[1]) shouldBe "1101101101"
                binarySum(a[3],a[4]) shouldBe "1010"
                binarySum(a[2],a[2]) shouldBe "0"
                binarySum(a[5],a[6]) shouldBe "11"
                binarySum(a[2],a[5]) shouldBe "1"
                binarySum("afaf","") shouldBe "0"
            }
        }
    }

})

fun binarySum(a:String,b:String): String {
    var sumInt=binaryToInt(a)+binaryToInt(b)
    return intToBinary(sumInt).toString()
}

fun binaryToInt(a:String) :Int {
    var num:Long
    try{
         num = a.toLong()
    } catch (e: NumberFormatException){ return 0 }

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
