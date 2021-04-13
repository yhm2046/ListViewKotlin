package com.example.listviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.listviewkotlin.databinding.ActivityMainBinding

/**
 * listview 应用
 * 参考：https://www.tutorialkart.com/kotlin-android/kotlin-android-listview-example/
 * https://www.cnblogs.com/inthecloud/p/13252492.html
 */
class MainActivity : AppCompatActivity() {
    //指定数据
    private val dataList=ArrayList<DataList>()
//    var array = arrayOf("Melbourne", "Vienna", "Vancouver", "Toronto", "Calgary", "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg", "Munich", "New York", "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array)
//        val listView=binding.listView
//        listView.adapter=adapter
        initData()
        val adapter=DataAdapter(this,R.layout.list_items,dataList)
        binding.listView.adapter=adapter
    }//end oncreate
    private fun initData(){
        for (i in 0..20){
            println("add $i")
            dataList.add(DataList("Titel+$i","Content+$i",R.drawable.ic_launcher_background))
        }
    }//end initData
}