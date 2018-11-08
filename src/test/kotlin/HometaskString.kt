import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

class StringSpec : DescribeSpec({
    describe("Checks for HometaskString") {
        context("releaseTesting ") {
            it("testing the isUnique function") {
                isUnique("swift", "ftswi", 2) shouldBe true
                isUnique("swift", "ftswi", 5) shouldBe false // no rotation
                isUnique("swift", "ftswi", 0) shouldBe false // no rotation
                isUnique("Temirlan", "lanTemir", 3) shouldBe true
                isUnique("Temirlan", "nTemirla", 1) shouldBe true
            }
        }
    }

})

fun isUnique(word: String, rotatedWord: String, rotatedBy: Int): Boolean {
    if (word.length > rotatedBy || word.length == rotatedWord.length || rotatedBy < 1) {
        val tmp = word.substring(word.length - rotatedBy) + word.substring(0, word.length - rotatedBy)
        return tmp.equals(rotatedWord)
    }
    return false
}