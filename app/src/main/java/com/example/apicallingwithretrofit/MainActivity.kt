package com.example.apicallingwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
 var mAdapter = MyDataAdapter(this)
    var datalist= ArrayList<ModelClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //myRecyleView.hasFixedSize()
//        myRecyleView.layoutManager = LinearLayoutManager(this)

        //myRecyleView.adapter = mAdapter

        fetchData()
    }


    fun fetchData() {

        val api: Call<ArrayList<ModelClass>> = Singlleton.apiInstance.getData()

        api.enqueue(object : Callback<ArrayList<ModelClass>> {
            override fun onResponse(
                call: Call<ArrayList<ModelClass>>,
                response: Response<ArrayList<ModelClass>>
            ) {

                val res: List<ModelClass>? = response.body()
                if (res != null) {
                    for (i in 0 until res.size) {

                        res.get(i)
                        val model = ModelClass(
                            res.get(i).id,
                            res.get(i).title,
                            res.get(i).price,
                            res.get(i).description,
                            res.get(i).category
                        )

                        datalist.add(model)
                        Log.d("ok", " id: ${model.id}")
                        Log.d("ok", "title: ${model.title}")
                        Log.d("ok", "REpo CLass: ${model}")

                    }
                }

                myRecyleView.layoutManager = LinearLayoutManager(applicationContext)
                mAdapter.updateAllProductList(datalist)
                myRecyleView.adapter = mAdapter


            }

            override fun onFailure(call: Call<ArrayList<ModelClass>>, t: Throwable) {
                Log.d("ok", "Api Error ${t.message}")
            }


            //           override fun onResponse(call: Call<List<ModelClass>>, response: Response<List<ModelClass>>) {
//                val respo:ModelClass?= response.body()
//                if(respo != null)
//                {
//                    Log.d("ok", " id: ${respo.id}")
//                    Log.d("ok", "title: ${respo.title}")
//                    Log.d("ok", "REpo CLass: ${respo}")
//
//                }
//            }
//
//            override fun onFailure(call: Call<ModelClass>, t: Throwable) {
//                Log.d("ok", "Api Error ${t.message}")
//            }

        })

    }


}