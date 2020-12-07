package com.unita.kotlinexamples

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var url:String="http://192.168.100.201/kotlin/greetings.php"
        var rq:RequestQueue=Volley.newRequestQueue(this)
        var sr= StringRequest(Request.Method.GET,url, {

            response ->
            textView4.text=response
        },
            {
                    error ->
                textView4.text=error.message

            }
        )
        rq.add(sr)



        var sp= getSharedPreferences("my_data", MODE_PRIVATE)
        rdo_blue.setOnClickListener()
        {
            screen.setBackgroundColor(Color.parseColor("#FFBB86FC"))
        }
        rdo_black.setOnClickListener()
        {
            screen.setBackgroundColor(Color.parseColor("#FF6200EE"))
        }
        rdo_yellow.setOnClickListener()
        {
            screen.setBackgroundColor(Color.parseColor("#FF3700B3"))
        }
        button.setOnClickListener()
        {
            var name:String=editTextTextPersonName.text.toString().toString()
            var password:String=editTextTextPassword.text.toString().toString()
            var con:String=name+password
            Toast.makeText(this, "This result is "+con, Toast.LENGTH_LONG).show()
            var editor= sp.edit()
            editor.putString("name", name)
            editor.commit()

            var i = Intent(this, HomeActivity::class.java)
            i.putExtra("name", name)
            startActivity(i)


        }








    }
}