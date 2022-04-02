package com.Ihsan.ujikom.adapter

import android.view.View
import android.widget.Spinner
import androidx.cardview.widget.CardView
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.Ihsan.ujikom.R
import com.Ihsan.ujikom.data.Priority
import com.Ihsan.ujikom.model.ToDoData
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BindingAdapters  {

//    companion object{
//
//        @BindingAdapter("android:navigateToAddFragment")
//        @JvmStatic
//        fun navigateToAddFragment(view: FloatingActionButton, navigate:Boolean){
//
//            view.setOnClickListener {
//                if (navigate) view.findNavController().navigate(R.id.action_listFragment2_to_addFragment2)
//            }
//
//        }
//
//        @BindingAdapter("android:emptyDatabase")
//        @JvmStatic
//        fun emptyDatabase(view: View, emptyDatabase: MutableLiveData<Boolean>){
//            when(emptyDatabase.value){
//                true -> view.visibility = View.VISIBLE
//                else -> view.visibility = View.INVISIBLE
//            }
//        }
//
//        @BindingAdapter("android:parsePriorityColor")
//        @JvmStatic
//        fun parsePriorityColor(cardView: CardView, priority: Priority){
//            when(priority){
//                Priority.HIGH -> {cardView.setBackgroundColor(cardView.context.getColor(R.color.red))}
//                Priority.MEDIUM -> {cardView.setBackgroundColor(cardView.context.getColor(R.color.yellow))}
//                Priority.LOW -> {cardView.setBackgroundColor(cardView.context.getColor(R.color.green))}
//
//
//            }
//        }
//
//        @BindingAdapter("android:parsePriorityToInt")
//        @JvmStatic
//        fun parsePriorityToInt(view: Spinner, priority: Priority){
//            when(priority){
//                Priority.HIGH ->{view.setSelection(0)}
//                Priority.MEDIUM ->{view.setSelection(1)}
//                Priority.LOW ->{view.setSelection(2)}
//            }
//        }
//
//        @BindingAdapter("android:sendDataToUpdateFragment")
//        @JvmStatic
//        fun sendDataToUpdateFragment(view: CardView, currentItem: ToDoData){
//            view.setOnClickListener {
//                val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
//                view.findNavController().navigate(action)
//            }
//        }
//
//    }

}