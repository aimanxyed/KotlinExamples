package com.unita.kotlinexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        tv_name.text= "welcome" + intent.getStringExtra("name")
        var sp = getSharedPreferences("my_data", MODE_PRIVATE)
        tv_name2.text=sp.getString("name","default")

        btn_search.setOnClickListener()
        {
            var url:String = "http://192.168.100.201/kotlin/example.php?Id="+ed_id.text.toString()
            var rq:RequestQueue = Volley.newRequestQueue(this)
            var jor= JsonObjectRequest(
                Request.Method.GET,url,null, {

                    response ->
                    tv_name1.text=response.getString("FirstName")
                    tv_salary.text=response.getString("City")

            },
                {
                        error ->
                    tv_name1.text=error.message


                }
            )
            rq.add(jor)
            var i = Intent(this, JsonActivity::class.java)

            startActivity(i)


        }


    }
}