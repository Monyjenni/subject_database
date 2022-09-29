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

    //how can we edit on this tempList
    @GetMapping ("professors/ranks")
    fun getRanks (): List<Field>{
        val tempList = scienceDepList.toList().toMutableList()

        tempList.addAll(socialDepList)

        return tempList.sortedByDescending { it.rank}
    }

    @GetMapping ("/professors")
    fun getPro(): List<Field> {
        return profList

    }


    @PostMapping ("/post")
    fun postProf (@RequestBody name: Field) : List <Field>{
        profList = profList.plus(name)

        return profList

    }

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

//    @PutMapping ("/professors/put/ranking/{id}")
//    fun updateProf (@PathVariable id:Int, @RequestBody professor: Field) : String {
//        val findProf =
//    }

}

data class Response (
    val data: List <Field>,
    val message: String
        )