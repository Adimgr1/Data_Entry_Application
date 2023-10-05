package com.aditya.data_entry

import android.app.Dialog
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.WindowManager.LayoutParams
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
     lateinit var img :ImageView
    lateinit var rv: RecyclerView
    lateinit var floatbtn1: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv= findViewById(R.id.rv)
        floatbtn1=findViewById(R.id.floatbtn1)
        floatbtn1.setOnClickListener {
            showDialog()



        }
        }
    private fun showDialog(){
        val dialog =Dialog(this)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialogbox)
        dialog.window?.setLayout(1000,900)
        val name :EditText= dialog.findViewById(R.id.dialogedt1)
        val number: EditText = dialog.findViewById(R.id.dialogedt2)
        val chooseImage:Button = dialog.findViewById(R.id.chooseImage)
        val add :Button = dialog.findViewById(R.id.addContact)
         img= dialog.findViewById(R.id.img)
        chooseImage.setOnClickListener {
            val a = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(a,100)
        }
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100 && resultCode== RESULT_OK){
            img.setImageURI(data?.data)
        }
    }
    }
