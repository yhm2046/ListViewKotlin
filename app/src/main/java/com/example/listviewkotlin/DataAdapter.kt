package com.example.listviewkotlin

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(activity:Activity,val resourceId:Int,data:List<DataList>) :ArrayAdapter<DataList>(activity,resourceId,data){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view:View
        val viewHolder:ViewHolder
        if (convertView==null){
            view=LayoutInflater.from(context).inflate(resourceId,parent,false)
            val dImage:ImageView=view.findViewById(R.id.imageView)
            val dTitle:TextView=view.findViewById(R.id.tvTitle)
            val dContent:TextView=view.findViewById(R.id.tvContent)
            viewHolder=ViewHolder(dImage,dTitle,dContent)
            view.tag=viewHolder
        }else{
            view=convertView
            viewHolder=view.tag as ViewHolder
        }
        val data=getItem(position)
        val titleTxt= data?.dContent
        if (data!=null){
            viewHolder.dImage.setImageResource(data.dImageId)
            viewHolder.dTitle.setText(data.dTitle)
            viewHolder.dContent.setText(data.dContent)
            when(titleTxt){
                "fail"->viewHolder.dTitle.setTextColor(Color.RED)
                "pass"->viewHolder.dTitle.setTextColor(Color.GREEN)
                else -> viewHolder.dTitle.setTextColor(Color.BLUE)
            }
//            if (titleTxt.equals("fail"))    viewHolder.dTitle.setTextColor(Color.RED)
//            else if (titleTxt.equals("pass"))    viewHolder.dTitle.setTextColor(Color.GREEN)
//             else  viewHolder.dTitle.setTextColor(Color.BLUE)
        }
        return view
    }//end getView
    inner class ViewHolder(val dImage:ImageView,val dTitle:TextView,val dContent:TextView)
}