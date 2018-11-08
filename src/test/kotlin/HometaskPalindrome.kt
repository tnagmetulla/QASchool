import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

class PalindromeSpec : DescribeSpec({
    describe("Checks for HometaskPalindrome") {
        context("releaseTesting ") {
            var numbers = arrayOf(121,0,131,555555,4554,1,11333,13)
            it("First way") {
                isPalindromeFirstWay(numbers[0]) shouldBe true
                isPalindromeFirstWay(numbers[1]) shouldBe true
                isPalindromeFirstWay(numbers[2]) shouldBe true
                isPalindromeFirstWay(numbers[3]) shouldBe true
                isPalindromeFirstWay(numbers[4]) shouldBe true
                isPalindromeFirstWay(numbers[5]) shouldBe true
                isPalindromeFirstWay(numbers[6]) shouldBe false
                isPalindromeFirstWay(numbers[7]) shouldBe false

            }
            it("Second way") {
                isPalindromeSecondWay(numbers[0]) shouldBe true
                isPalindromeSecondWay(numbers[1]) shouldBe true
                isPalindromeSecondWay(numbers[2]) shouldBe true
                isPalindromeSecondWay(numbers[3]) shouldBe true
                isPalindromeSecondWay(numbers[4]) shouldBe true
                isPalindromeSecondWay(numbers[5]) shouldBe true
                isPalindromeSecondWay(numbers[6]) shouldBe false
                isPalindromeSecondWay(numbers[7]) shouldBe false
            }
        }
    }

})

fun isPalindromeFirstWay(number: Int): Boolean {
    if (number < 0) return false
    val reversedNumber = number.toString().reversed().toInt()
    return number == reversedNumber
    }

fun isPalindromeSecondWay(number: Int): Boolean {
    if (number < 0) return false
    var reversedNumber = 0
    var numberCopy=number
    var digit:Int
    while(numberCopy!=0){
        digit = numberCopy%10
        reversedNumber=reversedNumber*10+digit
        numberCopy/=10
    }
    return number == reversedNumber
}
