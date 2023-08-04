package com.example.casofuturo59.Modelo.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="course_detail_table")
class CoursesDetailEntity(

    @PrimaryKey
    val id : String,
    val title: String,
    val previewDescription: String,
    val image: String,
    val weeks: Int,
    val tuition : String,
    val minimumSkill : String,
    val scholarshipAvailable: Boolean,
    val modality : String,
    val star : String


)