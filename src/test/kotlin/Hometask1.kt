import io.kotlintest.matchers.numerics.shouldBeGreaterThan
import io.kotlintest.matchers.numerics.shouldBeLessThan
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.DescribeSpec

class HometaskSpec : DescribeSpec({
    describe("Checks for hometask") {
        context("functions") {
            it("checking the mul function") {
                val a = 1
                val b = 2
                val c = 0
                mul(a, b) shouldBe 2
                mul(a, c) shouldNotBe 1
            }

            it("checking swithcase") {
                var scores = arrayOf(10, 100, 90, 70)
                swithcase(scores[0]) shouldNotBe "Excellent"
                swithcase(scores[1]) shouldBe "Excellent"
                swithcase(scores[2]) shouldBe "Good"
                swithcase(scores[3]) shouldBe "Fail"

            }

            it("checking collections") {
                var items = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
                var items2 = listOf(1, 2, 0, 4, 5, 6, 7, 8, 9)
                collectionSum(items) shouldBeLessThan 100
                collectionSum(items) shouldBe 45
                collectionSum(items2) shouldBeGreaterThan 0
            }

            it("Sorting an array") {
                var items = arrayOf(9, 2, 7, 4, 3, 6, 7, 10, 9)
                var items2 = arrayOf(2, 3, 4, 6, 7, 7, 9, 9, 10)
                var items3 = arrayOf(9, 2, 7, 4, 3, 6, 7, 10, 9)
                kotlinSort(items) shouldBe items2
                kotlinSort(items) shouldNotBe items3
                kotlinSort(items) shouldBe selfBubbleSort(items)
                selfBubbleSort(items) shouldNotBe items3
            }
        }
    }

})

fun mul(a: Int, b: Int) = a * b

fun swithcase(score: Int): String {
    var grade = when (score) {
        in 95..100 -> "Excellent"
        in 90..94 -> "Good"
        in 75..89 -> "Ok"
        else -> "Fail"
    }
    return grade
}

fun collectionSum(items: List<Int>): Int {
    var sum = 0
    for (it in items) {
        sum += it
    }
    return sum
}

fun kotlinSort(items: Array<Int>): Array<Int> = items.sortedArray()

fun selfBubbleSort(items: Array<Int>): Array<Int> {
    var tmp: Int
    var itemsLength = items.size-1
    for (i in 0..itemsLength) {
        for (j in 1..(itemsLength - i)) {
            if (items[j - 1] > items[j]) {
                tmp = items[j - 1]
                items[j - 1] = items[j]
                items[j] = tmp
            }
        }
    }
    return items
}
