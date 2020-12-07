package com.unita.kotlinexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_json.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class JsonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)
        var url:String = "http://192.168.100.201/kotlin/example2.php"
        var url_image = "http://192.168.100.201/kotlin/cart.png"
        Picasso.with(this).load(url_image).into(img_emps)
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var list=ArrayList<String>()
        var result:String=""
        var jar= JsonArrayRequest(
            Request.Method.GET,url,null, {

                    response ->
                for (x in 0..response.length()-1) {

                    result += (response.getJSONObject(x).getString("FirstName") + " - " +
                            response.getJSONObject(x).getString("City"))
                    emps.text=result
                }



        },
            {
                    error ->
                emps.text=error.message

            }
        )
        rq.add(jar)
    }
}