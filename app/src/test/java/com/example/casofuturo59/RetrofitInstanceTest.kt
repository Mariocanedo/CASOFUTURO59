package com.example.casofuturo59

import android.os.Build
import com.example.casofuturo59.Modelo.remote.RetrofitClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory





class RetrofitInstanceTest {


    private lateinit var mockWebServer: MockWebServer


    @Before
    fun setUp(){
        mockWebServer= MockWebServer()
    }

    @After
    fun tearDown(){

        mockWebServer.shutdown()

    }

    @Test
        fun testRetrofit(){


        val expectedBaseUrl= mockWebServer.url("/").toString()


        val retrofit = Retrofit.Builder()
            .baseUrl(expectedBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // asignar la instancia real de retofit a la propiedad retrofitIntance de Retrofitcliente

        RetrofitClient.retrofitInstance=retrofit
        val retrofitInstace = RetrofitClient.retrofitInstance
       assertEquals(expectedBaseUrl, retrofitInstace.baseUrl().toString())
    }



}