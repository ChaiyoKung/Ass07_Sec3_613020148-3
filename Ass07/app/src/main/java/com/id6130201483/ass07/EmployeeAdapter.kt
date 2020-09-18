package com.id6130201483.ass07

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(val item: List<Employee>, val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem =
            LayoutInflater.from(parent.context).inflate(R.layout.emp_item_layout, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text_name.text = item[position].name
        holder.text_gender.text = item[position].gender
        holder.text_email.text = item[position].email
        holder.text_salary.text = item[position].salary.toString()
    }

    override fun getItemCount(): Int {
        return item.size
    }
}