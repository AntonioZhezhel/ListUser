package com.example.listuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.listuser.data.DataUser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dataList: MutableList<com.example.listuser.data.Result> = mutableListOf()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(dataList)

        recyclerViewUser.layoutManager = LinearLayoutManager(this)
        recyclerViewUser.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        recyclerViewUser.adapter = adapter



        adapter.callback = object: UserAdapter.Callback{

            override fun onItemClicked(item: com.example.listuser.data.Result) {


                val intent = Intent(applicationContext,ProfileActivity::class.java)
                intent.putExtra("photoProfile",item.picture.large)
                intent.putExtra("name",item.name.first+ " " + item.name.last)
                intent.putExtra("age",item.registered.age)
                intent.putExtra("cellPhone",item.cell)
                intent.putExtra("email",item.email)
                intent.putExtra("skype",item.login.username)

                startActivity(intent)


            }
        }

        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://randomuser.me/api/?results=20")
                .build()
                .getAsObject(DataUser::class.java, object : ParsedRequestListener<DataUser> {
                    override fun onResponse(response: DataUser) {
                        dataList.addAll(response.results)
                        adapter.notifyDataSetChanged()
                    }

                    override fun onError(anError: ANError?) {
                        println("error")
                    }
                })




    }
}