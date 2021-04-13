package com.example.listviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import com.example.listviewkotlin.databinding.ActivityMainBinding

/**
 * listview 应用参考：https://www.tutorialkart.com/kotlin-android/kotlin-android-listview-example/
 */
class MainActivity : AppCompatActivity() {
    //指定数据
    var array = arrayOf("Melbourne", "Vienna", "Vancouver", "Toronto", "Calgary", "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg", "Munich", "New York", "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array)
        val listView=binding.listView
//        val listView:ListView=binding.listView
//        val listView:ListView=findViewById(R.id.listView)
//        val textView:TextView=findViewById(R.id.textView)
//        textView.setText("abc")
        listView.adapter=adapter
    }
}