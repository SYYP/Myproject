package com.xianmuyi.ypu.myprojectdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.xianmuyi.ypu.myprojectdemo.Asny.MyAsnytask;
import com.xianmuyi.ypu.myprojectdemo.adapter.Myadapter;
import com.xianmuyi.ypu.myprojectdemo.bean.User;
import com.xianmuyi.ypu.myprojectdemo.urL.Uri;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
//private List<User.ListBean> list=new ArrayList<User.ListBean>();
    private ListView listview;
    private List<User.ListBean> list;
    private Myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得资源ID
        listview = (ListView) findViewById(R.id.listview);
        //创建异步线程
        MyAsnytask asy=new MyAsnytask();
        //开启线程
        asy.execute(Uri.uri1);
        asy.huidiao(new MyAsnytask.Jiekou() {




            @Override
            public void Jiekoustr(String str) {
                Gson gson = new Gson();//创建一个Gson
                //将获取的json串转换成javaBean
                User user = gson.fromJson(str, User.class);
                list = user.getList();
                adapter = new Myadapter(list,MainActivity.this);
                listview.setAdapter(adapter);//添加适配器
            }

        });
       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(MainActivity.this,"id为"+list.get(position).getId(),Toast.LENGTH_LONG).show();
           }
       });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                list.remove(i);
                adapter.notifyDataSetChanged();
                return false;

            }
        });
    }
}
