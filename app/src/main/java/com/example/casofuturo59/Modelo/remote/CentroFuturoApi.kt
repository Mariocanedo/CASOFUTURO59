package com.example.casofuturo59.Modelo.remote

import com.example.casofuturo59.Modelo.remote.frominternet.CourseDetail
import com.example.casofuturo59.Modelo.remote.frominternet.Courses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CentroFuturoApi {




    @GET("courses")
    suspend fun fetchCourseList(): Response<List<Courses>>



    @GET("courses/{id}")
    suspend fun fetchCourseDetail(@Path("id") id:String) : Response<CourseDetail>














}