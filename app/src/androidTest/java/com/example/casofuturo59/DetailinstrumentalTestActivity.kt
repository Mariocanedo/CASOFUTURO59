package com.example.casofuturo59

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.casofuturo59.View.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DetailinstrumentalTestActivity {


    @Test
    fun testMostrarValidateCourses() {

        // crear Un Intent simulado con los datos de un Course

        val context =
            androidx.test.platform.app.InstrumentationRegistry.getInstrumentation().targetContext
        val intent = Intent(context, MainActivity::class.java)

        intent.putExtra("id", "1")
        intent.putExtra("nombre", "Course the Testing")
        intent.putExtra("Description", "Testing App")
        intent.putExtra("Image", "img")
        intent.putExtra("Duration", 4)
        intent.putExtra("tuition", "...")
        intent.putExtra("minimumSkillD", "developer")
        intent.putExtra("scholarshipAvailable", true)
        intent.putExtra("modality", "online")
        intent.putExtra("star", "now")

        // Iniciar la actividad bajo prueba con el Intent simulado
        val activityScenario = ActivityScenario.launch<MainActivity>(intent)

        // Esperar hasta que se inicie la actividad y esté lista para ser utilizada

        activityScenario.onActivity {activity ->

            // verficamos que la actividad no sea null

            assertNotNull(activity)

            // Verificar que los datos del Intent se muestran correctamente en la actividad

            assertEquals("1",activity.intent.getStringExtra("id",))
            assertEquals("Course the Testing",activity.intent.getStringExtra("nombre",))
            assertEquals("Testing App",activity.intent.getStringExtra("Description",))
            assertEquals("img",activity.intent.getStringExtra("Image",))
            assertEquals(4,activity.intent.getIntExtra("Duration",-1))
            assertEquals("...",activity.intent.getStringExtra("tuition",))
            assertEquals("developer",activity.intent.getStringExtra("minimumSkillD",))
            assertEquals(true,activity.intent.getBooleanExtra("scholarshipAvailable",false))
            assertEquals("online",activity.intent.getStringExtra("modality",))
            assertEquals("now",activity.intent.getStringExtra("star",))
        }


    }



}