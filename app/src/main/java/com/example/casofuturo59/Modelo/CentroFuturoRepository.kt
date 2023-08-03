package com.example.casofuturo59.Modelo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.casofuturo59.Modelo.local.CentroFuturoDao
import com.example.casofuturo59.Modelo.local.entities.CoursesDetailEntity
import com.example.casofuturo59.Modelo.remote.RetrofitClient
import retrofit2.Retrofit

class CentroFuturoRepository( private val centroFuturoDao: CentroFuturoDao) {


    // retrofit Cliente

    private val networkService = RetrofitClient.retrofitInstance()

    // dao listado
     val coursesListLiveData = centroFuturoDao.getAllCourses()

    // un elemento

    val courseDetailLiveData= MutableLiveData<CoursesDetailEntity>()




    suspend fun fetchCourse(){
        val service = kotlin.runCatching { networkService.fetchCourseList() }

        service.onSuccess {
            when (it.code()){
                in 200..299 ->it.body()?.let {

                   centroFuturoDao.insertAllCourses(fromInternetCoursesEntity(it))

                }
                else-> Log.d("Repo","${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("Error", "${it.message}")
            }

        }
        
    }


    suspend fun fetchCourseDetail(id: String): CoursesDetailEntity?{
        val service = kotlin.runCatching { networkService.fetchCourseDetail(id) }
        return service.getOrNull()?.body()?.let { courseDetail ->
            // guardp los datos que viene del mapper y luego se los paso a dao directo
            val courseDetailEntity = fromInternetCourseDetailEntity(courseDetail)
            //inserto los detalles de los curso DEL REPOSITORIO
            centroFuturoDao.insertCourseDetail(courseDetailEntity)
            courseDetailEntity
        }
    }











}