package com.example.casofuturo59.Modelo.remote.frominternet

data class CourseDetail (
    val id : String,
    val title: String,
    val previewDescription: String,
    val image: String,
    val weeks: Int,
    val tuition : String,
    val minimulSkill : String,
    val scholarshipAvailable: Boolean,
    val modality : String,
    val star : String
        )