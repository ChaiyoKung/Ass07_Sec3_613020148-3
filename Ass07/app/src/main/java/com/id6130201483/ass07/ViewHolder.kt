package com.id6130201483.ass07

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.emp_item_layout.view.*

class ViewHolder(v: View):RecyclerView.ViewHolder(v) {
    val text_name = v.text_name
    val text_gender = v.text_gender
    val text_email = v.text_email
    val text_salary = v.text_salary
}