package www.zhoukaoer.com.zhoukaomonier.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import www.zhoukaoer.com.zhoukaomonier.Adpter.MyBaseAdpter;
import www.zhoukaoer.com.zhoukaomonier.Beans.JsonBean;
import www.zhoukaoer.com.zhoukaomonier.R;
import www.zhoukaoer.com.zhoukaomonier.utils.HttpUtil;


/**
 * author: Administrator
 * date: 2017/4/15.
 */

public class MyFragment extends Fragment {
    private ListView lv;
    private List<JsonBean.DataBean> list;
    private String url;

    public MyFragment(String url) {
        this.url = url;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.xleftfragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

    }



    private void initData() {
        lv = (ListView) getView().findViewById(R.id.lv);
        list = new ArrayList<JsonBean.DataBean>();
        jxdata();


    }
    public void jxdata(){
        Handler myhandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==1){
                    String messges = (String) msg.obj;
                    Gson gson = new Gson();
                    JsonBean jsonBean = gson.fromJson(messges, JsonBean.class);
                    List<JsonBean.DataBean> data = jsonBean.getData();
                    for (int i=0;i<data.size();i++){
                        JsonBean.DataBean jd = new JsonBean.DataBean();
                        String title = data.get(i).getTitle();
                        String apply = data.get(i).getApply();
                        String buy_price = data.get(i).getBuy_price();
                        jd.setTitle(title);
                        jd.setApply(apply);
                        jd.setBuy_price(buy_price);
                        list.add(jd);
                    }
                }

            MyBaseAdpter adpter = new MyBaseAdpter(getContext(),list);
            lv.setAdapter(adpter);
            }
        };
        new HttpUtil(myhandler,url).start();
    }
}
