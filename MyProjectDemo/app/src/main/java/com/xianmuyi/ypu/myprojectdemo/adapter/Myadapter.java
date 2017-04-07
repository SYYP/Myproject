package com.xianmuyi.ypu.myprojectdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xianmuyi.ypu.myprojectdemo.R;
import com.xianmuyi.ypu.myprojectdemo.bean.User;

import java.util.List;

/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */

public class Myadapter extends BaseAdapter {
    private List<User.ListBean> list;
    private Context context;

    public Myadapter(List<User.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            holder.text1= (TextView) convertView.findViewById(R.id.text1);
            holder.text2= (TextView) convertView.findViewById(R.id.text3);
            convertView.setTag(holder);
        }
        else{
           holder= (ViewHolder) convertView.getTag();
        }
        holder.text1.setText(list.get(position).getSite_name());
        holder.text2.setText(list.get(position).getAddress());
        return convertView;
    }

      class ViewHolder{

          TextView text1,text2;

      }
}
