package com.example.casofuturo59.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.casofuturo59.Modelo.local.entities.CoursesEntity
import com.example.casofuturo59.databinding.CoursesListBinding


class CoursesAdapter : RecyclerView.Adapter<CoursesAdapter.CourseVH>(){

    // referencia para el adapter
    private var listCourses= listOf<CoursesEntity>()
    private  val selectedCourse= MutableLiveData<CoursesEntity>()

    fun update (list:List<CoursesEntity>){
        listCourses= list
        notifyDataSetChanged()
    }


    inner class CourseVH(private  val mbinding : CoursesListBinding):
            RecyclerView.ViewHolder(mbinding.root), View.OnClickListener{

                fun bind(course: CoursesEntity){

                    Glide.with(mbinding.ivLogo).load(course.image).centerCrop().into(mbinding.ivLogo)
                    mbinding.tvname.text= course.title
                    mbinding.tvdescription.text= course.previewDescription
                    mbinding.tvduration.text= "duración:"+ course.weeks.toString()+"Semanas"
                    mbinding.tvstart.text= "Inicio:" + course.star
                    itemView.setOnClickListener(this)

                }
        override fun onClick(v:View) {
            // referencia a la selección
            selectedCourse.value= listCourses[adapterPosition]
        }

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseVH {
     return CourseVH(CoursesListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = listCourses.size


    override fun onBindViewHolder(holder: CourseVH, position: Int) {
       val course= listCourses[position]
        holder.bind(course)
    }


}