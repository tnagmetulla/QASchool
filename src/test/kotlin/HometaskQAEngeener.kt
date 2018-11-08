import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

class EngeenerSpec : DescribeSpec({
    describe("Checks for hometaskQAEngeneer") {
        context("releaseTesting ") {
            val developer = Developer()
            val qa=QA()
            var currentTasks=HashMap<Int,String>()
            currentTasks.put(1,"Some Task")
            it ("testing the work and release testing functions"){
                developer.work(2,currentTasks)
                developer.work(6,currentTasks)
                println(currentTasks)
                qa.work(6,currentTasks)
                println(currentTasks)
                qa.releaseTesting(2.0,currentTasks) shouldBe true
            }
        }
    }

})

open class Engeener(){
    var name:String =""
    var department: String=""

    open fun work(capacity: Int, currentTasks: HashMap<Int,String>){
    }
}

class Developer:Engeener(){

    override fun work(capacity: Int, currentTasks: HashMap<Int,String>){
        for (i in 1..capacity){
            currentTasks.put(i,"New task "+i.toString())
        }
    }
}
class QA :Engeener(){
    fun releaseTesting(releaseDate: Double, featuresList: HashMap<Int,String> ): Boolean {
        return ((featuresList.size-1.toDouble())/2.0) <= releaseDate
    }
    override fun work(capacity: Int, currentTasks: HashMap<Int,String>){
        var workHours=capacity
        var array = ArrayList<Int>()
        for (key in currentTasks.keys) {
            if (workHours <= 0) break
            if (workHours >= key) {
                array.add(key)
                workHours-=key
            }
        }
        for (i in array) {
            currentTasks.remove(i)
        }

    }
}
