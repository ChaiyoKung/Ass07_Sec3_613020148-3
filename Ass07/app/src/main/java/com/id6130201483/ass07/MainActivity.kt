package com.id6130201483.ass07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*

class MainActivity : AppCompatActivity() {
    private val employeeList = arrayListOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_addEmployee.setOnClickListener() {
            addEmployee(it)
        }

        testEmployeeData()

        showRecyclerViewItem()
    }

    private fun showRecyclerViewItem() {
        recycler_view.adapter = EmployeeAdapter(this.employeeList, applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun testEmployeeData() {
        employeeList.add(Employee("Danny", "Male", "danny@kku.ac.th", 30000))
        employeeList.add(Employee("Sara", "Female", "sara@kku.ac.th", 34000))
    }

    private fun addEmployee(v: View) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)

        val alertDialog = builder.show()

        alertDialog.btn_add.setOnClickListener() {
            add(alertDialog)
            alertDialog.dismiss()
        }

        alertDialog.btn_cancel.setOnClickListener() {
            alertDialog.dismiss()
        }
    }

    private fun add(dialog: AlertDialog) {
        val name = getName(dialog)
        val gender = getGender(dialog)
        val email = getEmail(dialog)
        val salary = getSalary(dialog)

        print(":::::: $name $gender $email $salary")

        employeeList.add(Employee(name, gender, email, salary))

        recycler_view.adapter?.notifyDataSetChanged()
        Toast.makeText(applicationContext, "Added employee success", Toast.LENGTH_SHORT).show()
    }

    private fun getName(dialog: AlertDialog): String {
        return dialog.edit_name.text.toString()
    }

    private fun getGender(dialog: AlertDialog): String {
        val radioSelectedID = dialog.radio_gender.checkedRadioButtonId
        val radioSelected = dialog.findViewById<RadioButton>(radioSelectedID)
        return radioSelected?.text.toString()
    }

    private fun getEmail(dialog: AlertDialog): String {
        return dialog.edit_email.text.toString()
    }

    private fun getSalary(dialog: AlertDialog): Int {
        return dialog.edit_salary.text.toString().toInt()
    }
}