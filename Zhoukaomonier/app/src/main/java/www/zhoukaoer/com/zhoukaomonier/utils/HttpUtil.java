package www.zhoukaoer.com.zhoukaomonier.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

import www.zhoukaoer.com.zhoukaomonier.StreanUtil.StreanJson;


/**
 * Created by ypu on 2017/3/16.
 */

public class HttpUtil extends Thread{

      private String  rul;
     private Handler handler;

    private String json;


    public HttpUtil(Handler handler, String rul) {
        this.handler = handler;
        this.rul = rul;
    }


    @Override
    public void run() {

       String url= DoPost(rul);
        if(url!=null){
            Message mes=new Message();
            mes.what=1;
            mes.obj=url;
            handler.sendMessage(mes);


        }
        super.run();
    }

      public String DoPost(String rul){
          //初始化HttpURlConnecton
          HttpURLConnection connection=null;
          try {
              URL uri=new URL(rul);
              connection= (HttpURLConnection) uri.openConnection();
              //获得请求方式
            connection.setRequestMethod("GET");
              connection.setConnectTimeout(5000);
              connection.setRequestProperty("encoding","UTF-8");
              //读取
              Log.d("Tag","----~~~~~"+connection.getResponseCode());
              if(connection.getResponseCode()==200){

                  json = StreanJson.getJson(connection.getInputStream());
                  Log.e("tag","json------------"+json);

              }
          }catch (Exception e){
              e.printStackTrace();
          }
          finally {
              if(connection!=null){
                  //关闭连接
                  connection.disconnect();
              }
          }

        return  json.toString();
      }
}
