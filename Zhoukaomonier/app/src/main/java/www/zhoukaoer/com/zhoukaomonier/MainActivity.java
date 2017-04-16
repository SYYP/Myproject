package www.zhoukaoer.com.zhoukaomonier;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import www.zhoukaoer.com.zhoukaomonier.Adpter.MyCBaseAdpter;
import www.zhoukaoer.com.zhoukaomonier.Beans.Beans;


import www.zhoukaoer.com.zhoukaomonier.fragment.MyFragment;
import www.zhoukaoer.com.zhoukaomonier.uri.url;
import www.zhoukaoer.com.zhoukaomonier.utils.HttpUtil;


public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private ImageView ivleft;
    private List<Beans.DataBean> clist;
    private List<Fragment> fragments;
    private List<String> urls;
    private ListView clv;
    private SlidingMenu menu;
  private Handler handler=new Handler(){
      @Override
      public void handleMessage(Message msg) {
          super.handleMessage(msg);
          if(msg.what==1){
              String messges = (String) msg.obj;
              Gson gson = new Gson();
              Beans beans = gson.fromJson(messges, Beans.class);
              List<Beans.DataBean> data = beans.getData();
              for (int i=0;i<data.size();i++){
                  Beans.DataBean bd = new Beans.DataBean();
                  String name = data.get(i).getName();
                  bd.setName(name);
                  clist.add(bd);
              }
          }
          clv.setAdapter(new MyCBaseAdpter(MainActivity.this,clist));
      }

  };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = new SlidingMenu(this);
        initData();
      //  addCeHua();
        new HttpUtil(handler,url.url).start();


    }

    private void initData() {
        ivleft = (ImageView) findViewById(R.id.ivleft);
        clist = new ArrayList<Beans.DataBean>();
        urls = new ArrayList<String>();
        addCeHua();
        urls.add(url.irl2);
        urls.add(url.url3);
        urls.add(url.url4);
        fragments = new ArrayList<Fragment>();
        for (int i =0;i<urls.size();i++){
            fragments.add(new MyFragment(urls.get(i)));
        }
    }
    //添加侧滑页面
    private void addCeHua() {
        // configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        int height = metric.heightPixels;
        menu.setBehindOffset(width / 3);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

        menu.setMenu(R.layout.cehua_activity);
        ivleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               menu.toggle();
            }
        });
        clv = (ListView) menu.findViewById(R.id.clv);


        clv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.frame,fragments.get(i));
                transaction.commit();
            }
        });
    }

}
