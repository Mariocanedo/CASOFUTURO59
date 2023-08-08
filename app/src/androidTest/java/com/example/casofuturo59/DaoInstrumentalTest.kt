package com.example.casofuturo59

import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.casofuturo59.Modelo.local.CentroFuturoDao
import com.example.casofuturo59.Modelo.local.database.CoursesDataBase
import com.example.casofuturo59.Modelo.local.entities.CoursesDetailEntity
import com.example.casofuturo59.Modelo.local.entities.CoursesEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering.Context


@RunWith(AndroidJUnit4::class)
class DaoInstrumentalTest {

private lateinit var centroFuturoDao: CentroFuturoDao
private lateinit var db: CoursesDataBase

@Before
fun setUp(){
    val context= ApplicationProvider.getApplicationContext<android.content.Context>()
    db= Room.inMemoryDatabaseBuilder(context,CoursesDataBase::class.java).build()
    centroFuturoDao= db.getCentroFuturoDao()
}

@After
fun shutDown(){
    db.close()

}


@Test
fun insertCoursesList() = runBlocking {

    val coursesEntity= listOf(
        CoursesEntity ("43","prueba","test1","url",4, "March"),
        CoursesEntity ("44","prueba2","test2","url",4, "March")

    )

    centroFuturoDao.insertAllCourses(coursesEntity)

    val coursesLiveData = centroFuturoDao.getAllCourses()
    val coursesList : List<CoursesEntity> = coursesLiveData.value?: emptyList()

    // verificamos el listado
    // verificamos el listado si no es vacio
    assertThat(coursesList, not(emptyList()))
    assertThat(coursesList.size,equalTo(2))


}



@Test
fun inserDetailCourse()= runBlocking {

    val coursesDetail = CoursesDetailEntity(

        "2",
        "Curso 2",
        "Test2",
        "url",
        4,
        "...",
        "Expert",
        true,
        "remote",
        "ahora"

    )

    centroFuturoDao.insertCourseDetail(coursesDetail)
     val courseLiveData= centroFuturoDao.getCourseDetailById("2")
     val courseValue= courseLiveData.value

    assertThat(courseValue?.id, equalTo("2"))
    assertThat(courseValue?.weeks, equalTo("ahora"))

}







}