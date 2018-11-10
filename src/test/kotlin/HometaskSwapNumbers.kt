import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

class SwapNumbersSpec : DescribeSpec({
    describe("Checks for SwapNumbers") {
        context("releaseTesting ") {
            var nums = arrayOf(0,1,2,30,40,11333,13,-1,-3, Int.MAX_VALUE+1, Int.MIN_VALUE-1)
            it("Swapping") {
                swapTwoInt(nums[0],nums[1]) shouldBe arrayOf(nums[1],nums[0])
                swapTwoInt(nums[1],nums[2]) shouldBe arrayOf(nums[2],nums[1])
                swapTwoInt(nums[3],nums[4]) shouldBe arrayOf(nums[4],nums[3])
                swapTwoInt(nums[5],nums[6]) shouldBe arrayOf(nums[6],nums[5])
                swapTwoInt(nums[7],nums[8]) shouldBe arrayOf(nums[8],nums[7])
                swapTwoInt(nums[9],nums[10]) shouldBe arrayOf(nums[10],nums[9])

            }

        }
    }

})

fun swapTwoInt(a: Int, b:Int): Array<Int> {
    var a=a+b // i don't like it, but fun parameters are val
    var b=a-b
    a=a-b
    return arrayOf(a,b)
}
