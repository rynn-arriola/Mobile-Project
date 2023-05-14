package com.example.mobileapplicationproject.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.mobileapplicationproject.adapter.viewholder.EmployeeViewHolder
import com.example.mobileapplicationproject.model.response.Employee

class EmployeeAdapter : ListAdapter<Employee, EmployeeViewHolder>(diffUtilItemCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = EmployeeViewHolder.newInstance(parent)

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {

        private val diffUtilItemCallback = object : DiffUtil.ItemCallback<Employee>() {
            override fun areItemsTheSame(
                oldItem: Employee, newItem: Employee
            ) = oldItem.uuid == newItem.uuid

            override fun areContentsTheSame(
                oldItem: Employee, newItem: Employee
            ) = oldItem.uuid == newItem.uuid
        }
    }
}