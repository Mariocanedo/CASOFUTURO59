package com.example.casofuturo59.Modelo

import com.example.casofuturo59.Modelo.local.entities.CoursesDetailEntity
import com.example.casofuturo59.Modelo.local.entities.CoursesEntity
import com.example.casofuturo59.Modelo.remote.frominternet.CourseDetail
import com.example.casofuturo59.Modelo.remote.frominternet.Courses


fun fromInternetCoursesEntity( cousesList: List<Courses>) :List<CoursesEntity>{

    return cousesList.map {
        CoursesEntity(
            id=it.id,
            title= it.title,
            previewDescription = it.previewDescription,
            image = it.image,
            weeks = it.weeks,
            star= it.star
        )

    }


}


fun fromInternetCourseDetailEntity( course: CourseDetail) :CoursesDetailEntity{

    return CoursesDetailEntity(
            id=course.id,
            title= course.title,
            previewDescription = course.previewDescription,
            image = course.image,
            weeks = course.weeks,
        tuition = course.tuition,
        minimulSkill = course.minimulSkill,
        scholarshipAvailable = true,
        modality = course.modality,
        star= course.star
        )

    }







