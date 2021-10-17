package com.example.simplebuttonlistenerbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var bkotlin: Button
    lateinit var bxml: Button
    private lateinit var text1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bkotlin = findViewById(R.id.bkotlin)
        bxml = findViewById(R.id.bxml)

        bkotlin.setOnClickListener { Toast.makeText(this, "coding",Toast.LENGTH_SHORT).show() }

        try{
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("xmlButton.xml")
            text1 = parser.parse(iStream)
            var text = text1
            bxml.setOnClickListener { Toast.makeText(this, "$text",Toast.LENGTH_SHORT).show() }
        }catch (e: IOException) {
            println("ISSUE: $e")
        }

    }
}