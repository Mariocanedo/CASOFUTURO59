package com.example.casofuturo59

import com.example.casofuturo59.Modelo.local.entities.CoursesEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class TestCoursesEntity {


    private lateinit var  coursesEntity: CoursesEntity

    @Before
    fun setup(){

        coursesEntity = CoursesEntity(
            id="1",
            title="Prueba 059",
            previewDescription = "Prueba test",
            image = "image",
            weeks = 2,
            star="Agosto 2023"

        )

    }


@After
fun tearDown(){

    // acciones de limpieza y liberación de recursos
}



    @Test

 fun testCourseConstructor(){
     // verificar que los valores asignados en el constructor sean correctos

     assert(coursesEntity.id=="1")
     assert(coursesEntity.title=="Prueba 059")
        assert(coursesEntity.previewDescription=="Prueba test")
        assert(coursesEntity.image=="image")
        assert(coursesEntity.weeks==2)
        assert(coursesEntity.star=="Agosto 2023")
 }




}