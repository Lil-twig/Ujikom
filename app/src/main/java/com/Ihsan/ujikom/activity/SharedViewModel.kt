package com.Ihsan.ujikom.activity

import android.app.Application
import android.renderscript.RenderScript
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.Ihsan.ujikom.R
import com.Ihsan.ujikom.data.Priority
import com.Ihsan.ujikom.model.ToDoData

class SharedViewModel(application: Application): AndroidViewModel(application) {

    val emptyDatabase:MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkDatabaseEmpty(toDoData: List<ToDoData>){
        emptyDatabase.value = toDoData.isEmpty()

    }

    val listener:AdapterView.OnItemSelectedListener = object :AdapterView.OnItemSelectedListener{

        override fun onNothingSelected(p0: AdapterView<*>?) {}

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            when(position){
                0->{(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.red))}
                1->{(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.yellow))}
                2->{(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.green))}
            }

        }


    }

    fun verifyDataFromUSer(title: String, description: String):Boolean{
        return !(title.isEmpty()||description.isEmpty())

    }

    fun parsePriority(priority: String): Priority {
        return when(priority){
            "High Priority" ->{
                Priority.HIGH
            }
            "Medium Priority"->{
                Priority.MEDIUM
            }
            "Low Priority"->{
                Priority.LOW
            } else -> Priority.LOW

        }
    }


}