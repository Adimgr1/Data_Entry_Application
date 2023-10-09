package com.aditya.data_entry

import android.app.Dialog
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.WindowManager.LayoutParams
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
     lateinit var img :ImageView
    lateinit var rv: RecyclerView
    lateinit var floatbtn1: FloatingActionButton
   lateinit var name1 :EditText
    lateinit var number: EditText
     lateinit var add :Button
      private val a = mutableListOf<item_content>()
    private lateinit var contactAdapter: listAdapter
    lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv= findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        contactAdapter= listAdapter(a)

        floatbtn1=findViewById(R.id.floatbtn1)
        floatbtn1.setOnClickListener {
            showDialog()
        }
        }


    private fun showDialog(){
        dialog =Dialog(this)

        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialogbox)
        dialog.window?.setLayout(1000,1000)
         name1 = dialog.findViewById(R.id.dialogedt1)
         number = dialog.findViewById(R.id.dialogedt2)
        val chooseImage:Button = dialog.findViewById(R.id.chooseImage)
        add = dialog.findViewById(R.id.addContact)
         img= dialog.findViewById(R.id.img)
        chooseImage.setOnClickListener {
            val a = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(a,100)
        }
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode ==100 && resultCode == RESULT_OK){
            img.visibility= View.VISIBLE
            img.setImageURI(data?.data)
            dialog.window?.setLayout(1000,1500)
        }
        add.setOnClickListener {
            val img = data?.data
            val name = name1.text.toString()
            val number = number.text.toString()
            a.add(
                item_content(
                    img,
                    name,
                    number
                )
            )
            dialog.dismiss()
            contactAdapter.notifyDataSetChanged()
            rv.layoutManager = LinearLayoutManager(this)
            rv.adapter= contactAdapter
        }
    }
    }
