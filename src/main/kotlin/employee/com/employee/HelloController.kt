package employee.com.employee

import jdk.jfr.Category
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping ("/jen")
class HelloController {


    @GetMapping("/welcome")
    fun getAllresponse (): String{
        return "Hi"
    }

    val proInfo1Programming = ProfessorInfo(1,"Richard", "Lai",12345)
    val proInfo2OOP = ProfessorInfo(2,"Tat", "Lee",123456)
    val proInfo3Electronic = ProfessorInfo(3,"JK", "William",1234567)
    val proInfo4Business =ProfessorInfo(4,"Pishen", "Seet",12345678)
    val proInfo5Ethics = ProfessorInfo(5,"Yuki", "Sato",123456789)
    val proInfo6Marketing = ProfessorInfo(6,"Karla", "Sato",1234567891)


    var socialDepList = mutableListOf(
        Field(4,"Business",5,proInfo4Business),
        Field(5,"Ethics",6,proInfo5Ethics),
        Field(6,"Marketing",4,proInfo6Marketing)
    )

    var scienceDepList = mutableListOf(
        Field(1,"Programming",1,proInfo1Programming),
        Field(2,"OOP",2,proInfo2OOP),
        Field (3,"Electronic",3,proInfo3Electronic)

    )

    var profList = scienceDepList + socialDepList

    val helloWorld = "Hello World!"

    //how can we edit on this tempList
    @GetMapping ("professors/ranks")
    fun getRanks (): List<Field>{
        val tempList = scienceDepList.toList().toMutableList()

        tempList.addAll(socialDepList)

        //val myList: MutableList<String> = ArrayList()
        var myList = tempList.toMutableList()

        return tempList.sortedByDescending { it.rank}
    }

    @GetMapping ("/professors")
    fun getPro(): List<Field> {
        return profList

    }

    @GetMapping ("professors/{professorInfoId}")
    fun getProfbyId (@PathVariable ("professorInfoId") professorInfoId:Int ): String {
        val kru = profList.find{it.id == professorInfoId}

        var isIdFound = false

        for (id in profList)
            if (id.id == professorInfoId){
                isIdFound = true
            }
        if (isIdFound){
            return Message (
                data = profList,

                message = "found "
            ).toString()

        }else {
            return Message (
                data = profList,
                //message = profList.toString() + "not found "
                    //).toString()
                message = "has not found").toString()
        }
    }

//    @GetMapping("/categories/{id}")
//    fun getAllBooksByCategory(@PathVariable("id") categoryId: Int): Total{
//        val foundBooks = bookList.filter { it.categorize.id == categoryId }
//
//
//
//        //println("There is total ${foundBooks.count()} books")
//
//        return Total(
//            data = foundBooks,
//            message = "The total is ${foundBooks.count()}"
//        )
//    }


    @PostMapping ("/post")
    fun postProf (@RequestBody name: Field) : List <Field>{
        profList = profList.plus(name)

        return profList

    }

//    @PostMapping ("/post/ranks")
//    fun postProfRank (@RequestBody name: Field) : List <Field>{
//        myList = myList.plus(name)
//
//        return myList
//
//    }

    @DeleteMapping ("professors/delete/{id}")
    fun deletePro (@PathVariable id:Int): String{
        return "Delete Successfully"
    }

    @PutMapping("/professors/put/{id}")
    fun updatePro (@PathVariable id:Int, @RequestBody professor:Field) : String{
        val findPro = profList.find{it -> it.id == id}

        if(findPro != null){
            val newList = profList.filter { it.id != id }.plus(professor)
            profList = newList.toMutableList()
            return "Professor has been updated"
        }else {
            return "Professor hasn't found"
        }


    }


}
data class Message (
    val data : List<Field>?,
    val message : String
        )

data class Response (
    val data: List <Field>,
    val message: String
        )


