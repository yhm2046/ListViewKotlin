package com.example.listviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.listviewkotlin.databinding.ActivityMainBinding

/**
 * listview 应用
 * 参考：https://www.tutorialkart.com/kotlin-android/kotlin-android-listview-example/
 * https://www.cnblogs.com/inthecloud/p/13252492.html
 */
class MainActivity : AppCompatActivity() {
    //指定数据
    private val tag="MainActivity:tag"
    private val dataList=ArrayList<DataList>()
//    var array = arrayOf("Melbourne", "Vienna", "Vancouver", "Toronto", "Calgary", "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg", "Munich", "New York", "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    var binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
//        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array)
//        val listView=binding.listView
//        listView.adapter=adapter
    initData()
    val adapter = DataAdapter(this, R.layout.list_items, dataList)
    binding.listView.adapter = adapter
//    增加点击事件
    binding.listView.setOnItemClickListener { _, _, position, _ ->
            val data = dataList[position]
//            Toast.makeText(this, data.dContent, Toast.LENGTH_LONG).show()
            setTitle("click $position")
            Log.d(tag,"show position $position:${data.dTitle}")
        }
    }//end oncreate

    private fun initData(){
        for (i in 0..19){
            println("add $i")
            dataList.add(DataList("Titel$i","Content$i",R.drawable.ic_launcher_background))
        }
        dataList.add(DataList("Titel20","fail",R.drawable.ic_launcher_background))
        dataList.add(DataList("Titel21","pass",R.drawable.ic_launcher_background))
    }//end initData
}