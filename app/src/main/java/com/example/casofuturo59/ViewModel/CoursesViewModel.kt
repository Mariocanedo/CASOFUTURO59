package com.example.casofuturo59.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.casofuturo59.Modelo.CentroFuturoRepository
import com.example.casofuturo59.Modelo.local.database.CoursesDataBase
import com.example.casofuturo59.Modelo.local.entities.CoursesDetailEntity
import com.example.casofuturo59.Modelo.local.entities.CoursesEntity
import kotlinx.coroutines.launch


class CoursesViewModel(application: Application) : AndroidViewModel(application){

    // conexión repository

    private val repository : CentroFuturoRepository

    // entidades

    private val courseDetailLiveData = MutableLiveData<CoursesDetailEntity>()

    // para seleccionar
    private var idSelected : String="-1"




    init{
        // tiene la instancia de la bd el dao y lo entregamos el repository
        val bd= CoursesDataBase.getDataBase(application)
        val centrofuturoDao= bd.getCentroFuturoDao()

        repository = CentroFuturoRepository(centrofuturoDao)

       // llamo al método del repository

       viewModelScope.launch {
           repository.fetchCourse()
       }
    }

    // listado de los elementos

    fun getCoursesList(): LiveData<List<CoursesEntity>> = repository.coursesListLiveData

    // para obtener un curso por id desde lo que se selecciono

    fun getCourseDetail(): LiveData<CoursesDetailEntity> = courseDetailLiveData


    // desde el segundo fragmento le paso la seleccion
    fun getCourseDetailByIdFromInternet(id: String)= viewModelScope.launch {


        val courseDetail = repository.fetchCourseDetail(id)
        courseDetail?.let {

            courseDetailLiveData.postValue(it)
        }

    }



}